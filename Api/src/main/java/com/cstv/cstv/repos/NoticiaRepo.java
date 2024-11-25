package com.cstv.cstv.repos;

import com.cstv.cstv.entities.Noticia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepo extends JpaRepository<Noticia, Long> {
    public List<Noticia> findAllByOrderByFechaDesc();
    public List<Noticia> findAllByUsuario_Id(Long id);
}
