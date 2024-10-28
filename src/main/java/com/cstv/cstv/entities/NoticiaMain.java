package com.cstv.cstv.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "noticia_main")
public class NoticiaMain {
@Id
@Column(name = "ID_Noticia")
private Long idNoticia;

public Long getIdNoticia() {
    return idNoticia;
}

public void setIdNoticia(Long idNoticia) {
    this.idNoticia = idNoticia;
}
}