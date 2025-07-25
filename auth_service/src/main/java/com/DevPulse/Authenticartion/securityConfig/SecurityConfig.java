package com.DevPulse.Authenticartion.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.DevPulse.Authenticartion.secuirity.CustomUserDetailsService;
import com.DevPulse.Authenticartion.secuirity.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	CustomUserDetailsService customUserDetailsService; 
	@Autowired
	JwtFilter jwtFilter;
	@Autowired
	PasswordEncoder passwordEncoder;
	 @Bean
	    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
	        return config.getAuthenticationManager();
	    }

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
		http.csrf().disable()
		.authorizeHttpRequests(auth->auth
				.requestMatchers("/auth/**").permitAll()
				.requestMatchers("/user/register","/user/*/users","/**").permitAll()
				 .requestMatchers("/manager/**").hasRole("MANAGER")
				.anyRequest().authenticated())
		   .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
           .authenticationProvider(authenticationProvider())
           .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setUserDetailsService((UserDetailsService) customUserDetailsService);
	        provider.setPasswordEncoder(new BCryptPasswordEncoder());
	        return provider;
	}
	
	
}
