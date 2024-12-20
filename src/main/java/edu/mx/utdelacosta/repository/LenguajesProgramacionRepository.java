package edu.mx.utdelacosta.repository;

import edu.mx.utdelacosta.entity.LenguajesProgramacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenguajesProgramacionRepository extends JpaRepository<LenguajesProgramacion, Integer> {

    LenguajesProgramacion findByNombre(String nombre);

}
