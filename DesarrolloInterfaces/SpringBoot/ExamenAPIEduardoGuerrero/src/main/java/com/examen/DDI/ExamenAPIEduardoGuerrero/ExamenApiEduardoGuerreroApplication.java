package com.examen.DDI.ExamenAPIEduardoGuerrero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.DDI.ExamenAPIEduardoGuerrero.*" })
public class ExamenApiEduardoGuerreroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenApiEduardoGuerreroApplication.class, args);
	}

}
