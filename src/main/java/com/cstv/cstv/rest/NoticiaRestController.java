package com.cstv.cstv.rest;

import com.cstv.cstv.entities.Noticia;
import com.cstv.cstv.service.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/noticias")
public class NoticiaRestController {

    @Autowired
    private NoticiaService noticiaService;

    @GetMapping
    public List<Noticia> getAllNoticias() {
        return noticiaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Noticia> getNoticiaById(@PathVariable Long id) {
        return noticiaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Noticia createNoticia(@RequestBody Noticia noticia) {
        return noticiaService.save(noticia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> updateNoticia(@PathVariable Long id, @RequestBody Noticia noticia) {
        if (!noticiaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        noticia.setId(id);
        return ResponseEntity.ok(noticiaService.save(noticia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoticia(@PathVariable Long id) {
        if (!noticiaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        noticiaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
