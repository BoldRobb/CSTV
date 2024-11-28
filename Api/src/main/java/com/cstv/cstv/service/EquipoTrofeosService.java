package com.cstv.cstv.service;

import com.cstv.cstv.repos.EquipoTrofeosRepo;
import org.springframework.stereotype.Service;
import com.cstv.cstv.entities.EquipoTrofeos;
import java.util.List;
@Service
public class EquipoTrofeosService {

    private EquipoTrofeosRepo equipoTrofeosRepo;

    public EquipoTrofeosService(EquipoTrofeosRepo equipoTrofeosRepo) {
        this.equipoTrofeosRepo = equipoTrofeosRepo;
    }

    public List<EquipoTrofeos> findAll() {
        return equipoTrofeosRepo.findAll();
    }

    public EquipoTrofeos save(EquipoTrofeos equipoTrofeos) {
        return equipoTrofeosRepo.save(equipoTrofeos);
    }

    public void deleteByIdEquipo(Long idEquipo) {
        equipoTrofeosRepo.deleteById_IdEquipo(idEquipo);
    }
    public void deleteByIdTorneo(Long id) {
        equipoTrofeosRepo.deleteById_IdTorneo(id);
    }


    public List<EquipoTrofeos> findByIdTorneo(Long idTorneo) {
        return equipoTrofeosRepo.findById_IdTorneo(idTorneo);
    }


    public List<EquipoTrofeos> findByIdEquipo(Long idEquipo) {
        return equipoTrofeosRepo.findById_IdEquipo(idEquipo);
    }



}
