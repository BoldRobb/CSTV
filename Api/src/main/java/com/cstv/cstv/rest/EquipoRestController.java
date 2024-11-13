package com.cstv.cstv.rest;

import com.cstv.cstv.entities.Equipos;
import com.cstv.cstv.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/equipos")
public class EquipoRestController {

    @Autowired
    private EquipoService equipoService;

    @GetMapping
    public List<Equipos> getAllEquipos() {
        return equipoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipos> getEquipoById(@PathVariable Long id) {
        return equipoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipos createEquipo(@RequestBody Equipos equipo) {
        equipo.setId(null);
        return equipoService.save(equipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipos> updateEquipo(@PathVariable Long id, @RequestBody Equipos equipo) {
        if (!equipoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        equipo.setId(id);
        return ResponseEntity.ok(equipoService.save(equipo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipo(@PathVariable Long id) {
        if (!equipoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        equipoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Equipos> getEquipoByNombre(@PathVariable String nombre) {
        return equipoService.findByNombreContainingIgnoreCase(nombre);
    }
}
