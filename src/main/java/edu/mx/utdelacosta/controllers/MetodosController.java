package edu.mx.utdelacosta.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
@RequestMapping(value = "/api/v1")
public class MetodosController {

    private final List<String> languages = Arrays.asList("Java", "Python", "C++", "JS");

    @GetMapping("/holamundo")
    public String getHolaMundo(){
        return "Hola mundo";
    }

    @GetMapping("/lenguajes-programacion")
    public Map<String, Object> getLenguajesProgramacion(){
        //Construir la respuesta
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("head", "Lista de lenguajes");
        respuesta.put("body", languages);
        return respuesta;
    }

    //Practica
    @GetMapping("/lenguajes-programacion/{nombre}")
    public Map<String, Object> getLenguajeProgramacionPorNombre(@PathVariable String nombre){
        Optional<String> lenguaje = languages.stream()
                .filter(lan -> lan.equalsIgnoreCase(nombre))
                .findFirst();
        Map<String, Object> respuesta = new HashMap<>();
        if(!lenguaje.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lenguaje no encontrado");
        }else{
            respuesta.put("head", "Lenguaje encontrado");
            respuesta.put("body", lenguaje.get());
            return respuesta;
        }
    }

}
