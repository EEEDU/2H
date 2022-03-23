package com.example.postman.rest;



import com.example.postman.models.Alumno;
import com.example.postman.models.ListaAlumnos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/")
public class ExamenRestController {


    @Autowired
    private ListaAlumnos lista;

    @PostMapping(path = "ALUMNOS/LIST")
    public ResponseEntity<ListaAlumnos> listallStudents() {
        lista.setAlumnoArrayList(loadList());
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    private ArrayList<Alumno> loadList() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        for(Integer i = 0; i < 5; i++){
            alumnos.add(Alumno.builder().id(i).nombre("default-" + i).fct("Si").build());
        }
        return alumnos;
    }

    @PostMapping(path = "ALUMNOS/INSERT")
    public ResponseEntity<Alumno> generateKey(@RequestBody Alumno alumno) {
        System.out.println("Nombre: " + alumno.getNombre() + "fct: " + alumno.getFct());
        return new ResponseEntity<>(alumno, HttpStatus.OK);

    }


}
