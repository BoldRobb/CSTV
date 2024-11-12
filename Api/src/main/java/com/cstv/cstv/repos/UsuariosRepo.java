package com.cstv.cstv.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cstv.cstv.entities.Usuarios;


public interface UsuariosRepo extends JpaRepository<Usuarios, Long> {
}
