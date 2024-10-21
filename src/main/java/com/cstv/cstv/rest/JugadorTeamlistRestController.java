package com.cstv.cstv.rest;

import com.cstv.cstv.entities.JugadorTeamlist;
import com.cstv.cstv.service.JugadorTeamlistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.cstv.cstv.entities.Ids.JugadorTeamlistId;

@RestController
@RequestMapping(value = "/api/jugador-teamlist")
public class JugadorTeamlistRestController {

    @Autowired
    private JugadorTeamlistService jugadorTeamlistService;

    @GetMapping
    public List<JugadorTeamlist> getAllJugadorTeamlist() {
        return jugadorTeamlistService.findAll();
    }

    @GetMapping("/{idJugador}")
    public List<JugadorTeamlist> getJugadorTeamlistByIdJugador(@PathVariable Long idJugador) {
        return jugadorTeamlistService.findByIdJugador(idJugador);
    }

    @PostMapping
    public JugadorTeamlist createJugadorTeamlist(@RequestBody JugadorTeamlist jugadorTeamlist) {
        return jugadorTeamlistService.save(jugadorTeamlist);
    }

    @DeleteMapping("/{idJugador}/{idEquipo}")
    public ResponseEntity<Void> deleteJugadorTeamlist(@PathVariable Long idJugador, @PathVariable long idEquipo){
       JugadorTeamlistId id = new JugadorTeamlistId(idJugador, idEquipo);
        if(!jugadorTeamlistService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        jugadorTeamlistService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
