package com.cstv.cstv.service;

import com.cstv.cstv.entities.TorneoEquipos;
import com.cstv.cstv.repos.TorneoEquiposRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorneoEquiposService {

    @Autowired
    private TorneoEquiposRepo torneoEquiposRepo;

    public List<TorneoEquipos> findAll() {
        return torneoEquiposRepo.findAll();
    }

    public Optional<TorneoEquipos> findById(Long id) {
        return torneoEquiposRepo.findById(id);
    }

    public List<TorneoEquipos> findByTorneoId(Long idTorneo) {
        return torneoEquiposRepo.findByTorneoId(idTorneo);
    }

    public TorneoEquipos save(TorneoEquipos torneoEquipos) {
        return torneoEquiposRepo.save(torneoEquipos);
    }

    public void deleteById(Long id) {
        torneoEquiposRepo.deleteById(id);
    }
}
