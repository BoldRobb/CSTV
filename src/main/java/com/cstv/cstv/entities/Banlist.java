package com.cstv.cstv.entities;

import com.cstv.cstv.entities.Ids.BanlistId;
import jakarta.persistence.*;

@Entity
@Table(name = "banlist")
public class Banlist {


    @EmbeddedId
    private BanlistId Id;
    @ManyToOne
    @JoinColumn(name = "ID_Partido", nullable = false, insertable = false, updatable = false)
    private Partido partido;

    @Column(name = "Mapa", length = 100,nullable = false , insertable = false, updatable = false)
    private String mapa;

    @Column(name = "Estatus", length = 100)
    private String estatus;
    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }


}

