package com.cstv.cstv.service;

import com.cstv.cstv.entities.Respuestas;
import com.cstv.cstv.repos.RespuestaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepo respuestaRepo;

    public List<Respuestas> findAll() {
        return respuestaRepo.findAll();
    }

    public Optional<Respuestas> findById(Long id) {
        return respuestaRepo.findById(id);
    }

    public Respuestas save(Respuestas respuesta) {
        return respuestaRepo.save(respuesta);
    }

    public void deleteById(Long id) {
        respuestaRepo.deleteById(id);
    }

    public List<Respuestas> findAllByTopico_Id(Long id) {
        return respuestaRepo.findAllByTopico_Id(id);
    }

    public List<Respuestas> findAllByRespuestaPadre(Long id) {
        return respuestaRepo.findAllByRespuestaPadre(id);
    }
}
