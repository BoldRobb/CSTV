package com.cstv.cstv.rest;

import com.cstv.cstv.domain.PartidoDTO;
import com.cstv.cstv.domain.RankingHistorialDTO;
import com.cstv.cstv.entities.Equipos;
import com.cstv.cstv.entities.Partido;
import com.cstv.cstv.entities.RankingHistorial;
import com.cstv.cstv.entities.Torneos;
import com.cstv.cstv.service.RankingHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/ranking")
public class RankingHistorialRestController {
    @Autowired
    private RankingHistorialService rankingHistorialService;

    @GetMapping
    public List<RankingHistorial> getAllRanking() {
        return rankingHistorialService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RankingHistorial> getPartidoById(@PathVariable Long id) {
        return rankingHistorialService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RankingHistorial createRanking(@RequestBody RankingHistorialDTO rankingHistorialDTO) {
        RankingHistorial rankingHistorial = new RankingHistorial();
        rankingHistorial.setId(rankingHistorialDTO.getId());
        rankingHistorial.setEquipo(new Equipos());
        rankingHistorial.getEquipo().setId(rankingHistorialDTO.getEquipo_id());
        rankingHistorial.setFechaInicio(rankingHistorialDTO.getFechaInicio());
        rankingHistorial.setFechaFin(rankingHistorialDTO.getFechaFin());
        rankingHistorial.setRanking(rankingHistorialDTO.getRanking());
        rankingHistorial.setPuntos(rankingHistorialDTO.getPuntos());
        return rankingHistorialService.save(rankingHistorial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RankingHistorial> updateRanking(@PathVariable Long id, @RequestBody RankingHistorial rankingHistorial) {
        if (!rankingHistorialService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rankingHistorial.setId(id);
        return ResponseEntity.ok(rankingHistorialService.save(rankingHistorial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRanking(@PathVariable Long id) {
        if (!rankingHistorialService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rankingHistorialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/fecha/{fecha}")
    public List<RankingHistorial> getRankingByFecha(@PathVariable String fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = new Date();
        fechaDate = formato.parse(fecha);

        return rankingHistorialService.findAllByFecha(fechaDate);
    }
    @GetMapping("/equipo/{id}")
    public List<RankingHistorial> getRankingByEquipo(@PathVariable Long id) {
        return rankingHistorialService.findAllByEquipo(id);
    }
}
