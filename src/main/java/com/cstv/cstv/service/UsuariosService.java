package com.cstv.cstv.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cstv.cstv.domain.UsuariosDTO;
import com.cstv.cstv.entities.Usuarios;
import com.cstv.cstv.repos.UsuariosRepo;
import com.cstv.cstv.util.NotFoundException;

@Service
public class UsuariosService {
    private final UsuariosRepo usuariosRepository;

    public UsuariosService(final UsuariosRepo usuariosRepository){
        this.usuariosRepository = usuariosRepository;
    }

    public List<UsuariosDTO> findAll(){
        final List<Usuarios> usuarios = usuariosRepository.findAll(Sort.by("id"));
        return usuarios.stream().map(user -> mapToDTO(user, new UsuariosDTO()))
                .toList();
    }
    public UsuariosDTO get(final Long id){
        return usuariosRepository.findById(id).map(user -> mapToDTO(user, new UsuariosDTO()))
                .orElseThrow(NotFoundException::new);
    }
    public Long create(final UsuariosDTO userDTO) {
        final Usuarios user = new Usuarios();
        mapToEntity(userDTO, user);
        return usuariosRepository.save(user).getId();
    }

    public void update(final Long id, final UsuariosDTO userDTO) {
        final Usuarios user = usuariosRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(userDTO, user);
        usuariosRepository.save(user);
    }

    public void delete(final Long id) {
        usuariosRepository.deleteById(id);
    }

    private UsuariosDTO mapToDTO(final Usuarios user, final UsuariosDTO userDTO) {
        userDTO.setID(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setCorreo(user.getCorreo());
        userDTO.setPais(user.getPais());
        userDTO.setRol(user.getRol());
        return userDTO;
    }

    private Usuarios mapToEntity(final UsuariosDTO userDTO, final Usuarios user) {
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setCorreo(userDTO.getCorreo());
        user.setPais(userDTO.getPais());
        user.setRol(userDTO.getRol());
        return user;
    }

}
