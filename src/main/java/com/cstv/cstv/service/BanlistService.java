package com.cstv.cstv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cstv.cstv.entities.Banlist;
import com.cstv.cstv.entities.Ids.BanlistId;
import com.cstv.cstv.repos.BanlistRepo;
@Service
public class BanlistService {

    @Autowired
    private BanlistRepo banlistRepo;

    public List<Banlist> findAll() {
        return banlistRepo.findAll();
    }
    public List<Banlist> findByIdPartido(Long id) {
        return banlistRepo.findByIdPartido(id);
    }
    public Optional<Banlist> findById(BanlistId id){
        return banlistRepo.findById(id);
    }

    public Banlist save(Banlist banlist) {
        return banlistRepo.save(banlist);
    }

    public void deleteByIdPartido(Long id) {
        banlistRepo.deleteByIdPartido(id);
    }
    public void deleteById(BanlistId id) {
        banlistRepo.deleteById(id);
    }
}
