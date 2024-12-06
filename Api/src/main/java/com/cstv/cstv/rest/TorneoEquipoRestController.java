package com.cstv.cstv.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cstv.cstv.entities.Ids.TorneoEquiposId;
import com.cstv.cstv.domain.TorneoEquiposDTO;
import com.cstv.cstv.entities.Equipos;
import com.cstv.cstv.entities.TorneoEquipos;
import com.cstv.cstv.entities.Torneos;
import com.cstv.cstv.service.TorneoEquiposService;

@RestController
@RequestMapping(value = "/api/torneo-equipos")
public class TorneoEquipoRestController {

    @Autowired
    private TorneoEquiposService torneoEquipoService;

    @GetMapping
    public List<TorneoEquipos> getAllTorneoEquipos() {
        return torneoEquipoService.findAll();
    }

    @GetMapping("/{id}")
    public List<TorneoEquipos> getTorneoEquipoByIdTorneo(@PathVariable Long id) {
        return torneoEquipoService.findByTorneoId(id);
    }

    @PostMapping
    public TorneoEquipos createTorneoEquipo(@RequestBody TorneoEquiposDTO torneoEquipoDTO) {
        TorneoEquipos torneoEquipo = new TorneoEquipos();
        torneoEquipo.setId(new TorneoEquiposId(torneoEquipoDTO.getIdTorneo(), torneoEquipoDTO.getIdEquipo()));
        torneoEquipo.setIdEquipo(new Equipos());
        torneoEquipo.setIdTorneo(new Torneos());
        torneoEquipo.getIdEquipo().setId(torneoEquipoDTO.getIdEquipo());
        torneoEquipo.getIdTorneo().setId(torneoEquipoDTO.getIdTorneo());
        torneoEquipo.setPosicion(torneoEquipoDTO.getPosicion());
        torneoEquipo.setPremio(torneoEquipoDTO.getPremio());
        return torneoEquipoService.save(torneoEquipo);
    }

    @DeleteMapping("/{idTorneo}/{idEquipo}")
    public ResponseEntity<Void> deleteTorneoEquipo(@PathVariable Long idTorneo, @PathVariable Long idEquipo) {
        TorneoEquiposId id = new TorneoEquiposId(idTorneo, idEquipo) ;
        if (!torneoEquipoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        torneoEquipoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/list/")
    public List<TorneoEquipos> createTorneoEquipos( @RequestBody List<TorneoEquiposDTO> torneoEquiposDTOList) {
        List<TorneoEquipos> torneoEquiposList = torneoEquiposDTOList.stream().map(dto -> {

            TorneoEquipos torneoEquipo = new TorneoEquipos();
            torneoEquipo.setId(new TorneoEquiposId(dto.getIdTorneo(), dto.getIdEquipo()));
            torneoEquipo.setIdEquipo(new Equipos());
            torneoEquipo.setIdTorneo(new Torneos());
            torneoEquipo.getIdEquipo().setId(dto.getIdEquipo());
            torneoEquipo.getIdTorneo().setId(dto.getIdTorneo());
            torneoEquipo.setPosicion(dto.getPosicion());
            torneoEquipo.setPremio(dto.getPremio());
            return torneoEquipo;
        }).collect(Collectors.toList());
        return torneoEquipoService.saveAll(torneoEquiposList);
    }

    @GetMapping("/equipo/{id}")
    public List<TorneoEquipos> getTorneoEquipoByEquipoId(@PathVariable Long id) {
        return  torneoEquipoService.findByEquipoId(id);

    }

}
