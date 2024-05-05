package com.almeidatecnologia.CampanhaClientes.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almeidatecnologia.CampanhaClientes.configuration.TokenUtilJWT;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Segurança")
public class AuthController {
	
	@Autowired
	private TokenUtilJWT tokenUtilJWT;
	
    @Operation(summary = "Solicitar token de acesso.")	
	@GetMapping("/token") //http://localhost:8081/token?username=NOME
	public ResponseEntity<?> createToken(@RequestParam String username){
		String token = tokenUtilJWT.createToken(username);
		return ResponseEntity.ok(token);
	}

}
