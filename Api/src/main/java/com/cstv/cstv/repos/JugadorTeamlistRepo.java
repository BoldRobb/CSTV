package com.cstv.cstv.repos;

import com.cstv.cstv.entities.JugadorTeamlist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorTeamlistRepo extends JpaRepository<JugadorTeamlist, com.cstv.cstv.entities.Ids.JugadorTeamlistId> {
    List<JugadorTeamlist> findById_IdJugador(Long idJugador);
}
