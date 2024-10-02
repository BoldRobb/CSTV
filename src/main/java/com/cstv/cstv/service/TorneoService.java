package com.cstv.cstv.service;

import com.cstv.cstv.entities.Torneos;
import com.cstv.cstv.repos.TorneoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorneoService {

    @Autowired
    private TorneoRepo torneoRepo;

    public List<Torneos> findAll() {
        return torneoRepo.findAll();
    }

    public Optional<Torneos> findById(Long id) {
        return torneoRepo.findById(id);
    }

    public Torneos save(Torneos torneo) {
        return torneoRepo.save(torneo);
    }

    public void deleteById(Long id) {
        torneoRepo.deleteById(id);
    }
}
