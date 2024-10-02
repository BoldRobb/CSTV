package com.cstv.cstv.repos;

import com.cstv.cstv.entities.TorneoEquipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TorneoEquiposRepo extends JpaRepository<TorneoEquipos, Long> {

    @Query("SELECT te FROM TorneoEquipos te WHERE te.torneo.id = :idTorneo")
    List<TorneoEquipos> findByTorneoId(@Param("idTorneo") Long idTorneo);
}
