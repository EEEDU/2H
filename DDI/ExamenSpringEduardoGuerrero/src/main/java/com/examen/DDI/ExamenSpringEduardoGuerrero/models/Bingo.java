package com.examen.DDI.ExamenSpringEduardoGuerrero.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Bingo {
    int[] bolas = new int[90];
    int longitud = 89;

}
