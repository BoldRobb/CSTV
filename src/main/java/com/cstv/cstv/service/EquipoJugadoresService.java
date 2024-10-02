package com.cstv.cstv.service;

import com.cstv.cstv.entities.EquipoJugadores;
import com.cstv.cstv.repos.EquipoJugadoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoJugadoresService {

    @Autowired
    private EquipoJugadoresRepo equipoJugadoresRepo;

    public List<EquipoJugadores> findAll() {
        return equipoJugadoresRepo.findAll();
    }

    public Optional<EquipoJugadores> findById(Long id) {
        return equipoJugadoresRepo.findById(id);
    }

    public EquipoJugadores save(EquipoJugadores equipoJugadores) {
        return equipoJugadoresRepo.save(equipoJugadores);
    }

    public void deleteById(Long id) {
        equipoJugadoresRepo.deleteById(id);
    }
}
