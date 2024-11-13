package com.cstv.cstv.domain;

import java.util.Date;

public class RankingHistorialDTO {

    private Long id;
    private Long equipo_id;
    private int ranking;
    private Date fechaInicio;
    private int puntos;
    private Date fechaFin;

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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fecha) {
        this.fechaInicio = fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFinal) {
        this.fechaFin = fechaFinal;
    }
}
