package com.cstv.cstv.rest;

import com.cstv.cstv.domain.PartidoDTO;
import com.cstv.cstv.entities.Equipos;
import com.cstv.cstv.entities.Partido;
import com.cstv.cstv.entities.Ronda;
import com.cstv.cstv.entities.Torneos;
import com.cstv.cstv.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/partidos")
public class PartidoRestController {

    @Autowired
    private PartidoService partidoService;

    @GetMapping
    public List<Partido> getAllPartidos() {
        return partidoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> getPartidoById(@PathVariable Long id) {
        return partidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partido createPartido(@RequestBody PartidoDTO partidoDTO) {
        Partido partido = new Partido();
        partido.setId(partidoDTO.getId());
        partido.setEquipo1(new Equipos());
        partido.getEquipo1().setId(partidoDTO.getEquipo1());
        partido.setEquipo2(new Equipos());
        partido.getEquipo2().setId(partidoDTO.getEquipo2());
        partido.setTorneo(new Torneos());
        partido.getTorneo().setId(partidoDTO.getIdTorneo());
        partido.setGanador(new Equipos());
        partido.getGanador().setId(partidoDTO.getIdGanador());
        partido.setFormato(partidoDTO.getFormato());
        partido.setMarcador(partidoDTO.getMarcador());
        partido.setFecha(partidoDTO.getFecha());
        partido.setTipo(partidoDTO.getTipo());
        partido.setRonda(new Ronda());
        partido.getRonda().setId(partidoDTO.getIdronda());

        return partidoService.save(partido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partido> updatePartido(@PathVariable Long id, @RequestBody PartidoDTO partidoDTO) {
        if (!partidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Partido partido = new Partido();
        partido.setId(partidoDTO.getId());
        partido.setEquipo1(new Equipos());
        partido.getEquipo1().setId(partidoDTO.getEquipo1());
        partido.setEquipo2(new Equipos());
        partido.getEquipo2().setId(partidoDTO.getEquipo2());
        partido.setTorneo(new Torneos());
        partido.getTorneo().setId(partidoDTO.getIdTorneo());
        partido.setGanador(new Equipos());
        partido.getGanador().setId(partidoDTO.getIdGanador());
        partido.setFormato(partidoDTO.getFormato());
        partido.setMarcador(partidoDTO.getMarcador());
        partido.setFecha(partidoDTO.getFecha());
        return ResponseEntity.ok(partidoService.save(partido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartido(@PathVariable Long id) {
        if (!partidoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        partidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/torneo/{torneoId}")
    public List<Partido> getPartidoByTorneoId(@PathVariable Long torneoId) {
        return partidoService.findByTorneo_Id(torneoId);
    }

    @GetMapping("/equipo/{equipoId}")
    public List<Partido> getPartidoByEquipoId(@PathVariable Long equipoId) {
        return partidoService.findByEquipo1_IdOrEquipo2_Id(equipoId);
    }
    @PostMapping("/list")
    public List<Partido> createPartidos(@RequestBody List<PartidoDTO> partidoDTOList) {
        List<Partido> partidos = partidoDTOList.stream().map(dto -> {
            Partido partido = new Partido();
            partido.setId(dto.getId());
            partido.setEquipo1(new Equipos());
            partido.getEquipo1().setId(dto.getEquipo1());
            partido.setEquipo2(new Equipos());
            partido.getEquipo2().setId(dto.getEquipo2());
            partido.setTorneo(new Torneos());
            partido.getTorneo().setId(dto.getIdTorneo());
            partido.setGanador(new Equipos());
            partido.getGanador().setId(dto.getIdGanador());
            partido.setFormato(dto.getFormato());
            partido.setMarcador(dto.getMarcador());
            partido.setFecha(dto.getFecha());
            return partido;
        }).collect(Collectors.toList());
        return partidoService.saveAll(partidos);
    }
}
