package com.cstv.cstv.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partido")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Equipo1", referencedColumnName = "id")
    private Equipos equipo1;

    @ManyToOne
    @JoinColumn(name = "Equipo2", referencedColumnName = "id")
    private Equipos equipo2;

    @ManyToOne
    @JoinColumn(name = "ID_Torneo", referencedColumnName = "id")
    private Torneos torneo;



    @ManyToOne
    @JoinColumn(name = "ID_Ganador", referencedColumnName = "id")
    private Equipos ganador;

    @Column(name = "Formato", length = 100)
    private String formato;

    @Column(name = "Ronda")
    private Integer ronda;
    public Integer getRonda() {
        return ronda;
    }

    public void setRonda(Integer ronda) {
        this.ronda = ronda;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Equipos getGanador() {
        return ganador;
    }

    public void setGanador(Equipos ganador) {
        this.ganador = ganador;
    }

    public Torneos getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneos torneo) {
        this.torneo = torneo;
    }

    public Equipos getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipos equipo2) {
        this.equipo2 = equipo2;
    }

    public Equipos getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipos equipo1) {
        this.equipo1 = equipo1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
