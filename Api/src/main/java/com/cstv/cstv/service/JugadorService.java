package com.cstv.cstv.service;

import com.cstv.cstv.entities.Jugadores;
import com.cstv.cstv.repos.JugadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepo jugadorRepo;

    public List<Jugadores> findAll() {
        return jugadorRepo.findAll();
    }

    public Optional<Jugadores> findById(Long id) {
        return jugadorRepo.findById(id);
    }

    public Jugadores save(Jugadores jugador) {
        return jugadorRepo.save(jugador);
    }

    public void deleteById(Long id) {
        jugadorRepo.deleteById(id);
    }

    public List<Jugadores> findByNombreContainingIgnoreCase(String nombre) {
        return jugadorRepo.findByMoteContainingIgnoreCaseOrNombreRealContainingIgnoreCase(nombre, nombre);
    }
}
