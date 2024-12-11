package com.cstv.cstv.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ronda")
public class Ronda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Torneo", nullable = false)
    private Torneos torneo;

    @Column(name = "Nombre", length = 100)
    private String nombre;

    @Column(name = "Orden")
    private int orden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Torneos getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneos torneo) {
        this.torneo = torneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }


}
