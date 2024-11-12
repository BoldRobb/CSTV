package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Equipos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepo extends JpaRepository<Equipos, Long> {
}