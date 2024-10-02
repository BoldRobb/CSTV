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
}
