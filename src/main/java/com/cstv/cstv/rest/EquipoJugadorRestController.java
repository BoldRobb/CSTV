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

    @GetMapping("/equipo/{id}")
    public List<EquipoJugadores> getEquipoJugadorByIdEquipo(@PathVariable Long id) {
        return equipoJugadorService.findByIdEquipo(id);
    }
    
    @GetMapping("/jugador/{id}")
    public List<EquipoJugadores> getEquipoJugadorByIdJugador(@PathVariable Long id) {
        return equipoJugadorService.findByIdJugador(id);
    }

    @PostMapping
    public EquipoJugadores createEquipoJugador(@RequestBody EquipoJugadores equipoJugador) {
        return equipoJugadorService.save(equipoJugador);
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipoJugador(@PathVariable Long id) {
        if (!equipoJugadorService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        equipoJugadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }*/

    @DeleteMapping("/jugador/{id}")
    public ResponseEntity<Void> deleteJugadorFromEquipo(@PathVariable Long id) {
        if (equipoJugadorService.findByIdJugador(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        equipoJugadorService.deleteByIdJugador(id);
        return ResponseEntity.noContent().build();
    }
}

