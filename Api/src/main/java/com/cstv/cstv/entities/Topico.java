package com.cstv.cstv.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "topico")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Foro getForo() {
        return foro;
    }

    public void setForo(Foro foro) {
        this.foro = foro;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "ID_Foro", nullable = false)
    private Foro foro;

    @Column(name = "Titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "Descripcion", length = 255, nullable = false)
    private String descripcion;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name= "Latest")
    private Date latest;

    public Date getLatest() {
        return latest;
    }

    public void setLatest(Date latest) {
        this.latest = latest;
    }
}

