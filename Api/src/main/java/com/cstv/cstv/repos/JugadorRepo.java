package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Jugadores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugadorRepo extends JpaRepository<Jugadores, Long> {
        List<Jugadores> findByMoteContainingIgnoreCaseOrNombreRealContainingIgnoreCase(String mote, String nombreReal);

}
