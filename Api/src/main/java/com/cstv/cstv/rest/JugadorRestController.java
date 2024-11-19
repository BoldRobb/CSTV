package com.cstv.cstv.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cstv.cstv.domain.JugadoresDTO;
import com.cstv.cstv.entities.Equipos;
import com.cstv.cstv.entities.Jugadores;
import com.cstv.cstv.service.JugadorService;

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
    public Jugadores createJugador(@RequestBody JugadoresDTO jugadorDTO) {
        Jugadores jugador = new Jugadores();
        jugador.setNombreReal(jugadorDTO.getNombreReal());
        jugador.setMote(jugadorDTO.getMote());
        jugador.setEstatus(jugadorDTO.getEstatus());
        jugador.setFoto(jugadorDTO.getFoto());
        jugador.setPais(jugadorDTO.getPais());
        if(jugadorDTO.getIdEquipoActual() != null){
            jugador.setEquipoActual(new Equipos());
            jugador.getEquipoActual().setId(jugadorDTO.getIdEquipoActual());
        }
        
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

    @GetMapping("/nombre/{nombre}")
    public List<Jugadores> getJugadorByNombre(@PathVariable String nombre) {
        return jugadorService.findByNombreContainingIgnoreCase(nombre);
    }
}
