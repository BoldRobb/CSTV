package com.cstv.cstv.service;

import com.cstv.cstv.entities.Equipos;
import com.cstv.cstv.repos.EquipoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepo equipoRepo;

    public List<Equipos> findAll() {
        return equipoRepo.findAll();
    }

    public Optional<Equipos> findById(Long id) {
        return equipoRepo.findById(id);
    }

    public Equipos save(Equipos equipo) {
        return equipoRepo.save(equipo);
    }

    public void deleteById(Long id) {
        equipoRepo.deleteById(id);
    }
}
