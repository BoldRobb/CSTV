package com.cstv.cstv.service;

import com.cstv.cstv.entities.Ronda;
import com.cstv.cstv.repos.RondaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RondaService {

    @Autowired
    private RondaRepo rondaRepo;

    public List<Ronda> findAllByTorneoId(Long id) {
        return rondaRepo.findAllByTorneo_Id(id);
    }

    public List<Ronda> findAll() {
        return rondaRepo.findAll();
    }

    public Ronda save(Ronda ronda) {
        return rondaRepo.save(ronda);
    }

    public void deleteById(Long id) {
        rondaRepo.deleteById(id);
    }

    public Ronda findById(Long id) {
        return rondaRepo.findById(id).orElse(null);
    }


}
