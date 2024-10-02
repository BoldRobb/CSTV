package com.cstv.cstv.entities;

import com.cstv.cstv.entities.Ids.JugadorTeamlistId;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "jugador_teamlist")
public class JugadorTeamlist {

    @EmbeddedId
    private JugadorTeamlistId Id;

    @ManyToOne
    @JoinColumn(name = "ID_Jugador", nullable = false, insertable = false, updatable = false)
    private Jugadores jugador;

    @ManyToOne
    @JoinColumn(name = "ID_Equipo", nullable = false, insertable = false, updatable = false)
    private Equipos equipo;


    @Column(name = "FechaInicio")
    private Date fechaInicio;

    @Column(name = "FechaFinal")
    private Date fechaFinal;
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Jugadores getJugador() {
        return jugador;
    }

    public void setJugador(Jugadores jugador) {
        this.jugador = jugador;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

}
