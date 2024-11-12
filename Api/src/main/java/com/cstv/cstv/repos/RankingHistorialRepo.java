package com.cstv.cstv.repos;

import com.cstv.cstv.entities.RankingHistorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RankingHistorialRepo extends JpaRepository<RankingHistorial, Long>{

    public List<RankingHistorial> findAllByFechaOrderByRankingDesc(Date fecha);
    public List<RankingHistorial> findAllByEquipo_Id(Long equipo_id);
}
