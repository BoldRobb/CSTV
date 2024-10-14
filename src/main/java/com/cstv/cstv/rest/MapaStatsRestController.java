package com.cstv.cstv.rest;

import com.cstv.cstv.entities.MapaStats;
import com.cstv.cstv.repos.MapaStatsRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/mapas-stats")
public class MapaStatsRestController {

    MapaStatsRepo mapaStatsRepo;

    @GetMapping
    public List<MapaStats> getAllMapaStats(){
        return mapaStatsRepo.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<MapaStats> getMapaStatsById(@PathVariable(name = "id") long id){
        return mapaStatsRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MapaStats createMapaStats(@RequestBody MapaStats mapaStats){
        return mapaStatsRepo.save(mapaStats);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MapaStats> updateMapaStats(@PathVariable(name = "id") long id, @RequestBody MapaStats mapaStats ){
        if(!mapaStatsRepo.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapaStatsRepo.save(mapaStats));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMapaStats(@PathVariable(name = "id") long id){
        if(!mapaStatsRepo.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        mapaStatsRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
