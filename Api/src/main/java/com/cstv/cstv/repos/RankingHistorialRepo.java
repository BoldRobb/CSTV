package com.cstv.cstv.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cstv.cstv.entities.RankingHistorial;

public interface RankingHistorialRepo extends JpaRepository<RankingHistorial, Long>{

    @Query("SELECT r FROM RankingHistorial r WHERE :fecha BETWEEN r.fechaInicio AND r.fechaFin")
    List<RankingHistorial> findAllByFechaBetween(@Param("fecha") Date fecha);

    public List<RankingHistorial> findAllByEquipo_Id(Long equipo_id);

}
