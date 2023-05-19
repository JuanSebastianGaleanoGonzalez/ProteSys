package com.protesys.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakResolverConfig {

    // To configure keycloak from application.properties
    // https://www.thomasvitale.com/spring-security-keycloak/
    // It must be in a separate file (not inheriting
    // KeycloakWebSecurityConfigurerAdapter) to avoid a circular dep bug
    // https://stackoverflow.com/questions/70207564/spring-boot-2-6-regression-how-can-i-fix-keycloak-circular-dependency-in-adapte
    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}