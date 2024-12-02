package com.cstv.cstv.rest;

import com.cstv.cstv.domain.NoticiaDTO;
import com.cstv.cstv.entities.*;
import com.cstv.cstv.service.EquipoService;
import com.cstv.cstv.service.JugadorService;
import com.cstv.cstv.service.NoticiaService;
import com.cstv.cstv.service.TorneoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/noticias")
public class NoticiaRestController {

    @Autowired
    private NoticiaService noticiaService;
    @Autowired
    private EquipoService equiposService;

    @Autowired
    private TorneoService torneosService;

    @Autowired
    private JugadorService jugadoresService;

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
    public Noticia createNoticia(@RequestBody NoticiaDTO noticiaDTO) {
        Noticia noticia = new Noticia();
        noticia.setUsuario(new Usuarios());
        noticia.getUsuario().setId(noticiaDTO.getUsuarioId());
        noticia.setImagen(noticiaDTO.getImagen());
        noticia.setHtml(noticiaDTO.getHtml());
        noticia.setFecha(noticiaDTO.getFecha());
        noticia.setTitulo(noticiaDTO.getTitulo());
        List<Equipos> equipos = noticiaDTO.getEquiposIds().stream()
                .map(equiposService::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        noticia.setEquipos(equipos);

        List<Torneos> torneos = noticiaDTO.getTorneosIds().stream()
                .map(torneosService::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        noticia.setTorneos(torneos);

        List<Jugadores> jugadores = noticiaDTO.getJugadoresIds().stream()
                .map(jugadoresService::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        noticia.setJugadores(jugadores);
        return noticiaService.save(noticia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Noticia> updateNoticia(@PathVariable Long id, @RequestBody NoticiaDTO noticiaDTO) {
        if (!noticiaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Noticia noticia = noticiaService.findById(id).get();
        noticia.setUsuario(new Usuarios());
        noticia.getUsuario().setId(noticiaDTO.getUsuarioId());
        noticia.setImagen(noticiaDTO.getImagen());
        noticia.setHtml(noticiaDTO.getHtml());
        noticia.setFecha(noticiaDTO.getFecha());
        noticia.setTitulo(noticiaDTO.getTitulo());

        List<Equipos> equipos = noticiaDTO.getEquiposIds().stream()
                .map(equiposService::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        noticia.setEquipos(equipos);

        List<Torneos> torneos = noticiaDTO.getTorneosIds().stream()
                .map(torneosService::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        noticia.setTorneos(torneos);

        List<Jugadores> jugadores = noticiaDTO.getJugadoresIds().stream()
                .map(jugadoresService::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
        noticia.setJugadores(jugadores);
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
    @GetMapping("/date")
    public List<Noticia> getAllNoticiasByDateList() {
        return noticiaService.findAllByOrderByFechaDesc();
    }

    @GetMapping("/user/{id}")
    public List<Noticia> getAllNoticiasByUser(@PathVariable Long id) {
        return noticiaService.findAllByUsuario_Id(id);
    }

    @GetMapping("/equipos/{id}")
    public List<Noticia> getAllNoticiasByEquipos(@PathVariable Long id) {
        return noticiaService.findAllByEquipos_Id(id);
    }

    @GetMapping("/torneos/{id}")
    public List<Noticia> getAllNoticiasByTorneos(@PathVariable Long id) {
        return noticiaService.findAllByTorneos_Id(id);
    }

    @GetMapping("/jugadores/{id}")
    public List<Noticia> getAllNoticiasByJugadores(@PathVariable Long id) {
        return noticiaService.findAllByJugadores_Id(id);
    }

}
