package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Banlist;
import com.cstv.cstv.entities.Ids.BanlistId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BanlistRepo extends JpaRepository<Banlist, BanlistId> {
    List<Banlist> findByIdPartido(Long id);
    void deleteByIdPartido(Long id);
    void deleteByIdPartidoAndMapa(Long id, String mapa);
}
