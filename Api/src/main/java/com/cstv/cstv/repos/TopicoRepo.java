package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Noticia;
import com.cstv.cstv.entities.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepo extends JpaRepository<Topico, Long> {

    public List<Topico> findAllByOrderByFechaDesc();
    public List<Topico> findAllByOrderByLatestDesc();
    public List<Topico> findAllByForo_Id(Long id);
}
