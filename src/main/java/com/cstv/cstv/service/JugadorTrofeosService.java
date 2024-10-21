package com.cstv.cstv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cstv.cstv.entities.Ids.JugadorTrofeosId;
import com.cstv.cstv.entities.JugadorTrofeos;
import com.cstv.cstv.repos.JugadorTrofeosRepo;

@Service
public class JugadorTrofeosService {

    @Autowired
    private JugadorTrofeosRepo jugadorTrofeosRepo;

    public List<JugadorTrofeos> findAll() {
        return jugadorTrofeosRepo.findAll();
    }

    public Optional<JugadorTrofeos> findById(JugadorTrofeosId id) {
        return jugadorTrofeosRepo.findById(id);
    }
    public List<JugadorTrofeos> findByIdJugador(Long idJugador) {
        return jugadorTrofeosRepo.findByIdJugador(idJugador);
    }
    
    public JugadorTrofeos save(JugadorTrofeos jugadorTrofeos) {
        return jugadorTrofeosRepo.save(jugadorTrofeos);
    }

    public void deleteById(JugadorTrofeosId id) {
        jugadorTrofeosRepo.deleteById(id);
    }
    public void deleteByIdJugadorIdTrofeo(Long idJugador, Long idTorneo){
        jugadorTrofeosRepo.deleteByIdJugadorIdTorneo(idJugador, idTorneo);
    }
}
