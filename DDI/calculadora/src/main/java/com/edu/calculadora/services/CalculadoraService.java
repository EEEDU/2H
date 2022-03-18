package com.edu.calculadora.services;

import com.edu.calculadora.models.Calculo;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public Integer calcular(Calculo calculo){
        Integer numero1 = calculo.getNumero1();
        Integer numero2 = calculo.getNumero2();
        Integer resultado = 0;
        switch (calculo.getOperacion()){
            case "suma":
                resultado = numero1 + numero2;
                break;
            case "resta" :
                resultado = numero1 -numero2;
                break;
            case "multiplicacion":
                resultado = numero1 * numero2;
                break;
            case "division":
                resultado = numero1 / numero2;
                break;

        }
        return resultado;
    }

}
