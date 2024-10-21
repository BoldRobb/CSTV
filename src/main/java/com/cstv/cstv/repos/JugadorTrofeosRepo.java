package com.cstv.cstv.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cstv.cstv.entities.JugadorTrofeos;

public interface JugadorTrofeosRepo extends JpaRepository<JugadorTrofeos, com.cstv.cstv.entities.Ids.JugadorTrofeosId> {
    List<JugadorTrofeos> findByIdJugador(Long idJugador);
    void deleteByIdJugadorIdTorneo(Long idJugador, Long idTrofeo);
}
