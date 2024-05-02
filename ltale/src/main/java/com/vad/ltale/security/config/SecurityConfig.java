package com.vad.ltale.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final EncriptionConfig encriptionConfig;

    @Autowired
    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, EncriptionConfig encriptionConfig) {
        this.userDetailsService = userDetailsService;
        this.encriptionConfig = encriptionConfig;
    }

    @Bean
    public SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests(
                        configure -> configure
                                .requestMatchers(HttpMethod.GET, "/moderation-posts").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/moderation-posts").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.GET,"/api-v1/complaintReports/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.DELETE,"/api-v1/complaintReports/**").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.POST,"/registration").permitAll()
                                .requestMatchers(HttpMethod.GET,"/api-v1/files/image/**", "/api-v1/files/audio/**").permitAll()
                                .anyRequest().authenticated()
                )
                .exceptionHandling(configure -> configure.accessDeniedPage("/access-denied"))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().httpBasic().and().build();

    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
        dao.setUserDetailsService(userDetailsService);
        dao.setPasswordEncoder(encriptionConfig.passwordEncoder());
        return dao;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }
}
