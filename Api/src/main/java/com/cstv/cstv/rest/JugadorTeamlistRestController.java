package com.cstv.cstv.rest;

import com.cstv.cstv.domain.JugadorTeamlistDTO;
import com.cstv.cstv.entities.Equipos;
import com.cstv.cstv.entities.JugadorTeamlist;
import com.cstv.cstv.entities.Jugadores;
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
    public JugadorTeamlist createJugadorTeamlist(@RequestBody JugadorTeamlistDTO jugadorTeamlistDTO) {
        JugadorTeamlist jugadorTeamlist = new JugadorTeamlist();
        jugadorTeamlist.setId(new JugadorTeamlistId(jugadorTeamlistDTO.getIdJugador(), jugadorTeamlistDTO.getIdEquipo()));
        jugadorTeamlist.setIdEquipo(new Equipos());
        jugadorTeamlist.getIdEquipo().setId(jugadorTeamlistDTO.getIdEquipo());
        jugadorTeamlist.setIdJugador(new Jugadores());
        jugadorTeamlist.getIdJugador().setId(jugadorTeamlistDTO.getIdJugador());
        jugadorTeamlist.setFechaInicio(jugadorTeamlistDTO.getFechaInicio());
        jugadorTeamlist.setFechaFinal(jugadorTeamlistDTO.getFechaFinal());        
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
