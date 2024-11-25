package com.cstv.cstv.rest;

import com.cstv.cstv.service.NoticiaMainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cstv.cstv.domain.NoticiaMainDTO;
import com.cstv.cstv.entities.Noticia;
import com.cstv.cstv.entities.NoticiaMain;
import com.cstv.cstv.repos.NoticiaMainRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api/noticiaMain")
public class NoticiaMainRestController {
    @Autowired
    NoticiaMainService noticiaMainRepo;
    @GetMapping
    public NoticiaMain geNoticiaMain() {
        return noticiaMainRepo.find();
    }

    @PostMapping("/{id}")
    public NoticiaMain saveNoticiaMain(@PathVariable Long id) {
        noticiaMainRepo.deleteAll();
        NoticiaMain entity = new NoticiaMain();
        entity.setIdNoticia(id);
        return noticiaMainRepo.save(entity);
    }
    
    
}
