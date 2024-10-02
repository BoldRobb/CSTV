package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Jugadores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JugadorRepo extends JpaRepository<Jugadores, Long> {
}
