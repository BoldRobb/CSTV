package com.cstv.cstv.service;

import com.cstv.cstv.entities.MapaStats;
import com.cstv.cstv.repos.MapaStatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MapaStatsService {

    @Autowired
    private MapaStatsRepo mapaStatsRepo;

    public List<MapaStats> findAll() {
        return mapaStatsRepo.findAll();
    }

    public Optional<MapaStats> findById(Long id) {
        return mapaStatsRepo.findById(id);
    }

    public MapaStats save(MapaStats mapaStats) {
        return mapaStatsRepo.save(mapaStats);
    }

    public void deleteById(Long id) {
        mapaStatsRepo.deleteById(id);
    }
}
