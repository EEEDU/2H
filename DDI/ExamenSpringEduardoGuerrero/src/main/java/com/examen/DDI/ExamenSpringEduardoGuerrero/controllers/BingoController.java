package com.examen.DDI.ExamenSpringEduardoGuerrero.controllers;

import com.examen.DDI.ExamenSpringEduardoGuerrero.models.Carton;
import com.examen.DDI.ExamenSpringEduardoGuerrero.services.BingoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BingoController {

    @Autowired
    BingoService service;
    @Autowired
    Carton carton;

    @GetMapping("/")
    public ModelAndView bienvenido(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @PostMapping("/jugar")
    public ModelAndView jugar(){
        int[] numeros = service.llenarNumeros();
        boolean primera = true;
        int[][] carton = service.anadirCarton(numeros, true);
        numeros = service.llenarNumeros();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("carton", carton);
        return modelAndView;
    }

    @PostMapping("/bola")
    public ModelAndView bola(){
        int bola = service.anadirBola();
        int[] numeros = new int[1];
        int[][]cartonAux = service.anadirCarton(numeros, false);
        String fin = service.fin();
        int lineas = service.lineas();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("bola", bola);
        modelAndView.addObject("carton", cartonAux);
        modelAndView.addObject("fin", fin);
        modelAndView.addObject("lineas", lineas);
        return modelAndView;
    }

}
