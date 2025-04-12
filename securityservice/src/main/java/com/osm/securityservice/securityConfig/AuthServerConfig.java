package com.osm.securityservice.securityConfig;


import com.osm.securityservice.userManagement.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class AuthServerConfig {

    private final CorsConfigurationSource corsConfigurationSource;
    private final RegisteredClientRepository registeredClientRepository;
    private final OAuth2AuthorizationService authorizationService;
    private final OAuth2TokenGenerator<?> tokenGenerator;
    private final AuthenticationManager authenticationManager;
    private final CustomTokenRequestConverter customTokenRequestConverter;
    private final UserService userService;

    public AuthServerConfig(CorsConfigurationSource corsConfigurationSource, RegisteredClientRepository registeredClientRepository, OAuth2AuthorizationService authorizationService, OAuth2TokenGenerator<?> tokenGenerator, AuthenticationManager authenticationManager, CustomTokenRequestConverter customTokenRequestConverter, UserService userService) {
        this.corsConfigurationSource = corsConfigurationSource;
        this.registeredClientRepository = registeredClientRepository;
        this.authorizationService = authorizationService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
        this.customTokenRequestConverter = customTokenRequestConverter;
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http
    ) throws Exception {
        OAuth2AuthorizationServerConfigurer authorizationServerConfigurer = getOAuth2AuthorizationServerConfigurer();
        http
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/oauth2/**", "/jwks", "/.well-known/**", "/actuator/**", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**").permitAll()
//                        .anyRequest().authenticated()
                                .anyRequest().permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .with(authorizationServerConfigurer, configurer -> {
                })
                .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));

        return http.build();
    }

    private OAuth2AuthorizationServerConfigurer getOAuth2AuthorizationServerConfigurer() {
        OAuth2AuthorizationServerConfigurer authorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer();
        authorizationServerConfigurer
                .tokenEndpoint(tokenEndpoint -> tokenEndpoint
                        .accessTokenRequestConverter(customTokenRequestConverter)
                        .authenticationProvider(new CustomTokenGrantAuthenticationProvider(
                                authenticationManager, authorizationService, tokenGenerator, registeredClientRepository, userService))
                        .authenticationProvider(new CustomRefreshTokenAuthenticationProvider(
                                authorizationService, tokenGenerator, userService)));
        return authorizationServerConfigurer;
    }


}
