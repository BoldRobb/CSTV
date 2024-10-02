package com.cstv.cstv.rest;

import com.cstv.cstv.entities.Jugadores;
import com.cstv.cstv.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jugadores")
public class JugadorRestController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugadores> getAllJugadores() {
        return jugadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugadores> getJugadorById(@PathVariable Long id) {
        return jugadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jugadores createJugador(@RequestBody Jugadores jugador) {
        return jugadorService.save(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugadores> updateJugador(@PathVariable Long id, @RequestBody Jugadores jugador) {
        if (!jugadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        jugador.setId(id);
        return ResponseEntity.ok(jugadorService.save(jugador));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJugador(@PathVariable Long id) {
        if (!jugadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        jugadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
