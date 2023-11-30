// SPDX-FileCopyrightText: 2023 Deutsche Telekom AG
//
// SPDX-License-Identifier: Apache-2.0

package de.telekom.ei.api.issuer.controller;

import static de.telekom.ei.api.issuer.service.TokenUtil.loadCerts;
import static de.telekom.ei.api.issuer.service.TokenUtil.loadPublicKeys;

import de.telekom.ei.api.issuer.model.*;
import de.telekom.ei.api.issuer.service.TokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import java.io.IOException;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class IssuerController {

  private final DiscoveryInfo discoveryInfo;
  private final UserInfo userInfo;

  @Value("${issuer.url}")
  private String issuerUrl;

  @Getter private static String securityPath;

  @Value("${issuer.security.dir:keypair}")
  private void setSecurityPath(String name) {
    securityPath = name;
  }

  @GetMapping("/issuer/{realm}")
  public ResponseEntity<RealmInfo> getPublicKey(@PathVariable String realm) {

    log.debug("Request received on issuer endpoint for realm {}", realm);

    Map<String, RealmInfo> realmInfoMap;

    try {
      realmInfoMap = loadPublicKeys();
    } catch (IOException e) {
      log.error("realm info not loaded due to {}", e.getMessage());
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, "problem occurred while loading public key");
    }

    if (!realmInfoMap.containsKey(realm)) {
      log.warn("public key not defined for realm: {}", realm);
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "public_key not defined for realm " + realm);
    }

    return new ResponseEntity<RealmInfo>(realmInfoMap.get(realm), HttpStatus.OK);
  }

  @GetMapping("/certs/{realm}")
  public ResponseEntity<CertsInfo> getCert(@PathVariable String realm) {

    log.debug("Request received on certs endpoint for realm {}", realm);

    Map<String, CertsInfo> certsInfoMap;

    try {
      certsInfoMap = loadCerts();
    } catch (IOException e) {
      log.error("certs info not loaded due to {}", e.getMessage());
      throw new ResponseStatusException(
          HttpStatus.INTERNAL_SERVER_ERROR, "problem occurred while loading certInfo");
    }

    if (!certsInfoMap.containsKey(realm)) {
      log.warn("certs not defined for realm: {}", realm);
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, "certInfo not defined for realm " + realm);
    }

    return new ResponseEntity<CertsInfo>(certsInfoMap.get(realm), HttpStatus.OK);
  }

  @GetMapping("/discovery/{realm}")
  public ResponseEntity<DiscoveryInfo> getDiscoveryUrl(@PathVariable String realm) {

    log.debug("Request received on discovery endpoint");

    discoveryInfo.setIssuerUrl(issuerUrl + "/" + realm);
    discoveryInfo.setJwksUrl(issuerUrl + "/" + realm + "/protocol/openid-connect/certs");
    discoveryInfo.setAuthorizationEndpointUrl(
        issuerUrl + "/" + realm + "/protocol/openid-connect/auth");

    return new ResponseEntity<DiscoveryInfo>(discoveryInfo, HttpStatus.OK);
  }

  @GetMapping("/auth/*")
  public ResponseEntity<AuthInfo> getAuthUrl() {

    log.debug("Request received on auth endpoint");

    return new ResponseEntity<AuthInfo>(new AuthInfo(), HttpStatus.NOT_IMPLEMENTED);
  }

  // todo remove endpoint as soon customers are migrated
  @GetMapping("/userinfo/{realm}")
  public ResponseEntity<UserInfo> getUserInfo(
      @RequestHeader(value = "Authorization") String token, @PathVariable String realm) {

    log.debug("Request received on userinfo endpoint, realm: {}", realm);

    Jwt<Header, Claims> claims = TokenUtil.getClaims(token);

    String clientId = claims.getBody().get("clientId", String.class);
    String sub = claims.getBody().getSubject();
    String issuer = claims.getBody().getIssuer();

    log.info("userinfo request for client:{}, with issuer:{}", clientId, issuer);

    userInfo.setPreferred_username("service-account-" + clientId);
    userInfo.setEmail_verified(false);
    userInfo.setSub(sub);

    return new ResponseEntity<>(userInfo, HttpStatus.OK);
  }
}
