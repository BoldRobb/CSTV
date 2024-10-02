package com.cstv.cstv.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mapa_stats")
public class MapaStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Mapa", nullable = false)
    private Mapa mapa;

    @ManyToOne
    @JoinColumn(name = "ID_Equipo", nullable = false)
    private Equipos equipo;

    @ManyToOne
    @JoinColumn(name = "ID_Jugador", nullable = false)
    private Jugadores jugador;

    @Column(name = "Asesinatos")
    private Integer asesinatos;

    @Column(name = "Muertes")
    private Integer muertes;

    @Column(name = "KD")
    private Double kd;

    @Column(name = "ADR")
    private Double adr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAdr() {
        return adr;
    }

    public void setAdr(Double adr) {
        this.adr = adr;
    }

    public Double getKd() {
        return kd;
    }

    public void setKd(Double kd) {
        this.kd = kd;
    }

    public Integer getMuertes() {
        return muertes;
    }

    public void setMuertes(Integer muertes) {
        this.muertes = muertes;
    }

    public Integer getAsesinatos() {
        return asesinatos;
    }

    public void setAsesinatos(Integer asesinatos) {
        this.asesinatos = asesinatos;
    }

    public Jugadores getJugador() {
        return jugador;
    }

    public void setJugador(Jugadores jugador) {
        this.jugador = jugador;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }
}
