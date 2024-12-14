package edu.mx.utdelacosta.services;

import edu.mx.utdelacosta.dto.LenguajesProgramacionDTO;
import edu.mx.utdelacosta.entity.LenguajesProgramacion;

import java.util.List;
import java.util.Optional;

public interface LenguajesProgramacionService {

    List<LenguajesProgramacion> listaLenguajes();
    LenguajesProgramacion busquedaPorNombre(String nombre);

    boolean save(LenguajesProgramacionDTO lenguaje);

    void deletePorId(Integer id);

    Optional<LenguajesProgramacion> busquedaPorId(Integer id);

}
