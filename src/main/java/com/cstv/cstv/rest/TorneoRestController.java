package com.cstv.cstv.rest;

import com.cstv.cstv.entities.Torneos;
import com.cstv.cstv.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/torneos")
public class TorneoRestController {

    @Autowired
    private TorneoService torneoService;

    @GetMapping
    public List<Torneos> getAllTorneos() {
        return torneoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Torneos> getTorneoById(@PathVariable Long id) {
        return torneoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Torneos createTorneo(@RequestBody Torneos torneo) {
        return torneoService.save(torneo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Torneos> updateTorneo(@PathVariable Long id, @RequestBody Torneos torneo) {
        if (!torneoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        torneo.setId(id);
        return ResponseEntity.ok(torneoService.save(torneo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTorneo(@PathVariable Long id) {
        if (!torneoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        torneoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
