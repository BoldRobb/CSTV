package com.cstv.cstv.repos;
import com.cstv.cstv.entities.MapaStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MapaStatsRepo extends JpaRepository<MapaStats, Long> {

     List<MapaStats> findAllByJugador_Id(Long id);
     List<MapaStats> findAllByEquipo_Id(Long id);

}
