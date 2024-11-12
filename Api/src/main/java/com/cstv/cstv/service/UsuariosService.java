package com.cstv.cstv.service;

import java.util.List;
import java.util.Optional;

import com.cstv.cstv.entities.Jugadores;
import com.cstv.cstv.repos.JugadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cstv.cstv.domain.UsuariosDTO;
import com.cstv.cstv.entities.Usuarios;
import com.cstv.cstv.repos.UsuariosRepo;
import com.cstv.cstv.util.NotFoundException;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepo usuariosRepo;

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

}
