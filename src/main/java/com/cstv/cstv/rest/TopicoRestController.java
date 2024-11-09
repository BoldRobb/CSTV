package com.cstv.cstv.rest;

import com.cstv.cstv.domain.TopicoDTO;
import com.cstv.cstv.entities.Foro;
import com.cstv.cstv.entities.Topico;
import com.cstv.cstv.entities.Usuarios;
import com.cstv.cstv.service.ForoService;
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

    private ForoService foroService;


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

    @GetMapping("/date")
    public List<Topico> getAllTopicosByDate(){
        return topicoService.findAllOrderByDesc();
    }
    @GetMapping("/latest")
    public List<Topico> getAllTopicosByLatest(){
        return topicoService.findAllByOrderByLatest();
    }

    @PostMapping
    public Topico createTopico(@RequestBody TopicoDTO topicoDTO) {
        Topico topico = new Topico();
        topico.setTitulo(topicoDTO.getTitulo());
        topico.setDescripcion(topicoDTO.getDescripcion());
        topico.setFecha(topicoDTO.getFecha());
        topico.setId(topicoDTO.getId());
        topico.setForo(new Foro());
        topico.getForo().setId(topicoDTO.getIdForo());
        topico.setUsuario(new Usuarios());
        topico.getUsuario().setId(topicoDTO.getIdUsuario());
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
    @GetMapping("/byForum/{id}")
    public List<Topico> getAllByIdForo(@PathVariable Long id) {
        return topicoService.findAllByForo_Id(id);
    }
}
