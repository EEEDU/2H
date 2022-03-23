package com.edu.calculadora.controllers;

import com.edu.calculadora.models.Calculo;
import com.edu.calculadora.services.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculadoraController {

    @Autowired
    private CalculadoraService service;

    @GetMapping("/")
    public ModelAndView bienvenido(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @PostMapping("/calcular")
    public ModelAndView calcular(Calculo calculo){
        Integer resultado = service.calcular(calculo);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("resultado", resultado);
        return modelAndView;
    }
}
