package edu.mx.utdelacosta.dto;

import jakarta.validation.constraints.NotNull;

public class LenguajesProgramacionDTO {

    @NotNull
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
