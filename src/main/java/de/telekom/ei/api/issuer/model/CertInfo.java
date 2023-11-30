package de.telekom.ei.api.issuer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertInfo {

  private String kid;

  private String kty;

  private String alg;

  private String use;

  private String n;

  private String e;

  private List<String> x5c;

  private String x5t;

  @JsonProperty("x5t#S256")
  private String x5tS256;
}
