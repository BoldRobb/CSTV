package com.cstv.cstv.service;

import com.cstv.cstv.entities.JugadorTrofeos;
import com.cstv.cstv.repos.JugadorTrofeosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorTrofeosService {

    @Autowired
    private JugadorTrofeosRepo jugadorTrofeosRepo;

    public List<JugadorTrofeos> findAll() {
        return jugadorTrofeosRepo.findAll();
    }

    public Optional<JugadorTrofeos> findById(Long id) {
        return jugadorTrofeosRepo.findById(id);
    }

    public JugadorTrofeos save(JugadorTrofeos jugadorTrofeos) {
        return jugadorTrofeosRepo.save(jugadorTrofeos);
    }

    public void deleteById(Long id) {
        jugadorTrofeosRepo.deleteById(id);
    }
}
