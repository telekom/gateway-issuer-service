package de.telekom.ei.api.issuer.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertsInfo {

  private List<CertInfo> keys;
}
