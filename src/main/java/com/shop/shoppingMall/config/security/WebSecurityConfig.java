package com.shop.shoppingMall.config.security;

import com.shop.shoppingMall.member.enums.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 설명 : 요청되는 모든 URL을 허용하여 Spring에서 제공하는 로그인 페이지가 나오지 않게 한다는 의미.
        http
                .csrf(AbstractHttpConfigurer::disable
                )
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/assets", "/js/**", "/css/**", "/image").permitAll()
                                .requestMatchers("/api1").hasRole(Role.USER.name())
                                .requestMatchers("/api2").hasRole(Role.ADMIN.name())
                                .anyRequest().authenticated()
                )
                .formLogin((formLogin) ->
                        formLogin
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/", true)
                );
        return http.build();
    }

    // 설명 : Spring에 집중하기 위해 샘플 케이스를 사용함. 실제로 적용할 때는 데이터베이스에 저장된 데이터를 기반으로 조회되도록 내용을 설정해야 한다.
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user1").password("1234").roles("USER").build());
        return manager;
    }

    // 설명 : Spring이 패스워드는 인코딩해야 한다는 보안 부분을 강제하기 때문에 이 부분도 추가해야한다.
    // PasswordEncoder를 사용하면 패스워드를 쉽게 암호화할 수 있다.
    // 지금은 예시를 위해 NoOpPasswordEncoder객체가 반환되도록 설정함.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf((csrfConfig) ->
//                        csrfConfig.disable()
//                )
//                .authorizeHttpRequests((authorizeRequests) ->
//                        authorizeRequests
//                                .requestMatchers("/", "/login/**", "/static/**", "/product/**").permitAll()
//                                .requestMatchers("/posts/**", "/api/v1/posts/**").hasRole(Role.USER.name())
//                                .requestMatchers("/posts/**", "/api/v2/posts/**").hasRole(Role.ADMIN.name())
//                                .anyRequest().authenticated()
//                )
//                .formLogin((formLogin) ->
//                        formLogin
//                                .usernameParameter("Id")
//                                .passwordParameter("password")
//                                .loginPage("/login")
//                                .failureUrl("/login?failed")
//                                .loginProcessingUrl("/login/process")
//                );
//
//        return http.build();
//    }
}
