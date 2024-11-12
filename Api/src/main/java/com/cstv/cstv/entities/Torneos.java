package com.cstv.cstv.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "torneos")
public class Torneos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(name = "fecha_inicial")
    private Date fechaInicial;

    @Column(name = "fecha_final")
    private Date fechaFinal;
    @Column
    private String logo;

    @Column(name = "tipo_bracket", nullable = false, length = 100)
    private String tipoBracket;

    @Column
    private int prizepool;
    @Column
    private int equipos_cant;
    @Column
    private String localizacion;
    @Column
    private String tipo;


    public String getTipoBracket() {
        return tipoBracket;
    }

    public void setTipoBracket(String tipoBracket) {
        this.tipoBracket = tipoBracket;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public int getPrizepool() {
        return prizepool;
    }

    public void setPrizepool(int prizepool) {
        this.prizepool = prizepool;
    }

    public int getEquipos_cant() {
        return equipos_cant;
    }

    public void setEquipos_cant(int equipos_cant) {
        this.equipos_cant = equipos_cant;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
