package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Torneos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TorneoRepo extends JpaRepository<Torneos, Long> {

    List<Torneos> findByNombreContainingIgnoreCase(String nombre);
}
