package com.cstv.cstv.repos;

import com.cstv.cstv.entities.RankingHistorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RankingHistorialRepo extends JpaRepository<RankingHistorial, Long>{

    @Query("SELECT r FROM RankingHistorial r WHERE :fecha BETWEEN r.fechaInicio AND r.fechaFin")
    List<RankingHistorial> findAllByFechaBetween(@Param("fecha") Date fecha);

    public List<RankingHistorial> findAllByEquipo_Id(Long equipo_id);
}
