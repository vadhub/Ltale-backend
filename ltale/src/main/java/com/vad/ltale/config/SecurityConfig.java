package com.vad.ltale.config;

import com.vad.ltale.security.BCrypt;
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
    private final BCrypt bCrypt;
    @Autowired
    public SecurityConfig(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, BCrypt bCrypt) {
        this.userDetailsService = userDetailsService;
        this.bCrypt = bCrypt;
    }

    @Bean
    public SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests(
                        configure -> configure
                                .requestMatchers(HttpMethod.POST,"/registration").permitAll()
                                .requestMatchers(HttpMethod.GET, "/login").permitAll()
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
        dao.setPasswordEncoder(bCrypt.passwordEncoder());
        return dao;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

}
