package com.cstv.cstv.service;

import com.cstv.cstv.entities.Foro;
import com.cstv.cstv.repos.ForoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForoService {

    @Autowired
    private ForoRepo foroRepo;

    public List<Foro> findAll() {
        return foroRepo.findAll();
    }

    public Optional<Foro> findById(Long id) {
        return foroRepo.findById(id);
    }

    public Foro save(Foro foro) {
        return foroRepo.save(foro);
    }

    public void deleteById(Long id) {
        foroRepo.deleteById(id);
    }
}

