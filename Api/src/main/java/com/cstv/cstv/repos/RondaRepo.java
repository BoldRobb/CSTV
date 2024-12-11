package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Ronda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RondaRepo extends JpaRepository<Ronda, Long> {

    public List<Ronda> findAllByTorneo_Id(Long id);

}
