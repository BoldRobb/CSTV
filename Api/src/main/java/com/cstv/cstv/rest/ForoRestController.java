package com.cstv.cstv.rest;

import com.cstv.cstv.entities.Foro;
import com.cstv.cstv.service.ForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/foros")
public class ForoRestController {

    @Autowired
    private ForoService foroService;

    @GetMapping
    public List<Foro> getAllForos() {
        return foroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Foro> getForoById(@PathVariable Long id) {
        return foroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Foro createForo(@RequestBody Foro foro) {
        return foroService.save(foro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Foro> updateForo(@PathVariable Long id, @RequestBody Foro foro) {
        if (!foroService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        foro.setId(id);
        return ResponseEntity.ok(foroService.save(foro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteForo(@PathVariable Long id) {
        if (!foroService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        foroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
