package com.cstv.cstv.repos;

import com.cstv.cstv.entities.JugadorTrofeos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorTrofeosRepo extends JpaRepository<JugadorTrofeos, com.cstv.cstv.entities.Ids.JugadorTrofeosId> {
    List<JugadorTrofeos> findByIdJugador(Long idJugador);
}
