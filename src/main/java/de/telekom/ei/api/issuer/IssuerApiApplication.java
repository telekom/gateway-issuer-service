package de.telekom.ei.api.issuer;

import de.telekom.ei.api.issuer.model.DiscoveryInfo;
import de.telekom.ei.api.issuer.model.UserInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IssuerApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(IssuerApiApplication.class, args);
  }

  @Bean
  public DiscoveryInfo discoveryInfo() {
    return new DiscoveryInfo();
  }

  @Bean
  public UserInfo userInfo() {
    return new UserInfo();
  }
}
