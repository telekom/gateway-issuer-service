<!--
SPDX-FileCopyrightText: 2023 Deutsche Telekom AG

SPDX-License-Identifier: CC0-1.0    
-->

# Issuer-service

## About

Enables customers to validate Oauth2 tokens issued by related Gateway. Following endpoints are available:

* Token endpoint
* Discovery endpoint
* Certificate endpoint
* Userinfo endpoint

## Code of Conduct

This project has adopted the [Contributor Covenant](https://www.contributor-covenant.org/) in version 2.1 as our code of conduct. Please see the details in our [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md). All contributors must abide by the code of conduct.

By participating in this project, you agree to abide by its [Code of Conduct](./CODE_OF_CONDUCT.md) at all times.

## Licensing

This project follows the [REUSE standard for software licensing](https://reuse.software/).
Each file contains copyright and license information, and license texts can be found in the [./LICENSES](./LICENSES) folder. For more information visit https://reuse.software/.

## Building

### Packaging the application

This project is built with [Maven](https://maven.apache.org/). It is validated to be compatible with version 3.9.x. To build the project, run:

```bash
  ./mvnw clean package
```

This will build the project and run all tests. The resulting artifacts will be placed in the `target` directory.

### Building the Docker image

The project contains a Dockerfile that can be used to build a Docker image. To build the image, run:

```bash
  docker build --platform linux/amd64 -t issuer-service .
```

This will build the image and tag it as `issuer-service:latest`.

### Multi-stage Docker build

Alternatively, you can use the multi-stage Docker build to build the image. This will build the application in a Maven container and then copy the resulting artifacts into a smaller container. To build the image, run:

```bash
  docker build --platform linux/amd64 -t issuer-service -f Dockerfile.multi-stage .
```

## Token endpoint
Provides public key for given realm. Can be obtained from:

<em>Note: please be aware, that example is showing local endpoint, which will differ to exposed one!</em> 

``curl -X GET \
http://${host}:${port}/api/v1/issuer/${realm}``

As a result, you should get a response as follows:

``
{
"realm": "default",
"public_key": "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA061GdxffIBvqgozjnCvkEd48++lh5ERUjSGLoAWCbp3Y4Lf7S3GiWN25+673Tfxb29LKe6evSl7yKT2b105JuwGokx2Geedw2BVkQhRZXpDbG5NV/4n3186SN77sEeuuuXW2QqrX9MmSGdX4CvZ6DjCOtRAA4cV/i+o77NLWpT7kx8YxWyMrAWJxxEOF1Y9suwz9d2hjOn2oeebf6GpbfaM4wJJdSgWeqyTzrF+Jr4rQeGP7gjAhrJWAEadQl0wUzwQoTIQlcUQ43Xo0N8KKP/Pj6r0fOwHQ7dKIXhnAiIV1L8boe+YkrW1ZRKVjAc3lNpKoFK1TQvDJRqnxG/E6aQIDAQAB"
}
``

## Certificate endpoint
Provides list of certificates. Correct one is matched based on key id ``kid`` from authorization token header. Can be obtained from:

``curl -X GET \
http://${host}:${port}/api/v1/certs/${realm}``

As a result, you should get a response as follows:

``
{
"keys": [
{
"kid": "6288e36f-b0d2-42c7-b739-1bd6c4ef0746",
"kty": "RSA",
"alg": "RS256",
"use": "sig",
"n": "061GdxffIBvqgozjnCvkEd48--lh5ERUjSGLoAWCbp3Y4Lf7S3GiWN25-673Tfxb29LKe6evSl7yKT2b105JuwGokx2Geedw2BVkQhRZXpDbG5NV_4n3186SN77sEeuuuXW2QqrX9MmSGdX4CvZ6DjCOtRAA4cV_i-o77NLWpT7kx8YxWyMrAWJxxEOF1Y9suwz9d2hjOn2oeebf6GpbfaM4wJJdSgWeqyTzrF-Jr4rQeGP7gjAhrJWAEadQl0wUzwQoTIQlcUQ43Xo0N8KKP_Pj6r0fOwHQ7dKIXhnAiIV1L8boe-YkrW1ZRKVjAc3lNpKoFK1TQvDJRqnxG_E6aQ",
"e": "AQAB",
"x5c": [
"MIIDITCCAgmgAwIBAgIUSpT62Euj58/ur9xX/B3fhboAEwEwDQYJKoZIhvcNAQELBQAwIDEeMBwGA1UEAwwVU3RhcmdhdGUudGVzdC5kZWZhdWx0MB4XDTIzMTEwOTE0MDA0NloXDTI2MDgwNTE0MDA0NlowIDEeMBwGA1UEAwwVU3RhcmdhdGUudGVzdC5kZWZhdWx0MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA061GdxffIBvqgozjnCvkEd48++lh5ERUjSGLoAWCbp3Y4Lf7S3GiWN25+673Tfxb29LKe6evSl7yKT2b105JuwGokx2Geedw2BVkQhRZXpDbG5NV/4n3186SN77sEeuuuXW2QqrX9MmSGdX4CvZ6DjCOtRAA4cV/i+o77NLWpT7kx8YxWyMrAWJxxEOF1Y9suwz9d2hjOn2oeebf6GpbfaM4wJJdSgWeqyTzrF+Jr4rQeGP7gjAhrJWAEadQl0wUzwQoTIQlcUQ43Xo0N8KKP/Pj6r0fOwHQ7dKIXhnAiIV1L8boe+YkrW1ZRKVjAc3lNpKoFK1TQvDJRqnxG/E6aQIDAQABo1MwUTAdBgNVHQ4EFgQUQ/x0rBBxkjI5C2xWRag8B/uVKxswHwYDVR0jBBgwFoAUQ/x0rBBxkjI5C2xWRag8B/uVKxswDwYDVR0TAQH/BAUwAwEB/zANBgkqhkiG9w0BAQsFAAOCAQEAw8cyIHzoqEblBL8k0yue6b34YqriukC3JtnkB/WWcGWgMkLwVz0ZFP7yQkBoCqRd12On5SgFF+nyXNLpN05jj8L9q4W7o/3nli3s3U4fIXY408HTK5ujSehcORZBTFeghr16PAahZr68nCyzdU3/hisHgsOHY3MRKqHtleeKDKlvZ4dtWyM2TKKDff1FdRaThrgEIY/CJHTwVffe18LC8HE58PMIcqM8IsONuWOdDjLHdxcXdrLqr98dluXE7Lu3HPT2lOoZh/PP5a1WjADURI2s4czI2qQrZs+et68rtwb/q83WJdX3TA6Gw5XZoiyfhjyWNJ63U7pTI5eblXRwyQ=="
],
"x5t": "VK5ICOrx8xcyBDGpzxCbhIjib58",
"x5t#S256": "EMtOvNVQz_1YCfF9cj2WYz_ZgEbYQXvyHaXKJX5K3Hg"
}
]
}
``

## Discovery endpoint

Provides a discovery document from which clients can obtain all necessary information to interact with Issuer Service, including endpoint locations and capabilities.

The discovery document can be obtained from:

``curl -X GET \
http://${host}:${port}/api/v1/discovery/${realm}``

As a result, you should get a response as follows:

``
{
"issuer": "${host}:${port}/auth/realms/default",
"jwks_uri": "${host}:${port}/auth/realms/default/protocol/openid-connect/certs",
"authorization_endpoint": "${host}:${port}/auth/realms/default/protocol/openid-connect/auth",
"response_types_supported": [
"none"
],
"subject_types_supported": [
"public"
],
"id_token_signing_alg_values_supported": [
"RS256"
]
}
``

## Userinfo endpoint
If provided token is successfully validate against given public key & issuer, provides basic information for particular user.

The userinfo document can be obtained from:

``curl --request GET \
--url http://${host}:${port}/api/v1/userinfo/default \
--header 'Authorization: Bearer <token>'``

Example response for validated response would be:

``
{
"sub": "b1c71897-fc93-466f-85df-60e0ae86bd98",
"email_verified": false,
"preferred_username": "service-account-test-consumer"
}``

## Authorization endpoint
Not implemented on Issuer Service. 

## How to generate a new (self-signed) certificate to be used with the Issuer Service

### Docker-based

If you are running in a different environment, you can build and use a Docker container to generate the certificate. To do so, run the following command:

```bash
docker build --platform linux/amd64 -t issuer-service-cert-generator -f Dockerfile.cert-gen .
mkdir keys
docker run --rm -v ./keys:/opt/app/keys -it issuer-service-cert-generator /bin/bash -c "DOMAIN=gateway.test ./createKeys.sh"
```

This will create the necessary keys in the `keys` directory.

### WSL2
If you are using a WSL2 environment, you can use the following command to generate a new self-signed certificate:

```bash
DOMAIN=gateway.test ./createKeys.sh
```
This will create the necessary keys in the `keys` directory.
