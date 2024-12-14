package edu.mx.utdelacosta.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lenguajes_programacion")
public class LenguajesProgramacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

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
