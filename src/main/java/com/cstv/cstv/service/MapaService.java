package com.cstv.cstv.service;

import com.cstv.cstv.entities.Mapa;
import com.cstv.cstv.repos.MapaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapaService {

    @Autowired
    private MapaRepo mapaRepo;

    public List<Mapa> findAll() {
        return mapaRepo.findAll();
    }

    public Optional<Mapa> findById(Long id) {
        return mapaRepo.findById(id);
    }

    public Mapa save(Mapa mapa) {
        return mapaRepo.save(mapa);
    }

    public void deleteById(Long id) {
        mapaRepo.deleteById(id);
    }
}
