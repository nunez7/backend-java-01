package edu.mx.utdelacosta.controllers;

import edu.mx.utdelacosta.dto.LenguajesProgramacionDTO;
import edu.mx.utdelacosta.dto.ResponseDTO;
import edu.mx.utdelacosta.entity.LenguajesProgramacion;
import edu.mx.utdelacosta.services.LenguajesProgramacionService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
public class LenguajesProgramacionController {

    @Autowired
    private LenguajesProgramacionService lenguajesService;

    @GetMapping("/lenguajes-programacion")
    public Map<String, Object> getLenguajesProgramacion(){

        //Construir la respuesta
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("head", "Lista de lenguajes");
        respuesta.put("body", lenguajesService.listaLenguajes());
        return respuesta;
    }

    @GetMapping("/lenguajes-programacion/{nombre}")
    public Map<String, Object> getLenguajeProgramacionPorNombre(@PathVariable String nombre){
        LenguajesProgramacion lenguaje = lenguajesService.busquedaPorNombre(nombre);

        Map<String, Object> respuesta = new HashMap<>();
        if(lenguaje == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lenguaje no encontrado");
        }else{
            respuesta.put("head", "Lenguaje encontrado");
            respuesta.put("body", lenguaje);
            return respuesta;
        }
    }

    @PostMapping("/lenguajes-programacion")
    public ResponseDTO guardarLenguaje(@RequestBody @Valid LenguajesProgramacionDTO lenguajeDTO, HttpServletResponse servletResponse){
        LenguajesProgramacion lenguaje = lenguajesService.busquedaPorNombre(lenguajeDTO.getNombre().toUpperCase());

        ResponseDTO respuesta = new ResponseDTO();
        if(lenguaje != null){
            respuesta.setRespuesta("Lenguaje no disponible");
            respuesta.setCodigo(500);
            respuesta.setContenido("El lenguaje ya existe en la DB, no se puede duplicar.");
            servletResponse.setStatus(500);
        }else{
            //Mapeo de clases
            LenguajesProgramacion lenguajeSave = new LenguajesProgramacion();
            lenguajeSave.setNombre(lenguajeDTO.getNombre().toUpperCase());
            //Servicio
            LenguajesProgramacion lenguajeNuevo = lenguajesService.save(lenguajeSave);
            //Respuesta
            respuesta.setRespuesta("Lenguaje guardado");
            respuesta.setCodigo(201);
            respuesta.setContenido(lenguajeNuevo);
            servletResponse.setStatus(201);
        }
        return respuesta;
    }

    @DeleteMapping("/lenguajes-programacion/{id}")
    public ResponseDTO deleteLenguajeProgramacionPorId(@PathVariable Integer id, HttpServletResponse servletResponse){
        Optional<LenguajesProgramacion> lenguaje = lenguajesService.busquedaPorId(id);

        ResponseDTO respuesta = new ResponseDTO();

        if(!lenguaje.isPresent()){
            respuesta.setRespuesta("Lenguaje no disponible");
            respuesta.setCodigo(404);
            respuesta.setContenido("Lenguaje no encontrado, no se pudo eliminar el lenguaje");
            servletResponse.setStatus(404);
        }else{
            lenguajesService.deletePorId(id);
            respuesta.setRespuesta("Lenguaje eliminado");
            respuesta.setCodigo(204);
            respuesta.setContenido("El lenguaje se ha eliminado correctamente");
            servletResponse.setStatus(204);
        }

        return respuesta;
    }

}
