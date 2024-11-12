package com.cstv.cstv.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cstv.cstv.entities.JugadorTrofeos;
import com.cstv.cstv.entities.Ids.JugadorTrofeosId;

public interface JugadorTrofeosRepo extends JpaRepository<JugadorTrofeos, com.cstv.cstv.entities.Ids.JugadorTrofeosId> {
    List<JugadorTrofeos> findById_IdJugador(Long idJugador);
    void deleteById(JugadorTrofeosId id);
}
