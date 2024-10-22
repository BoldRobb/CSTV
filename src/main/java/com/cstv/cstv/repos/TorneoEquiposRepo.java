package com.cstv.cstv.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cstv.cstv.entities.TorneoEquipos;

public interface TorneoEquiposRepo extends JpaRepository<TorneoEquipos, com.cstv.cstv.entities.Ids.TorneoEquiposId> {

    List<TorneoEquipos> findById_IdTorneo(Long idTorneo);
}
