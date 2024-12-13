package edu.mx.utdelacosta.controllers;

import edu.mx.utdelacosta.entity.LenguajesProgramacion;
import edu.mx.utdelacosta.services.LenguajesProgramacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
