package com.cstv.cstv.rest;

import com.cstv.cstv.entities.EquipoJugadores;
import com.cstv.cstv.service.EquipoJugadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/equipo-jugadores")
public class EquipoJugadorRestController {

    @Autowired
    private EquipoJugadoresService equipoJugadorService;

    @GetMapping
    public List<EquipoJugadores> getAllEquipoJugadores() {
        return equipoJugadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoJugadores> getEquipoJugadorById(@PathVariable Long id) {
        return equipoJugadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EquipoJugadores createEquipoJugador(@RequestBody EquipoJugadores equipoJugador) {
        return equipoJugadorService.save(equipoJugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipoJugadores> updateEquipoJugador(@PathVariable Long id, @RequestBody EquipoJugadores equipoJugador) {
        if (!equipoJugadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(equipoJugadorService.save(equipoJugador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipoJugador(@PathVariable Long id) {
        if (!equipoJugadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        equipoJugadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

