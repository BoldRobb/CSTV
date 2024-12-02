package com.cstv.cstv.entities;

import com.cstv.cstv.entities.Ids.TorneoEquiposId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "torneo_equipos")
public class TorneoEquipos {



    @EmbeddedId

    private TorneoEquiposId id;

    // Relación con la entidad Equipo
    @ManyToOne
    @JoinColumn(name = "ID_Equipo", insertable = false, updatable = false)
    private Equipos idEquipo;

    // Relación con la entidad Torneo
    @ManyToOne
    @JoinColumn(name = "ID_Torneo", insertable = false, updatable = false)
    private Torneos idTorneo;

    @Column(name = "Posicion")
    private Integer posicion;

    @Column(name = "Premio")
    private Integer premio;
    public TorneoEquiposId getId() {
        return id;
    }

    public void setId(TorneoEquiposId id) {
        this.id = id;
    }
    public Torneos getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Torneos torneo) {
        this.idTorneo = torneo;
    }

    public Equipos getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipos equipo) {
        this.idEquipo = equipo;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Integer getPremio() {
        return premio;
    }

    public void setPremio(Integer premio) {
        this.premio = premio;
    }

}
