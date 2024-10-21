package com.cstv.cstv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cstv.cstv.entities.Ids.JugadorTeamlistId;
import com.cstv.cstv.entities.JugadorTeamlist;
import com.cstv.cstv.repos.JugadorTeamlistRepo;

@Service
public class JugadorTeamlistService {

    @Autowired
    private JugadorTeamlistRepo jugadorTeamlistRepo;

    public List<JugadorTeamlist> findAll() {
        return jugadorTeamlistRepo.findAll();
    }

    public Optional<JugadorTeamlist> findById(JugadorTeamlistId id) {
        return jugadorTeamlistRepo.findById(id);
    }

    public List<JugadorTeamlist> findByIdJugador(Long idJugador) {
        return jugadorTeamlistRepo.findByIdJugador(idJugador);
    }

    public JugadorTeamlist save(JugadorTeamlist jugadorTeamlist) {
        return jugadorTeamlistRepo.save(jugadorTeamlist);
    }

    public void deleteById(JugadorTeamlistId id) {
        jugadorTeamlistRepo.deleteById(id);
    }
}
