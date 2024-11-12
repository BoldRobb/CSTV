package com.cstv.cstv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cstv.cstv.entities.NoticiaMain;
import com.cstv.cstv.repos.NoticiaMainRepo;

@Service
public class NoticiaMainService {

    @Autowired
    private NoticiaMainRepo noticiaMainRepo;

    public void deleteAll() {       
        noticiaMainRepo.deleteAll();
    }
    public NoticiaMain save(NoticiaMain noticiaMain) {
        return noticiaMainRepo.save(noticiaMain);
    }
    public NoticiaMain find(){
        return noticiaMainRepo.findAll().get(0);
    }

}
