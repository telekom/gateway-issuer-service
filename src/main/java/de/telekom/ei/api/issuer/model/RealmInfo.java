package de.telekom.ei.api.issuer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealmInfo {

  private String realm;
  private String public_key;
}
