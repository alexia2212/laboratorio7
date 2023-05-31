package com.example.laboratorio7.Services;

import com.example.laboratorio7.entity.Pagos;
import com.example.laboratorio7.repository.PagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PagosRest {
    @Autowired
    PagosRepository pagosRepository;

    @GetMapping("/listarPagos")
    public List<Pagos> listaPagos(){
        return pagosRepository.findAll();
    }

    @PostMapping("/registrarPago")
    public ResponseEntity<HashMap<String, Object>> registrar(@RequestBody Pagos pagos){
        HashMap<String, Object> resp = new HashMap<>();
        resp.put("id", pagos.getId());
        pagosRepository.save(pagos);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}