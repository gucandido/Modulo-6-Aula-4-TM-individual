package com.example.demo.dto;

public class MetricsDto {

    private Integer qtVisitada;

    public MetricsDto() {
    }

    public MetricsDto(Integer qtVisitada) {
        this.qtVisitada = qtVisitada;
    }

    public Integer getQtVisitada() {
        return qtVisitada;
    }

    public void setQtVisitada(Integer qtVisitada) {
        this.qtVisitada = qtVisitada;
    }

    public void addVisita(){
        this.qtVisitada++;
    }
}
