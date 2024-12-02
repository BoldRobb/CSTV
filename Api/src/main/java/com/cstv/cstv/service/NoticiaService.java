package com.cstv.cstv.service;

import com.cstv.cstv.entities.Noticia;
import com.cstv.cstv.repos.NoticiaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepo noticiaRepo;

    public List<Noticia> findAll() {
        return noticiaRepo.findAll();
    }

    public Optional<Noticia> findById(Long id) {
        return noticiaRepo.findById(id);
    }

    public Noticia save(Noticia noticia) {
        return noticiaRepo.save(noticia);
    }

    public void deleteById(Long id) {
        noticiaRepo.deleteById(id);
    }
    public List<Noticia> findAllByOrderByFechaDesc() {
        return noticiaRepo.findAllByOrderByFechaDesc();
    }

    public List<Noticia> findAllByUsuario_Id(Long id) {
        return noticiaRepo.findAllByUsuario_Id(id);
    }

    public List<Noticia> findAllByEquipos_Id(Long id) {
        return noticiaRepo.findAllByEquipos_Id(id);
    }

    public List<Noticia> findAllByTorneos_Id(Long id) {
        return noticiaRepo.findAllByTorneos_Id(id);
    }

    public List<Noticia> findAllByJugadores_Id(Long id) {
        return noticiaRepo.findAllByJugadores_Id(id);
    }

}
