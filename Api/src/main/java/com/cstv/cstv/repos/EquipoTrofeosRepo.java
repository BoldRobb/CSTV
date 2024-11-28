package com.cstv.cstv.repos;

import com.cstv.cstv.entities.EquipoJugadores;
import com.cstv.cstv.entities.EquipoTrofeos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoTrofeosRepo extends JpaRepository<EquipoTrofeos, com.cstv.cstv.entities.Ids.EquipoTrofeosId> {
    List<EquipoTrofeos> findById_IdEquipo(Long idEquipo);
    List<EquipoTrofeos> findById_IdTorneo(Long idTorneo);
    void deleteById_IdEquipo(Long idEquipo);
    void deleteById_IdTorneo(Long idTorneo);
}
