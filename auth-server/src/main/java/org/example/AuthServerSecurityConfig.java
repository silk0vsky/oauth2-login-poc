package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration(proxyBeanMethods = false)
public class AuthServerSecurityConfig {

  @Bean
  InMemoryUserDetailsManager userDetailsService() {
    UserDetails user = User.withDefaultPasswordEncoder()
        .username("admin")
        .password("password")
        .roles("ADMIN", "USER")
        .build();

    UserDetails service = User.withDefaultPasswordEncoder()
        .username("service")
        .password("password")
        .roles("SERVICE")
        .build();
    return new InMemoryUserDetailsManager(user, service);
  }

}
