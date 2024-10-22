package com.cstv.cstv.entities;

import com.cstv.cstv.entities.Ids.BanlistId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "banlist")
public class Banlist {


    @EmbeddedId
    private BanlistId id;

    

    @Column(name = "ID_Partido", nullable = false, insertable = false, updatable = false)
    private long idPartido;

    @Column(name = "Mapa", length = 100, nullable = false, insertable = false, updatable = false)
    private String mapa;

    @Column(name = "Estatus", length = 100)
    private String estatus;

    @Column(name="ID_Equipo", nullable = false, insertable = false, updatable = false)
    private long idEquipo;


    public BanlistId getId() {
        return id;
    }

    public void setId(BanlistId id) {
        this.id = id;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public Long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(long partido) {
        this.idPartido = partido;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(long idEquipo) {
        this.idEquipo = idEquipo;
    }


}

