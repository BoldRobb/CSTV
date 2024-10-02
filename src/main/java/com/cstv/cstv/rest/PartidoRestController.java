package com.cstv.cstv.rest;

import com.cstv.cstv.entities.Partido;
import com.cstv.cstv.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/partidos")
public class PartidoRestController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> getAllPartidos() {
        return partidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> getPartidoById(@PathVariable Long id) {
        return partidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partido createPartido(@RequestBody Partido partido) {
        return partidoService.save(partido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> updatePartido(@PathVariable Long id, @RequestBody Partido partido) {
        if (!partidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        partido.setId(id);
        return ResponseEntity.ok(partidoService.save(partido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartido(@PathVariable Long id) {
        if (!partidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        partidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
