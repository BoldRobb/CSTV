package com.cstv.cstv.rest;

import com.cstv.cstv.domain.EquipoTrofeosDTO;
import com.cstv.cstv.entities.EquipoTrofeos;
import com.cstv.cstv.entities.Equipos;
import com.cstv.cstv.entities.Ids.EquipoTrofeosId;
import com.cstv.cstv.entities.Torneos;
import com.cstv.cstv.service.EquipoTrofeosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/equipo-trofeos")
public class EquipoTrofeosRestController {

    private EquipoTrofeosService equipoTrofeosService;

    public EquipoTrofeosRestController(EquipoTrofeosService equipoTrofeosService) {
        this.equipoTrofeosService = equipoTrofeosService;
    }

    @GetMapping
    public List<EquipoTrofeos> getAllEquipoTrofeos() {
        return equipoTrofeosService.findAll();
    }

    @PostMapping
    public EquipoTrofeos createEquipoTrofeos(@RequestBody EquipoTrofeosDTO equipoTrofeosDTO) {
        EquipoTrofeos equipoTrofeos = new EquipoTrofeos();
        equipoTrofeos.setId(new EquipoTrofeosId(equipoTrofeosDTO.getIdEquipo(), equipoTrofeosDTO.getIdTorneo()));
        equipoTrofeos.setTorneos(new Torneos());
        equipoTrofeos.getTorneos().setId(equipoTrofeosDTO.getIdTorneo());
        equipoTrofeos.setEquipo(new Equipos());
        equipoTrofeos.getEquipo().setId(equipoTrofeosDTO.getIdEquipo());

        return equipoTrofeosService.save(equipoTrofeos);
    }

    @DeleteMapping("/equipo/{idEquipo}")
    public void deleteByIdEquipo(@PathVariable Long idEquipo) {

        equipoTrofeosService.deleteByIdEquipo(idEquipo);
    }

    @DeleteMapping("/torneo/{idTorneo}")
    public void deleteByIdTorneo(@PathVariable Long idTorneo) {
        equipoTrofeosService.deleteByIdTorneo(idTorneo);
    }

    @GetMapping("/torneo/{idTorneo}")
    public List<Equipos> getByIdTorneo(@PathVariable Long idTorneo) {

        return equipoTrofeosService.findByIdTorneo(idTorneo).stream().map(EquipoTrofeos::getEquipo).toList();
    }

    @GetMapping("/equipo/{idEquipo}")
    public List<Torneos> getByIdEquipo(@PathVariable Long idEquipo) {
        return equipoTrofeosService.findByIdEquipo(idEquipo).stream().map(EquipoTrofeos::getTorneos).toList();
    }

}
