package com.cstv.cstv.repos;

import com.cstv.cstv.entities.EquipoJugadores;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoJugadoresRepo extends JpaRepository<EquipoJugadores, com.cstv.cstv.entities.Ids.EquipoJugadoresId> {

    List<EquipoJugadores> findById_IdEquipo(Long idEquipo);
    List<EquipoJugadores> findById_IdJugador(Long idJugador);
    void deleteById_IdJugador(Long idJugador);
}
