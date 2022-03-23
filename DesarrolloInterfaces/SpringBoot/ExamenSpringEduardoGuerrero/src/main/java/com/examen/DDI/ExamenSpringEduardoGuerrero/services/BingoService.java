package com.examen.DDI.ExamenSpringEduardoGuerrero.services;

import com.examen.DDI.ExamenSpringEduardoGuerrero.models.Bingo;
import com.examen.DDI.ExamenSpringEduardoGuerrero.models.Carton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BingoService {

    @Autowired
    Bingo bingo;
    @Autowired
    Carton carton;

    public int[] llenarNumeros(){
        int[] numeros = new int[90];
        for(int i = 0; i < numeros.length; i ++){
            numeros[i] = i;
        }
        bingo.setBolas(numeros);
        return numeros;
    }

    public int anadirBola(){
        int longitud = bingo.getLongitud();
        int[] numero = bingo.getBolas();
        int random = (int)(Math.random()*longitud);
        int bola = numero[random];
        numero[random] = numero[longitud];
        bingo.setLongitud(bingo.getLongitud() - 1);
        bingo.setBolas(numero);
        comprobarBola(bola);
        return bola;
    }

    public int[][] anadirCarton(int[] numero, boolean primera){
        if (primera){
            int[][] cartonAux = new int[3][5];
            int longitud = 89;
            for (int i = 0; i < 3; i++ ){
                for (int j = 0; j < 5; j++){
                    int random = (int)(Math.random()*longitud);
                    cartonAux[i][j] = numero[random];
                    numero[random] = numero[longitud];
                    longitud --;

                }
            }
            carton.setNumeros(cartonAux);
        }
        else{

        }

        return carton.getNumeros();
    }

    public void comprobarBola(int bola){
        int[][] cartonAux = carton.getNumeros();
        for (int i = 0; i < 3; i++ ){
            for (int j = 0; j < 5; j++){
                if (cartonAux[i][j] == bola){
                    tacharBola(i, j);
                }

            }
        }
    }

    public void tacharBola(int i, int j){
        int[][] cartonAux = carton.getNumeros();
        cartonAux[i][j] = 999;
    }

    public String fin(){
        int[][] cartonAux = carton.getNumeros();
        for (int i = 0; i < 3; i++ ){
            for (int j = 0; j < 5; j++){
                if (cartonAux[i][j] != 999){
                    return "Sigue jugando";
                }

            }
        }
        return "Has ganado";
    }
    public int lineas(){
        int[][] cartonAux = carton.getNumeros();
        int totalLinea = 0;
        for (int i = 0; i < 3; i++ ){
            int linea = 0;
            for (int j = 0; j < 5; j++){
                if (cartonAux[i][j] == 999){
                    linea ++;
                }

            }
            if (linea == 5){
                totalLinea ++;
            }
        }
        return totalLinea;
    }
}
