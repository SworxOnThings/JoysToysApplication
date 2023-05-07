package com.JoysToysApplication.JoysToysApplication.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable().cors().and().authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/products/**", "/categories/**", "/customer/**").permitAll().anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
//        http.csrf().disable().cors().and().authorizeHttpRequests((authz) -> authz.anyRequest().permitAll()).httpBasic(withDefaults());
        return http.build();
    }

}

