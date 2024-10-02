package com.cstv.cstv.rest;

import com.cstv.cstv.entities.JugadorTeamlist;
import com.cstv.cstv.service.JugadorTeamlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jugador-teamlist")
public class JugadorTeamlistRestController {

    @Autowired
    private JugadorTeamlistService jugadorTeamlistService;

    @GetMapping
    public List<JugadorTeamlist> getAllJugadorTeamlist() {
        return jugadorTeamlistService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorTeamlist> getJugadorTeamlistById(@PathVariable Long id) {
        return jugadorTeamlistService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public JugadorTeamlist createJugadorTeamlist(@RequestBody JugadorTeamlist jugadorTeamlist) {
        return jugadorTeamlistService.save(jugadorTeamlist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JugadorTeamlist> updateJugadorTeamlist(@PathVariable Long id, @RequestBody JugadorTeamlist jugadorTeamlist) {
        if (!jugadorTeamlistService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(jugadorTeamlistService.save(jugadorTeamlist));
    }

}
