package com.cstv.cstv.domain;

public class PartidoDTO {
    private Long id;
    private Long equipo1;
    private Long equipo2;
    private Long idTorneo;
    private Long idGanador;
    private String formato;
    private int ronda;

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

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

}
