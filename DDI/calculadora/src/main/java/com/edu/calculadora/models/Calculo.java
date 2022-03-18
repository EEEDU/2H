package com.edu.calculadora.models;

public class Calculo {
    private Integer numero1;
    private Integer numero2;
    private String operacion;

    public Integer getNumero1() {
        return numero1;
    }

    public void setNumero1(Integer numero1) {
        this.numero1 = numero1;
    }

    public Integer getNumero2() {
        return numero2;
    }

    public void setNumero2(Integer numero2) {
        this.numero2 = numero2;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Calculo(Integer numero1, Integer numero2, String operacion) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacion = operacion;
    }
}
