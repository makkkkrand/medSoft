package com.medSoft.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.medSoft.app.beans.CustomPasswordEncoder;
import com.medSoft.app.services.JwtUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

	@Autowired
	CustomPasswordEncoder passwordEncoder;

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Bean
	SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (requests) -> requests
                .requestMatchers(new AntPathRequestMatcher("/openapi/openapi.yml")).permitAll()
                .requestMatchers(new AntPathRequestMatcher("*")).permitAll()
                .anyRequest().authenticated())
                .httpBasic(withDefaults());

		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder);
	}

}