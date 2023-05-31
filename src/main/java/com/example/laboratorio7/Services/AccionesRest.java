package com.example.laboratorio7.Services;

import com.example.laboratorio7.entity.Acciones;
import com.example.laboratorio7.repository.AccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/acciones")
public class AccionesRest {
    @Autowired
    AccionesRepository accionesRepository;

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> guardarAccion(@RequestBody Acciones acciones) {
        HashMap<String, Object> respuesta = new HashMap<>();
        accionesRepository.save(acciones);
        respuesta.put("idCreado",acciones.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }
}