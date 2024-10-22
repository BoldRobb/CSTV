package com.cstv.cstv.entities;

import java.util.Date;

import com.cstv.cstv.entities.Ids.JugadorTeamlistId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugador_teamlist")
public class JugadorTeamlist {

    @EmbeddedId
    private JugadorTeamlistId Id;

    @ManyToOne
    @JoinColumn(name = "ID_Jugador", nullable = false, insertable = false, updatable = false)
    private Long idJugador;

    @ManyToOne
    @JoinColumn(name = "ID_Equipo", nullable = false, insertable = false, updatable = false)
    private long idEquipo;


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

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long jugador) {
        this.idJugador = jugador;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long equipo) {
        this.idEquipo = equipo;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

}
