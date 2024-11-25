package com.cstv.cstv.rest;

import com.cstv.cstv.domain.RespuestasDTO;
import com.cstv.cstv.entities.Respuestas;
import com.cstv.cstv.entities.Topico;
import com.cstv.cstv.entities.Usuarios;
import com.cstv.cstv.service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/respuestas")
public class RespuestaRestController {

    @Autowired
    private RespuestaService respuestaService;

    @GetMapping
    public List<Respuestas> getAllRespuestas() {
        return respuestaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuestas> getRespuestaById(@PathVariable Long id) {
        return respuestaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Respuestas createRespuesta(@RequestBody RespuestasDTO respuestaDTO) {
        Respuestas respuesta = new Respuestas();
        respuesta.setId(respuestaDTO.getId());
        respuesta.setRespuesta(respuestaDTO.getRespuesta());
        respuesta.setFecha(respuestaDTO.getFecha());
        respuesta.setUsuario(new Usuarios());
        respuesta.getUsuario().setId(respuestaDTO.getIdUsuario());
        respuesta.setTopico(new Topico());
        respuesta.getTopico().setId(respuestaDTO.getIdTopico());
        respuesta.setRespuestaPadre(respuestaDTO.getIdRespuesta());
        return respuestaService.save(respuesta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respuestas> updateRespuesta(@PathVariable Long id, @RequestBody Respuestas respuesta) {
        if (!respuestaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        respuesta.setId(id);
        return ResponseEntity.ok(respuestaService.save(respuesta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRespuesta(@PathVariable Long id) {
        if (!respuestaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        respuestaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/topico/{id}")
    public List<Respuestas> getAllRespuestasByTopicoId(@PathVariable Long id) {
        return respuestaService.findAllByTopico_Id(id);
    }

    @GetMapping("/padre/{id}")
    public List<Respuestas> getAllRespuestasByPadreId(@PathVariable Long id) {
        return respuestaService.findAllByRespuestaPadre(id);
    }

}
