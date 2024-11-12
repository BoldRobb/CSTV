package com.cstv.cstv.service;

import com.cstv.cstv.entities.Partido;
import com.cstv.cstv.repos.PartidoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepo partidoRepo;

    public List<Partido> findAll() {
        return partidoRepo.findAll();
    }

    public Optional<Partido> findById(Long id) {
        return partidoRepo.findById(id);
    }

    public Partido save(Partido partido) {
        return partidoRepo.save(partido);
    }

    public void deleteById(Long id) {
        partidoRepo.deleteById(id);
    }
}
