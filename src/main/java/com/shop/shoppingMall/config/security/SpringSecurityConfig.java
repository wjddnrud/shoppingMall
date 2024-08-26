package com.shop.shoppingMall.config.security;

import com.shop.shoppingMall.user.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrfConfig) ->
                        csrfConfig.disable()
                )
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/", "/login/**").permitAll()
                                .requestMatchers("/posts/**", "/api/v1/posts/**").hasRole(Role.USER.name())
                                .requestMatchers("/posts/**", "/api/v2/posts/**").hasRole(Role.ADMIN.name())
                                .requestMatchers("/resources/**").permitAll()
                                .requestMatchers("/shop/**").permitAll()
                                .anyRequest().authenticated()
                );

        return http.build();
    }
}
