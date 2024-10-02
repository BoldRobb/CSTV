package com.cstv.cstv.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "equipos")
public class Equipos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    private Integer rankingActual;
    private Integer rankingMaximo;

    @Column(length = 100)
    private String twitter;



    @Column(length = 100)
    private String instagram;

    @Lob
    private byte[] foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getRankingActual() {
        return rankingActual;
    }

    public void setRankingActual(Integer rankingActual) {
        this.rankingActual = rankingActual;
    }

    public Integer getRankingMaximo() {
        return rankingMaximo;
    }

    public void setRankingMaximo(Integer rankingMaximo) {
        this.rankingMaximo = rankingMaximo;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}