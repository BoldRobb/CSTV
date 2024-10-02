package com.cstv.cstv.rest;

import com.cstv.cstv.entities.TorneoEquipos;
import com.cstv.cstv.service.TorneoEquiposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/torneo-equipos")
public class TorneoEquipoRestController {

    @Autowired
    private TorneoEquiposService torneoEquipoService;

    @GetMapping
    public List<TorneoEquipos> getAllTorneoEquipos() {
        return torneoEquipoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TorneoEquipos> getTorneoEquipoById(@PathVariable Long id) {
        return torneoEquipoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TorneoEquipos createTorneoEquipo(@RequestBody TorneoEquipos torneoEquipo) {
        return torneoEquipoService.save(torneoEquipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TorneoEquipos> updateTorneoEquipo(@PathVariable Long id, @RequestBody TorneoEquipos torneoEquipo) {
        if (!torneoEquipoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(torneoEquipoService.save(torneoEquipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTorneoEquipo(@PathVariable Long id) {
        if (!torneoEquipoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        torneoEquipoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
