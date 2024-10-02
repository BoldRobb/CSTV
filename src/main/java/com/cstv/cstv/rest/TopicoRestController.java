package com.cstv.cstv.rest;

import com.cstv.cstv.entities.Topico;
import com.cstv.cstv.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/topicos")
public class TopicoRestController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<Topico> getAllTopicos() {
        return topicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getTopicoById(@PathVariable Long id) {
        return topicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Topico createTopico(@RequestBody Topico topico) {
        return topicoService.save(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> updateTopico(@PathVariable Long id, @RequestBody Topico topico) {
        if (!topicoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        topico.setId(id);
        return ResponseEntity.ok(topicoService.save(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopico(@PathVariable Long id) {
        if (!topicoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        topicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
