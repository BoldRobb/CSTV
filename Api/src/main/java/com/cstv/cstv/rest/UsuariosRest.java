package com.cstv.cstv.rest;



import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.cstv.cstv.entities.Usuarios;
import com.cstv.cstv.service.UsuariosService;


@RestController
@RequestMapping(value = "/api/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuariosRest {
    private final  UsuariosService usuariosService;
    private final PasswordEncoder passwordEncoder;


    public UsuariosRest(UsuariosService userService, PasswordEncoder passwordEncoder) {
        this.usuariosService = userService;
        this.passwordEncoder = passwordEncoder;
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
        String hashedPassword = passwordEncoder.encode(usuarios.getPassword());
        usuarios.setPassword(hashedPassword);
        return usuariosService.save(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateUser(@PathVariable(name = "id") Long id, @RequestBody Usuarios usuarios) {
        Optional<Usuarios> existingUser = usuariosService.findById(id);
        if (!existingUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Usuarios userToUpdate = existingUser.get();
        if (!usuarios.getPassword().equals(userToUpdate.getPassword())) {
            String hashedPassword = passwordEncoder.encode(usuarios.getPassword());
            usuarios.setPassword(hashedPassword);
        }
        usuarios.setId(id);
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

    @GetMapping("/nombre/{nombre}")
    public List<Usuarios> getUserByNombre(@PathVariable String nombre) {
        return usuariosService.findByNombreContainingIgnoreCase(nombre);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        Optional<Usuarios> optionalUser = usuariosService.findByUsername(username);
        if (!optionalUser.isPresent()) {
            return ResponseEntity.status(401).body("Invalid username");
        }
        Usuarios user = optionalUser.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }
        return ResponseEntity.ok(user);
    }
}
