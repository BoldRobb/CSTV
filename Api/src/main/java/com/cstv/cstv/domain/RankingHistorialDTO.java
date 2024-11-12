package com.cstv.cstv.domain;

import java.util.Date;

public class RankingHistorialDTO {

    private Long id;
    private Long equipo_id;
    private int ranking;
    private Date fecha;
    private int puntos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquipo_id() {
        return equipo_id;
    }

    public void setEquipo_id(Long equipo_id) {
        this.equipo_id = equipo_id;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
