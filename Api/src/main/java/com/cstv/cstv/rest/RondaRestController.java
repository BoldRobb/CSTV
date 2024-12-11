package com.cstv.cstv.rest;

import com.cstv.cstv.domain.RondaDTO;
import com.cstv.cstv.entities.Ronda;
import com.cstv.cstv.entities.Torneos;
import com.cstv.cstv.service.RondaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/ronda")
public class RondaRestController {
    @Autowired
    private RondaService rondaService;

    @GetMapping
    public List<Ronda> getAllRondas() {
        return rondaService.findAll();
    }

    @GetMapping("/{id}")
    public Ronda getRondaById( @PathVariable Long id) {
        return rondaService.findById(id);
    }

    @GetMapping("/torneo/{id}")
    public List<Ronda> getRondasByTorneo(@PathVariable Long id) {
        return rondaService.findAllByTorneoId(id);
    }

    @PostMapping
    public Ronda createRonda(RondaDTO rondadto) {
        Ronda ronda = new Ronda();
        ronda.setId(rondadto.getId());
        ronda.setNombre(rondadto.getNombre());
        ronda.setTorneo(new Torneos());
        ronda.getTorneo().setId(rondadto.getIdTorneo());

        return rondaService.save(ronda);
    }

    @PostMapping("/{id}")
    public Ronda updateRonda(@PathVariable Long id, Ronda ronda) {
        ronda.setId(id);
        return rondaService.save(ronda);
    }

    @DeleteMapping("/{id}")
    public void deleteRonda(@PathVariable Long id) {
        rondaService.deleteById(id);
    }

}
