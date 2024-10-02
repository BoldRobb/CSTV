package com.cstv.cstv.service;

import com.cstv.cstv.entities.JugadorTeamlist;
import com.cstv.cstv.repos.JugadorTeamlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorTeamlistService {

    @Autowired
    private JugadorTeamlistRepo jugadorTeamlistRepo;

    public List<JugadorTeamlist> findAll() {
        return jugadorTeamlistRepo.findAll();
    }

    public Optional<JugadorTeamlist> findById(Long id) {
        return jugadorTeamlistRepo.findById(id);
    }

    public JugadorTeamlist save(JugadorTeamlist jugadorTeamlist) {
        return jugadorTeamlistRepo.save(jugadorTeamlist);
    }

    public void deleteById(Long id) {
        jugadorTeamlistRepo.deleteById(id);
    }
}
