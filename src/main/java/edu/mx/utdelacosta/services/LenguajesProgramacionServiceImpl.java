package edu.mx.utdelacosta.services;

import edu.mx.utdelacosta.dto.LenguajesProgramacionDTO;
import edu.mx.utdelacosta.entity.LenguajesProgramacion;
import edu.mx.utdelacosta.repository.LenguajesProgramacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean save(LenguajesProgramacionDTO lenguaje) {
        return false;
    }

    @Override
    @Transactional
    public void deletePorId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<LenguajesProgramacion> busquedaPorId(Integer id) {
        return repository.findById(id);
    }
}
