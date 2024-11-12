package com.cstv.cstv.rest;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cstv.cstv.entities.Ids.JugadorTrofeosId;
import com.cstv.cstv.domain.JugadorTrofeosDTO;
import com.cstv.cstv.entities.JugadorTrofeos;
import com.cstv.cstv.entities.Jugadores;
import com.cstv.cstv.entities.Torneos;
import com.cstv.cstv.service.JugadorTrofeosService;

@RestController
@RequestMapping("/api/jugador-trofeos")
public class JugadorTrofeosRestController {

    JugadorTrofeosService jugadorTrofeosRepo;

    @GetMapping
        public List<JugadorTrofeos> getAllJugadorTrofeos(){
        return jugadorTrofeosRepo.findAll();
    }

    @GetMapping("/{id}")
    public List<JugadorTrofeos> getJugadorTrofeosById(@PathVariable long id){
        return jugadorTrofeosRepo.findByIdJugador(id);
    }

    @PostMapping
    public JugadorTrofeos createJugadorTrofeos(@RequestBody JugadorTrofeosDTO jugadorTrofeosDTO){
        JugadorTrofeos jugadorTrofeos = new JugadorTrofeos();
        jugadorTrofeos.setIdJugador(new Jugadores());
        jugadorTrofeos.getIdJugador().setId(jugadorTrofeosDTO.getIdJugador());
        
        jugadorTrofeos.setIdTorneo(new Torneos());
        jugadorTrofeos.getIdTorneo().setId(jugadorTrofeosDTO.getIdTorneo());
        return jugadorTrofeosRepo.save(jugadorTrofeos);
    }

    @DeleteMapping("/{idJugador}/{idTorneo}")
    public ResponseEntity<Void> deleteJugadorTrofeo(@PathVariable(name = "idJugador") long idJugador, @PathVariable(name = "idTorneo") long idTorneo){
        JugadorTrofeosId jugadorTrofeosId = new JugadorTrofeosId(idJugador, idTorneo);
        if(!jugadorTrofeosRepo.findById(jugadorTrofeosId).isPresent()){
            return ResponseEntity.notFound().build();
        }
        jugadorTrofeosRepo.deleteById(jugadorTrofeosId);
        return ResponseEntity.noContent().build();
    }

}
