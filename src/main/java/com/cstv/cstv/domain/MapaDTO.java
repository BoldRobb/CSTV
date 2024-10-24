package com.cstv.cstv.domain;

public class MapaDTO {
    private Long id;
    private Long idPartido;
    private String mapa;
    private int equipo1T;
    private int equipo1CT;
    private int equipo2T;
    private int equipo2CT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Long idPartido) {
        this.idPartido = idPartido;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public int getEquipo1T() {
        return equipo1T;
    }

    public void setEquipo1T(int equipo1T) {
        this.equipo1T = equipo1T;
    }

    public int getEquipo1CT() {
        return equipo1CT;
    }

    public void setEquipo1CT(int equipo1CT) {
        this.equipo1CT = equipo1CT;
    }

    public int getEquipo2T() {
        return equipo2T;
    }

    public void setEquipo2T(int equipo2T) {
        this.equipo2T = equipo2T;
    }

    public int getEquipo2CT() {
        return equipo2CT;
    }

    public void setEquipo2CT(int equipo2CT) {
        this.equipo2CT = equipo2CT;
    }
    

}
