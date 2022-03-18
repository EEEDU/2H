package com.example.postman.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Builder
public class Alumno {
    Integer id;
    String nombre;
    String fct;

}
