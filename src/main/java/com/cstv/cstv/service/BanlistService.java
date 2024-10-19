package com.cstv.cstv.service;

import com.cstv.cstv.entities.Banlist;
import com.cstv.cstv.repos.BanlistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Banlist save(Banlist banlist) {
        return banlistRepo.save(banlist);
    }

    public void deleteByIdPartido(Long id) {
        banlistRepo.deleteByIdPartido(id);
    }
    public void deleteByIdPartidoAndMapa(Long id, String mapa) {
        banlistRepo.deleteByIdPartidoAndMapa(id, mapa);
    }
}
