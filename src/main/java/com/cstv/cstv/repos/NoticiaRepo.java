package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepo extends JpaRepository<Noticia, Long> {
}
