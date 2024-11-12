package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Torneos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepo extends JpaRepository<Torneos, Long> {
}
