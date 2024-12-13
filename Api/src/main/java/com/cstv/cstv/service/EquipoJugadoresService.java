package com.cstv.cstv.service;

import com.cstv.cstv.entities.EquipoJugadores;
import com.cstv.cstv.entities.Ids.EquipoJugadoresId;
import com.cstv.cstv.repos.EquipoJugadoresRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoJugadoresService {

    @Autowired
    private EquipoJugadoresRepo equipoJugadoresRepo;

    public List<EquipoJugadores> findAll() {
        return equipoJugadoresRepo.findAll();
    }

    public List<EquipoJugadores> findByIdJugador(Long idJugador) {
        return equipoJugadoresRepo.findById_IdJugador(idJugador);
    }

    public List<EquipoJugadores> findByIdEquipo(Long idEquipo) {
        return equipoJugadoresRepo.findById_IdEquipo(idEquipo);
    }   
    public EquipoJugadores save(EquipoJugadores equipoJugadores) {
        return equipoJugadoresRepo.save(equipoJugadores);
    }
    @Transactional
    public void deleteByIdJugador(Long idJugador) {
        equipoJugadoresRepo.deleteById_IdJugador(idJugador);
    }
    public void deleteById(EquipoJugadoresId id) {
        equipoJugadoresRepo.deleteById(id);
    }
}
