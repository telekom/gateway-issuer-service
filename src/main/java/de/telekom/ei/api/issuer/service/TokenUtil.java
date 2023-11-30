package de.telekom.ei.api.issuer.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.telekom.ei.api.issuer.controller.IssuerController;
import de.telekom.ei.api.issuer.model.CertsInfo;
import de.telekom.ei.api.issuer.model.RealmInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TokenUtil {

  public static Jwt<Header, Claims> getClaims(String consumerToken) {

    int i = consumerToken.lastIndexOf('.');
    String withoutSignature = consumerToken.substring(7, i + 1);

    return Jwts.parser().parseClaimsJwt(withoutSignature);
  }

  public static Map<String, CertsInfo> loadCerts() throws IOException {
    String securityFileCerts = "certs.json";
    Path certsFile =
        Path.of(
            System.getProperty("user.dir")
                + File.separator
                + IssuerController.getSecurityPath()
                + File.separator
                + securityFileCerts);
    TypeReference<HashMap<String, CertsInfo>> typeRef = new TypeReference<>() {};

    return new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
        .readValue(Files.readString(certsFile), typeRef);
  }

  public static Map<String, RealmInfo> loadPublicKeys() throws IOException {
    String securityFilePublic = "public.json";
    Path publicKeysFile =
        Path.of(
            System.getProperty("user.dir")
                + File.separator
                + IssuerController.getSecurityPath()
                + File.separator
                + securityFilePublic);
    TypeReference<HashMap<String, RealmInfo>> typeRef = new TypeReference<>() {};

    return new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true)
        .readValue(Files.readString(publicKeysFile), typeRef);
  }
}
