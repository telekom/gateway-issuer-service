package de.telekom.ei.api.issuer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

  private String sub;
  private boolean email_verified;
  private String preferred_username;
}
