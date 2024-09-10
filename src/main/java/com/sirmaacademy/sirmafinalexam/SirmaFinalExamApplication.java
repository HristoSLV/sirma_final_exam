package com.sirmaacademy.sirmafinalexam;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Football Match Records DB", description = "Microservice for processing football match data"))
public class SirmaFinalExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SirmaFinalExamApplication.class, args);
	}

}
