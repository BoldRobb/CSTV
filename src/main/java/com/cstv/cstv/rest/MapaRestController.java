package com.cstv.cstv.rest;

import com.cstv.cstv.entities.Mapa;
import com.cstv.cstv.repos.MapaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/mapas")
public class MapaRestController {

    @Autowired
    MapaRepo mapaRepo;

    @GetMapping
    public List<Mapa> getAllMapas(){
        return mapaRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mapa> getMapasById(@PathVariable(name = "id") final Long id){
        return mapaRepo.findById(id).
                map(ResponseEntity::ok).
                orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mapa createMapa(@RequestBody Mapa mapa){
        return mapaRepo.save(mapa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mapa> updateMapa(@PathVariable(name = "id") Long id, @RequestBody Mapa mapa){
        if(!mapaRepo.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapaRepo.save(mapa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMapa(@PathVariable(name = "id") Long id){
        if(!mapaRepo.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        mapaRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
