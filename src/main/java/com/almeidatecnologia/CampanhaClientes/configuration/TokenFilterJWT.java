package com.almeidatecnologia.CampanhaClientes.configuration;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TokenFilterJWT extends OncePerRequestFilter{

    @Autowired
    private TokenUtilJWT tokenUtilJWT;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {
        
        String token = request.getHeader("Authorization");
        if(token != null && token.startsWith("Bearer ")){
            token = token.substring(7);            
            if(tokenUtilJWT.validateToken(token)){                
                String username = tokenUtilJWT.getUsernameFromToken(token);                
                List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("USESR"));
                Authentication autenticacao = new UsernamePasswordAuthenticationToken(username,null, authorities);

                SecurityContextHolder.getContext().setAuthentication(autenticacao);
            }
        }
        filterChain.doFilter(request, response);
    }

}

