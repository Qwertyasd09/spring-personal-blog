package com.dgchiri.blog_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final RequestMatcher PROTECTED_URLS = new OrRequestMatcher(
        new AntPathRequestMatcher("/admin"),
        new AntPathRequestMatcher("/edit/{articleId}"),
        new AntPathRequestMatcher("/new")
    );

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorize) -> authorize
                .requestMatchers(PROTECTED_URLS).authenticated()
                .anyRequest().permitAll()
        )
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults());
        return http.build();
    }

    

}
