package com.cstv.cstv.repos;

import com.cstv.cstv.entities.EquipoJugadores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoJugadoresRepo extends JpaRepository<EquipoJugadores, com.cstv.cstv.entities.Ids.EquipoJugadoresId> {

    List<EquipoJugadores> findByIdEquipo(Long idEquipo);
    List<EquipoJugadores> findByIdJugador(Long idJugador);
    void deleteByIdJugador(Long idJugador);
}
