package com.cstv.cstv.domain;

import java.util.Date;

public class PartidoDTO {
    private Long id;
    private Long equipo1;
    private Long equipo2;
    private Long idTorneo;
    private Long idGanador;
    private String formato;
    private String marcador;
    private Date fecha;
    private String tipo;
    private Long idronda;
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Long equipo1) {
        this.equipo1 = equipo1;
    }

    public Long getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Long equipo2) {
        this.equipo2 = equipo2;
    }

    public Long getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Long idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Long getIdGanador() {
        return idGanador;
    }

    public void setIdGanador(Long idGanador) {
        this.idGanador = idGanador;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Long getIdronda() {
        return idronda;
    }

    public void setIdronda(Long idronda) {
        this.idronda = idronda;
    }
}
