package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Banlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanlistRepo extends JpaRepository<Banlist, Long> {
}
