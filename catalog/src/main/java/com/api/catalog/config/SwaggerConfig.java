package com.api.catalog.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
		title = "API Teste Catalogo", 
		version = "1.0", 
		contact = @Contact(
				name = "Douglas Alves", 
				email = "douglas.alves9905@gmail.com",
				url = "https://github.com/Douglas4lves")
		))
public class SwaggerConfig {


	
}
