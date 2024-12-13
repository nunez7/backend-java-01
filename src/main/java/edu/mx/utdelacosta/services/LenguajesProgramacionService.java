package edu.mx.utdelacosta.services;

import edu.mx.utdelacosta.entity.LenguajesProgramacion;

import java.util.List;

public interface LenguajesProgramacionService {

    List<LenguajesProgramacion> listaLenguajes();

    LenguajesProgramacion busquedaPorNombre(String nombre);

}
