package com.cstv.cstv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cstv.cstv.entities.Usuarios;
import com.cstv.cstv.repos.UsuariosRepo;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepo usuariosRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuarios> findAll() {
        return usuariosRepo.findAll();
    }

    public Optional<Usuarios> findById(Long id) {
        return usuariosRepo.findById(id);
    }

    public Usuarios save(Usuarios usuarios) {
        return usuariosRepo.save(usuarios);
    }

    public void deleteById(Long id) {
        usuariosRepo.deleteById(id);
    }

    public List<Usuarios> findByNombreContainingIgnoreCase(String nombre) {
        return usuariosRepo.findByUsernameContainingIgnoreCase(nombre);
    }

    public Optional<Usuarios> findByUsername(String username) {
        return usuariosRepo.findByUsername(username);
    }

    public boolean verifyLogin(String username, String password) {
        Optional<Usuarios> optionalUser = findByUsername(username);
        if (optionalUser.isPresent()) {
            Usuarios user = optionalUser.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}
