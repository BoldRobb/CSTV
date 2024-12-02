package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Partido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidoRepo extends JpaRepository<Partido, Long> {

    List<Partido> findByTorneo_Id(Long torneoId);

    List<Partido> findByEquipo1_IdOrEquipo2_Id(Long equipoId1, Long equipoId2);

}
