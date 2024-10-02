package com.cstv.cstv.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre_Real", length = 100)
    private String nombreReal;

    @Column(name = "Mote", length = 100)
    private String mote;

    @Column(name = "Estatus", length = 100)
    private String estatus;

    @Lob
    private byte[] foto;

    @ManyToOne
    @JoinColumn(name = "ID_EquipoActual")
    private Equipos equipoActual;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Equipos getEquipoActual() {
        return equipoActual;
    }

    public void setEquipoActual(Equipos equipoActual) {
        this.equipoActual = equipoActual;
    }

}
