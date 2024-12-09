package com.cstv.cstv.rest;

import com.cstv.cstv.domain.MapaStatsDTO;
import com.cstv.cstv.entities.Equipos;
import com.cstv.cstv.entities.Jugadores;
import com.cstv.cstv.entities.Mapa;
import com.cstv.cstv.entities.MapaStats;
import com.cstv.cstv.repos.MapaStatsRepo;
import com.cstv.cstv.service.MapaService;
import com.cstv.cstv.service.MapaStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/mapas-stats")
public class MapaStatsRestController {

    @Autowired
    MapaStatsService mapaStatsService;

    @Autowired
    MapaService mapaService;

    @GetMapping
    public List<MapaStats> getAllMapaStats(){
        return mapaStatsService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<MapaStats> getMapaStatsById(@PathVariable(name = "id") long id){
        return mapaStatsService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MapaStats createMapaStats(@RequestBody MapaStatsDTO mapaStatsDTO){
        MapaStats mapaStats = new MapaStats();
        mapaStats.setMapa(new Mapa());
        mapaStats.getMapa().setId(mapaStatsDTO.getIdMapa());
        mapaStats.setEquipo(new Equipos());
        mapaStats.getEquipo().setId(mapaStatsDTO.getIdEquipo());
        mapaStats.setJugador(new Jugadores());
        mapaStats.getJugador().setId(mapaStatsDTO.getIdJugador());
        mapaStats.setAsesinatos(mapaStatsDTO.getAsesinatos());
        mapaStats.setMuertes(mapaStatsDTO.getMuertes());
        mapaStats.setKd(mapaStatsDTO.getKD());
        mapaStats.setAdr(mapaStatsDTO.getADR());
        return mapaStatsService.save(mapaStats);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MapaStats> updateMapaStats(@PathVariable(name = "id") long id, @RequestBody MapaStats mapaStats ){
        if(!mapaStatsService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapaStatsService.save(mapaStats));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMapaStats(@PathVariable(name = "id") long id){
        if(!mapaStatsService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        mapaStatsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/jugador/{id}")
    public List<MapaStats> getMapaStatsByJugadorId(@PathVariable(name = "id") long id){
        return mapaStatsService.findAllByJugador_Id(id);
    }

    @GetMapping("/equipo/{id}")
    public List<MapaStats> getMapaStatsByEquipoId(@PathVariable(name = "id") long id){
        return mapaStatsService.findAllByEquipo_Id(id);
    }
    @GetMapping("/partido/{id}")
    public List<MapaStats> getMapaStatsByPartidoId(@PathVariable(name = "id") long id){
        List<Mapa> mapas = mapaService.findByPartido_Id(id);
        return mapaStatsService.findAllByMapaIn(mapas);
    }
}
