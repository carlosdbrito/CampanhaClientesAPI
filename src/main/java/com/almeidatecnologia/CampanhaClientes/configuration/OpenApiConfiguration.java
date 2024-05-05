package com.almeidatecnologia.CampanhaClientes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfiguration {
	
	@Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .components(
                    new Components().addSecuritySchemes("bearerAuth", 
                    new SecurityScheme().type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWt")))
                .info(new Info()
                    .title("API Rest para gerenciar a Campanha do Cliente e seu Benefício")
                    .description("Esta API gerencia o cadastro da Campanha do Cliente e seu respectivo Benefício, utilizando as mais recentes tecnologias do mercado.")
                    .contact(new Contact()
                    .name("Almeida Tecnologia")
                    .email("almeidabritoinf@gmail.com")
                    .url("http://localhost")
                    )
                    .version("Versão 1.1.18-SNAPSHOT")  
                                 
                    )
                    .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    } 

}
