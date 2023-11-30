#!/bin/bash

function base64url_encode {
  base64  \
  | sed s/\\+/-/g \
  | sed s/\\//_/g \
  | sed -E s/=+$//
}

function generate_keys {
  #create private key + certificate
  openssl req -new -newkey rsa:2048 -nodes -keyout "$PRIVATE_KEY_FILE" -x509 -subj "//CN=${DOMAIN}" -days 1000 -out "$CERT_FILE"
  #create public key from private key
  openssl rsa -pubout -in "$PRIVATE_KEY_FILE" -out "$PUBLIC_KEY_FILE"
}

function line_separator {
  printf '#%.0s' {1..50}
  printf "\n"
}


#set variables
ENVIRONMENT=${1:-test}
REALM=${2:-default}
RUN=$(printf "%s" "$(date +%Y%m%d)")
WORKING_DIR=${ENVIRONMENT}_${REALM}_${RUN}
DOMAIN="Stargate.${ENVIRONMENT}.${REALM}"
if [ -z "$KID" ]; then
  KID=$(uuidgen)
fi

PUBLIC_KEY_FILE="public.pem"
PRIVATE_KEY_FILE="private.key"
CERT_FILE="cert.pem"

#list variables
line_separator
printf "ENVIRONMENT: %s, REALM: %s, RUN: %s => WORKING_DIR: %s\n" "$ENVIRONMENT" "$REALM" "$RUN" "$WORKING_DIR"
printf "DOMAIN: %s\n" "$DOMAIN"
printf "KID: %s\n" "$KID"

mkdir -p "./keys/$WORKING_DIR"
pushd ./keys/"$WORKING_DIR" || exit

line_separator
if [ -f "$PUBLIC_KEY_FILE" ] && [ -f "$PRIVATE_KEY_FILE" ] && [ -f "$CERT_FILE" ]; then
  printf  "key files already exist\n"
else
  printf "generating new keys\n"
  generate_keys
fi

line_separator

PUBLIC_JSON=$( jq -n \
  --arg env "$REALM" \
  --arg public "$(sed -e '1d;$d' < "$PUBLIC_KEY_FILE" | sed -z 's/\n//g')" \
  '{ $env: {realm: $env, public_key: $public}}'
)
echo "$PUBLIC_JSON" | jq | tee public.json

PRIVATE_JSON=$( jq -n \
  --arg env "$REALM" \
  --arg kid "$KID" \
  --arg pk "$(sed -e '1d;$d' < "$PRIVATE_KEY_FILE" | sed -z 's/\n//g')" \
  '{ $env: {kid: $kid, pk: $pk}}'
)
echo "$PRIVATE_JSON" | jq | tee private.json

CERT_JSON=$( jq -n \
  --arg env "$REALM" \
  --arg kid "$KID" \
  --arg kty "RSA" \
  --arg alg "RS256" \
  --arg use "sig" \
  --arg n "$(openssl x509 -in "$CERT_FILE" -noout -modulus | sed 's/Modulus=//' | xxd -r -ps | base64url_encode | sed -z 's/\n//g')" \
  --arg e "AQAB" \
  --arg x5c "$(sed -e '1d;$d' < "$CERT_FILE" | sed -z 's/\n//g')" \
  --arg x5t "$(openssl x509 -in "$CERT_FILE" -outform DER | shasum | xxd -r -ps | base64url_encode)" \
  --arg x5t256 "$(openssl x509 -in "$CERT_FILE" -outform DER | sha256sum | xxd -r -ps | base64url_encode)" \
  '{ $env: {keys: [{kid: $kid, kty: $kty, alg: $alg, use: $use, n: $n, e: $e, x5c: [$x5c], x5t: $x5t, "x5t#S256": $x5t256}]}   }'
)
echo "$CERT_JSON" | jq | tee certs.json

popd || exit

line_separator
printf "finished\n"
