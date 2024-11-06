package com.cstv.cstv.service;

import com.cstv.cstv.entities.RankingHistorial;
import com.cstv.cstv.repos.RankingHistorialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RankingHistorialService {
    @Autowired
    private RankingHistorialRepo rankingHistorialRepo;

    public List<RankingHistorial> findAll(){
        return rankingHistorialRepo.findAll();
    }
    public Optional<RankingHistorial> findById(Long id){
        return rankingHistorialRepo.findById(id);
    }
    public RankingHistorial save(RankingHistorial rankingHistorial){
        return rankingHistorialRepo.save(rankingHistorial);
    }
    public void deleteById(Long id){
        rankingHistorialRepo.deleteById(id);
    }

    public List<RankingHistorial> findAllByFecha(Date fecha){
        return rankingHistorialRepo.findAllByFechaOrderByRankingDesc(fecha);
    }
    public List<RankingHistorial> findAllByEquipo(Long equipo){
        return rankingHistorialRepo.findAllByEquipo_Id(equipo);
    }

}
