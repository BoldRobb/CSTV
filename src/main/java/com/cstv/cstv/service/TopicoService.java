package com.cstv.cstv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cstv.cstv.entities.Topico;
import com.cstv.cstv.repos.TopicoRepo;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepo topicoRepo;

    public List<Topico> findAll() {
        return topicoRepo.findAll();
    }

    public Optional<Topico> findById(Long id) {
        return topicoRepo.findById(id);
    }

    public Topico save(Topico topico) {
        return topicoRepo.save(topico);
    }

    public void deleteById(Long id) {
        topicoRepo.deleteById(id);
    }

    public List<Topico> findAllOrderByDesc(){
        return topicoRepo.findAllByOrderByFechaDesc();
    }
    public List<Topico> findAllByOrderByLatest(){
        return topicoRepo.findAllByOrderByLatestDesc();
    }
}
