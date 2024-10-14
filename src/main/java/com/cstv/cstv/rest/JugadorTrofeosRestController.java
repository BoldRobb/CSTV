package com.cstv.cstv.rest;


import com.cstv.cstv.entities.JugadorTrofeos;
import com.cstv.cstv.repos.JugadorTrofeosRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugador-trofeos")
public class JugadorTrofeosRestController {

    JugadorTrofeosRepo jugadorTrofeosRepo;

    @GetMapping
    public List<JugadorTrofeos> getAllJugadorTrofeos(){
        return jugadorTrofeosRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorTrofeos> getJugadorTrofeosById(@PathVariable(name = "id") long id){
        return jugadorTrofeosRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public JugadorTrofeos createJugadorTrofeos(@RequestBody JugadorTrofeos jugadorTrofeos){
        return jugadorTrofeosRepo.save(jugadorTrofeos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorTrofeos> updateJugadorTrofeos(@PathVariable(name = "id") long id, @RequestBody JugadorTrofeos jugadorTrofeos){
        if(!jugadorTrofeosRepo.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jugadorTrofeosRepo.save(jugadorTrofeos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJugadorTrofeos(@PathVariable(name = "id")long id){
        if(!jugadorTrofeosRepo.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        jugadorTrofeosRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
