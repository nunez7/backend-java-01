package edu.mx.utdelacosta.controllers;

import edu.mx.utdelacosta.services.LenguajesProgramacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

}
