package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Respuestas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepo extends JpaRepository<Respuestas, Long> {
    List<Respuestas> findAllByTopico_Id(Long id);
    List<Respuestas> findAllByRespuestaPadre(Long id);
}
