package com.cstv.cstv.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cstv.cstv.entities.Usuarios;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface UsuariosRepo extends JpaRepository<Usuarios, Long> {

    public List<Usuarios> findByUsernameContainingIgnoreCase(String nombre);
    public Optional<Usuarios> findByUsername(String username);
}
