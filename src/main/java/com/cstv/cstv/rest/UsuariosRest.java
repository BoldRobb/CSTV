package com.cstv.cstv.rest;



import java.util.List;

import com.cstv.cstv.CstvApplication;
import com.cstv.cstv.entities.Usuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cstv.cstv.domain.UsuariosDTO;
import com.cstv.cstv.service.UsuariosService;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/api/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuariosRest {
    private final  UsuariosService usuariosService;

    public UsuariosRest(UsuariosService userService) {
        this.usuariosService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> getAllUsers() {
        return ResponseEntity.ok(usuariosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUser(@PathVariable(name = "id") final Long id) {

        return usuariosService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuarios createUser(@RequestBody Usuarios usuarios) {
        return usuariosService.save(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateUser(@PathVariable(name = "id") Long id, @RequestBody Usuarios usuarios) {
        if (!usuariosService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        usuarios.setID(id);
        return ResponseEntity.ok(usuariosService.save(usuarios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        if(!usuariosService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        usuariosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
