// SPDX-FileCopyrightText: 2023 Deutsche Telekom AG
//
// SPDX-License-Identifier: Apache-2.0

package de.telekom.ei.api.issuer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiscoveryInfo {

  @JsonProperty("issuer")
  private String issuerUrl;

  @JsonProperty("jwks_uri")
  private String jwksUrl;

  @JsonProperty("authorization_endpoint")
  private String authorizationEndpointUrl;

  @JsonProperty("response_types_supported")
  private List<String> responseTypesSupported = List.of("none");

  @JsonProperty("subject_types_supported")
  private List<String> subjectTypesSupported = List.of("public");

  @JsonProperty("id_token_signing_alg_values_supported")
  private List<String> idTokenSigningAlgValuesSupported = List.of("RS256");
}
