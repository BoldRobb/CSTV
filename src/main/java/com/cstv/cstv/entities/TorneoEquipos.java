package com.cstv.cstv.entities;

import com.cstv.cstv.entities.Ids.TorneoEquiposId;
import jakarta.persistence.*;

@Entity
@Table(name = "torneo_equipos")
public class TorneoEquipos {

    @EmbeddedId
    private TorneoEquiposId Id;

    // Relación con la entidad Equipo
    @ManyToOne
    @JoinColumn(name = "ID_Equipo", insertable = false, updatable = false)
    private Equipos equipo;

    // Relación con la entidad Torneo
    @ManyToOne
    @JoinColumn(name = "ID_Torneo", insertable = false, updatable = false)
    private Torneos torneo;

    @Column(name = "Posicion")
    private Integer posicion;

    @Column(name = "Premio")
    private Integer premio;

    public Torneos getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneos torneo) {
        this.torneo = torneo;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
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
