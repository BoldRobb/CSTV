package com.cstv.cstv.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cstv.cstv.entities.Usuarios;

import java.util.List;


public interface UsuariosRepo extends JpaRepository<Usuarios, Long> {

    public List<Usuarios> findByUsernameContainingIgnoreCase(String nombre);
}
