package com.cstv.cstv.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cstv.cstv.entities.Banlist;
import com.cstv.cstv.entities.Ids.BanlistId;

public interface BanlistRepo extends JpaRepository<Banlist, BanlistId> {
    List<Banlist> findByIdPartido(Long id);
    void deleteByIdPartido(Long id);
    void deleteById(BanlistId id);
}
