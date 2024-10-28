package com.cstv.cstv.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cstv.cstv.entities.Noticia;
import com.cstv.cstv.entities.NoticiaMain;

public interface NoticiaMainRepo extends JpaRepository<NoticiaMain, Long> {
}
