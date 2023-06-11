package com.oauth.implementation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	AuthenticationSuccessHandler successHandler;

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/login/**").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login").successHandler(successHandler)
        .and().csrf().disable()
        .oauth2Login().loginPage("/login").successHandler(successHandler);
return http.build();

    }

}
