package edu.mx.utdelacosta.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lenguajes_programacion")
public class LenguajesProgramacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    public LenguajesProgramacion() {
    }

    public LenguajesProgramacion(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
