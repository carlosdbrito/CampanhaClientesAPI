package com.almeidatecnologia.CampanhaClientes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            .csrf(csrf-> csrf.disable())
            .sessionManagement(sessionManagement-> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))            
            .authorizeHttpRequests(
                (authz)->authz
                .requestMatchers("/token", "/v3/api-docs/**", "/swagger-ui/**", 
                "/swagger-ui.html", "/swagger-resources/**", 
                "/webjars/**").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(tokenFilterJWT(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public TokenFilterJWT tokenFilterJWT(){
        return new TokenFilterJWT();
    }

}
