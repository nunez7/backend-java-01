package edu.mx.utdelacosta.services;

import edu.mx.utdelacosta.entity.LenguajesProgramacion;
import edu.mx.utdelacosta.repository.LenguajesProgramacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LenguajesProgramacionServiceImpl implements LenguajesProgramacionService{

    @Autowired
    private LenguajesProgramacionRepository repository;

    @Override
    public List<LenguajesProgramacion> listaLenguajes() {
        return repository.findAll();
    }

    @Override
    public LenguajesProgramacion busquedaPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }
}
