package br.cefetrj.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

import br.cefetrj.service.ContaService;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig
{
    @Autowired
    private ContaService contaService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource) throws Exception
    {
        http.cors(cors -> cors.configurationSource(corsConfigurationSource)).csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authz -> authz.requestMatchers("/auth/google/**").permitAll().anyRequest().authenticated())
        .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(new CustomJwtAuthConverter(contaService))));

        return http.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
    {
        return configuration.getAuthenticationManager();

    }

}
