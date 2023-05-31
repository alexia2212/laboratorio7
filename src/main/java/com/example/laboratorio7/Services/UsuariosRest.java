package com.example.laboratorio7.Services;

import com.example.laboratorio7.entity.Usuarios;
import com.example.laboratorio7.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuariosRest {
    @Autowired
    UsuarioRepository usuarioRepository;
    @GetMapping("/listar")
    public List<Usuarios> listaDeUsuarios(){

        List<Usuarios> listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;


    }

    @PostMapping("/crear")
    public ResponseEntity<HashMap<String, String>> crearUsuarios(@RequestBody Usuarios usuario){
        HashMap<String, String> respuesta = new HashMap<>();
        usuarioRepository.save(usuario);
        respuesta.put("id creado",""+usuario.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }
}
