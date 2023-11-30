// SPDX-FileCopyrightText: 2023 Deutsche Telekom AG
//
// SPDX-License-Identifier: Apache-2.0

package de.telekom.ei.api.issuer;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.telekom.ei.api.issuer.model.CertsInfo;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@RequiredArgsConstructor
public class IssuerApiApplicationTests {

  @Autowired private MockMvc mvc;

  @Value("${issuer.url}")
  private String issuerUrl;

  @Value("${issuer.security.certs}")
  private String issuerCerts;

  @Value("${issuer.security.public}")
  private String issuerPubkey;

  @Test
  public void issuerTest() throws Exception {

    mvc.perform(get("/issuer/default"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.realm").value("default"))
        .andExpect(jsonPath("$.public_key").value(issuerPubkey));
  }

  @Test
  public void certsTest() throws Exception {

    TypeReference<HashMap<String, CertsInfo>> typeRef = new TypeReference<>() {};

    CertsInfo certsInfo =
        new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
            .readValue(issuerCerts, typeRef)
            .get("default");

    String kid = certsInfo.getKeys().get(0).getKid();

    mvc.perform(get("/certs/default"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.keys").isArray())
        .andExpect(
            jsonPath("$.keys[?(@.kid==\"" + kid + "\")].kty")
                .value(certsInfo.getKeys().get(0).getKty()))
        .andExpect(
            jsonPath("$.keys[?(@.kid==\"" + kid + "\")].alg")
                .value(certsInfo.getKeys().get(0).getAlg()))
        .andExpect(
            jsonPath("$.keys[?(@.kid==\"" + kid + "\")].use")
                .value(certsInfo.getKeys().get(0).getUse()))
        .andExpect(
            jsonPath("$.keys[?(@.kid==\"" + kid + "\")].n")
                .value(certsInfo.getKeys().get(0).getN()))
        .andExpect(
            jsonPath("$.keys[?(@.kid==\"" + kid + "\")].e")
                .value(certsInfo.getKeys().get(0).getE()))
        .andExpect(
            jsonPath("$.keys[?(@.kid==\"" + kid + "\")].x5c.[0]")
                .value(certsInfo.getKeys().get(0).getX5c().get(0)))
        .andExpect(
            jsonPath("$.keys[?(@.kid==\"" + kid + "\")].x5t")
                .value(certsInfo.getKeys().get(0).getX5t()))
        .andExpect(
            jsonPath("$.keys[?(@.kid==\"" + kid + "\")].x5t#S256")
                .value(certsInfo.getKeys().get(0).getX5tS256()));
  }

  @Test
  public void discoveryTest() throws Exception {

    mvc.perform(get("/discovery/default"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.issuer").value(issuerUrl + "/default"))
        .andExpect(
            jsonPath("$.jwks_uri").value(issuerUrl + "/default/protocol/openid-connect/certs"))
        .andExpect(
            jsonPath("$.authorization_endpoint")
                .value(issuerUrl + "/default/protocol/openid-connect/auth"))
        .andExpect(jsonPath("$.response_types_supported[0]").value("none"))
        .andExpect(jsonPath("$.subject_types_supported[0]").value("public"))
        .andExpect(jsonPath("$.id_token_signing_alg_values_supported[0]").value("RS256"));
  }

  @Test
  public void authTest() throws Exception {

    mvc.perform(get("/auth/default"))
        .andExpect(status().isNotImplemented())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(
            jsonPath("$.info").value("This endpoint is unfortunately not available for Stargate"));
  }

  @Test
  public void userinfoTestNoAuthorization() throws Exception {

    mvc.perform(get("/userinfo/default"))
        .andExpect(status().isBadRequest())
        .andExpect(status().reason(containsString("Required request header 'Authorization'")));
  }
}
