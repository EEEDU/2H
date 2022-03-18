package com.example.postman.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Getter
@Setter
public class ListaAlumnos {
    ArrayList<Alumno> alumnoArrayList;
}
