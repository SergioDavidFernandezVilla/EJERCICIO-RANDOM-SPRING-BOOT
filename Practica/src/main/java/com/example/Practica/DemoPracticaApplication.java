package com.example.Practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DemoPracticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPracticaApplication.class, args);
	}

}
