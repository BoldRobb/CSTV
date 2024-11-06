package com.cstv.cstv.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class RankingHistorial {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipos equipo;

    @Column(name = "ranking")
    private int ranking;


    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "puntos")
    private int puntos;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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



}
