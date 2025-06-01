package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		//http.csrf(auth -> auth.disable());
		
		http.authorizeHttpRequests(auth -> auth
			    .requestMatchers("/", "/regist", "/registProc", "/login", "/loginProc", "/success", "/fail").permitAll()
			    .anyRequest().authenticated()
			);

		http.formLogin(auth -> auth
		    .loginPage("/login")
		    .loginProcessingUrl("/loginProc")
		    .defaultSuccessUrl("/success", true)
		    .failureUrl("/fail")
		    .permitAll()
		);
		
		http.logout(auth -> auth
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()
				);
		
		http.exceptionHandling(exception -> exception
				.authenticationEntryPoint(customAuthenticationEntryPoint));
		
		return http.build();
	}
}
