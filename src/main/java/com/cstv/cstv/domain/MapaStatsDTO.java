package com.cstv.cstv.domain;

public class MapaStatsDTO {
    private Long id;
    private Long idMapa;
    private Long idEquipo;
    private Long idJugador;
    private int asesinatos;
    private int muertes;
    private double KD;
    private double ADR;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(Long idMapa) {
        this.idMapa = idMapa;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public int getAsesinatos() {
        return asesinatos;
    }

    public void setAsesinatos(int asesinatos) {
        this.asesinatos = asesinatos;
    }

    public int getMuertes() {
        return muertes;
    }

    public void setMuertes(int muertes) {
        this.muertes = muertes;
    }

    public double getKD() {
        return KD;
    }

    public void setKD(double KD) {
        this.KD = KD;
    }

    public double getADR() {
        return ADR;
    }

    public void setADR(double ADR) {
        this.ADR = ADR;
    }
}
