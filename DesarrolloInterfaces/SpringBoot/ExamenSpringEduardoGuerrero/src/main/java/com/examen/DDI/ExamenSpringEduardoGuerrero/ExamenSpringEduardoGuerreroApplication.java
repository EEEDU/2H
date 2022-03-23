package com.examen.DDI.ExamenSpringEduardoGuerrero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.examen.DDI.ExamenSpringEduardoGuerrero.*"})
public class ExamenSpringEduardoGuerreroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenSpringEduardoGuerreroApplication.class, args);
	}

}
