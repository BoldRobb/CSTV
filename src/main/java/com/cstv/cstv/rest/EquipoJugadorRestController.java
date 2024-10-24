package com.cstv.cstv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cstv.cstv.domain.EquipoJugadorDTO;
import com.cstv.cstv.entities.EquipoJugadores;
import com.cstv.cstv.entities.Equipos;
import com.cstv.cstv.entities.Jugadores;
import com.cstv.cstv.service.EquipoJugadoresService;

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
    public EquipoJugadores createEquipoJugador(@RequestBody EquipoJugadorDTO equipoJugadorDTO) {
        EquipoJugadores equipoJugador = new EquipoJugadores();
        Equipos equipo = new Equipos();
        equipo.setId(equipoJugadorDTO.getIdEquipo());
        equipoJugador.setIdEquipo(equipo);
        Jugadores jugador = new Jugadores();
        jugador.setId(equipoJugadorDTO.getIdJugador());
        equipoJugador.setIdJugador(jugador);
        
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

