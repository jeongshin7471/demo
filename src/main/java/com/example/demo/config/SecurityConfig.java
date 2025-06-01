package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf(auth -> auth.disable());
		
		http.authorizeHttpRequests(auth -> auth
			    .requestMatchers("/", "/regist", "/registProc", "/login", "/loginProc", "/success", "/fail").permitAll()
			    .anyRequest().authenticated()
			);

			http.formLogin(auth -> auth
			    .loginPage("/login")
			    .loginProcessingUrl("/loginProc")
			    .defaultSuccessUrl("/success")
			    .failureUrl("/fail")
			    .permitAll()
			);
		
		return http.build();
	}
}
