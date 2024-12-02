package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Mapa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MapaRepo extends JpaRepository<Mapa, Long> {

    List<Mapa> findByPartido_Id(Long idPartido);
}
