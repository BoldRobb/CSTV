package com.cstv.cstv.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mapa")
public class Mapa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Partido", nullable = false)
    private Partido partido;

    @Column(name = "Mapa", length = 100)
    private String mapa;

    @Column(name = "Equipo1T")
    private Integer equipo1T;

    @Column(name = "Equipo1CT")
    private Integer equipo1CT;

    @Column(name = "Equipo2T")
    private Integer equipo2T;
    @Column(name = "Equipo2CT")
    private Integer equipo2CT;

    public Integer getEquipo2CT() {
        return equipo2CT;
    }

    public void setEquipo2CT(Integer equipo2CT) {
        this.equipo2CT = equipo2CT;
    }

    public Integer getEquipo2T() {
        return equipo2T;
    }

    public void setEquipo2T(Integer equipo2T) {
        this.equipo2T = equipo2T;
    }

    public Integer getEquipo1CT() {
        return equipo1CT;
    }

    public void setEquipo1CT(Integer equipo1CT) {
        this.equipo1CT = equipo1CT;
    }

    public Integer getEquipo1T() {
        return equipo1T;
    }

    public void setEquipo1T(Integer equipo1T) {
        this.equipo1T = equipo1T;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
