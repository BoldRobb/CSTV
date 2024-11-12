package com.cstv.cstv.service;

import com.cstv.cstv.entities.NoticiaMain;
import com.cstv.cstv.entities.TorneoMain;
import com.cstv.cstv.repos.TorneoMainRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TorneoMainService {
    @Autowired
    private TorneoMainRepo torneoMainRepo;

    public void deleteAll() {
        torneoMainRepo.deleteAll();
    }
    public TorneoMain save(TorneoMain torneoMain) {
        return torneoMainRepo.save(torneoMain);
    }
    public TorneoMain find(){
        return torneoMainRepo.findAll().get(0);
    }
}
