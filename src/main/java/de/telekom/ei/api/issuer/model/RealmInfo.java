// SPDX-FileCopyrightText: 2023 Deutsche Telekom AG
//
// SPDX-License-Identifier: Apache-2.0

package de.telekom.ei.api.issuer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealmInfo {

  private String realm;
  private String public_key;
}
