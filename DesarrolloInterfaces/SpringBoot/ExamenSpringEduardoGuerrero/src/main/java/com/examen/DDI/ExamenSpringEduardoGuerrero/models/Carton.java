package com.examen.DDI.ExamenSpringEduardoGuerrero.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Carton {
    int[][] numeros = new int[3][5];
}
