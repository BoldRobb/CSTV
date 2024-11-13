package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Equipos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoRepo extends JpaRepository<Equipos, Long> {

    List<Equipos> findByNombreContainingIgnoreCase(String nombre);
}