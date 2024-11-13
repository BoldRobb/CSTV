package com.cstv.cstv.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class RankingHistorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipos equipo;

    @Column(name = "ranking")
    private int ranking;


    @Column(name = "fechaInicio", nullable = false)
    private Date fechaInicio;


    @Column(name = "fechaFin", nullable = false)
    private Date fechaFin;


    @Column(name = "puntos")
    private int puntos;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fecha) {
        this.fechaInicio = fecha;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }



}
