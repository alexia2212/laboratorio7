package com.example.laboratorio7.Services;

import com.example.laboratorio7.entity.Solicitudes;
import com.example.laboratorio7.repository.SolicitudesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudesRest {
    @Autowired
    SolicitudesRepository solicitudesRepository;

    @PostMapping("/registro")

    public ResponseEntity<HashMap<String, String>> crearSolicitud(@RequestBody Solicitudes solicitudes){
        HashMap<String, String> respuesta = new HashMap<>();
        solicitudes.setSolicitud_estado("pendiente");
        solicitudesRepository.save(solicitudes);
        respuesta.put("Monto solicitado",""+solicitudes.getSolicitud_monto());
        respuesta.put("id",""+solicitudes.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }
    @PutMapping("/aprobarSolicitud")
    public ResponseEntity<HashMap<String,String>> aprobarSolicitud(@RequestParam("idSolicitud") int id){
        HashMap<String, String> respuesta = new HashMap<>();
        Optional<Solicitudes> optionalSolicitud = solicitudesRepository.findById(id);

        if (optionalSolicitud.isPresent()){
            Solicitudes solicitud = optionalSolicitud.get();

            if (solicitud.getSolicitud_estado().equals("pendiente")){
                solicitud.setSolicitud_estado("aprobado");
                solicitudesRepository.save(solicitud);
                respuesta.put("id solicitud", String.valueOf(solicitud.getId()));
                return ResponseEntity.ok(respuesta);
            }else{
                respuesta.put("solicitud ya atendida",""+solicitud.getId());
                return ResponseEntity.ok(respuesta);
            }
        }else{
            respuesta.put("error","No existe solicitud con este ID");
            return ResponseEntity.ok(respuesta);
        }

    }
    @PutMapping("/denegarSolicitud")
    public ResponseEntity<HashMap<String,String>> denegarSoli(@RequestParam("idSolicitud") int id){
        HashMap<String, String> respuesta = new HashMap<>();
        Optional<Solicitudes> optionalSolicitud = solicitudesRepository.findById(id);

        if (optionalSolicitud.isPresent()){
            Solicitudes solicitud = optionalSolicitud.get();

            if (solicitud.getSolicitud_estado().equals("pendiente")){
                solicitud.setSolicitud_estado("denegado");
                solicitudesRepository.save(solicitud);
                respuesta.put("id solicitud", String.valueOf(solicitud.getId()));
                return ResponseEntity.ok(respuesta);
            }else{
                respuesta.put("solicitud ya atendida",""+solicitud.getId());
                return ResponseEntity.badRequest().body(respuesta);
            }

        }else{
            respuesta.put("error","No existe solicitud con este ID");
            return ResponseEntity.badRequest().body(respuesta);
        }

    }


    @DeleteMapping("/borrarSolicitud")
    public ResponseEntity<HashMap<String,String>> borrarSoli(@RequestParam("idSolicitud") int id){
        HashMap<String, String> respuesta = new HashMap<>();
        Optional<Solicitudes> optionalSolicitud = solicitudesRepository.findById(id);
        if (optionalSolicitud.isPresent()){
            Solicitudes solicitud = optionalSolicitud.get();
            if (solicitud.getSolicitud_estado().equals("denegado")){
                solicitudesRepository.deleteById(id);
                respuesta.put("id solicitud borrada",String.valueOf(solicitud.getId()));
                return ResponseEntity.ok(respuesta);
            }else {
                respuesta.put("error","La solicitud no está denegada");
                return ResponseEntity.badRequest().body(respuesta);
            }
        }else{
            respuesta.put("error","No existe solicitud con este ID");
            return ResponseEntity.badRequest().body(respuesta);
        }
    }

}
