package com.cstv.cstv.rest;



import java.util.List;

import com.cstv.cstv.CstvApplication;
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
    private static Logger logger = LoggerFactory.getLogger(UsuariosRest.class);
    private final  UsuariosService usuariosService;

    public UsuariosRest(UsuariosService userService) {
        this.usuariosService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UsuariosDTO>> getAllUsers() {
        return ResponseEntity.ok(usuariosService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuariosDTO> getUser(@PathVariable(name = "id") final Long id) {

        return ResponseEntity.ok(usuariosService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody @Valid final UsuariosDTO userDTO) {
        final Long createdId = usuariosService.create(userDTO);

        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateUser(@PathVariable(name = "id") final Long id,
                                           @RequestBody @Valid final UsuariosDTO userDTO) {
        usuariosService.update(id, userDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") final Long id) {
        usuariosService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
