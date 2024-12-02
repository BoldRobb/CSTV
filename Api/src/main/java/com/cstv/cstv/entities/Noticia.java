package com.cstv.cstv.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "noticia")
public class Noticia {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuarios usuario;

    @Column
    private String imagen;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String html;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name= "titulo", nullable= false)
    private String titulo;

    @ManyToMany
    @JoinTable(
            name = "noticia_equipos",
            joinColumns = @JoinColumn(name = "noticia_id"),
            inverseJoinColumns = @JoinColumn(name = "equipo_id")
    )
    @JsonIgnore
    private List<Equipos> equipos;

    @ManyToMany
    @JoinTable(
            name = "noticia_torneos",
            joinColumns = @JoinColumn(name = "noticia_id"),
            inverseJoinColumns = @JoinColumn(name = "torneo_id")
    )
    @JsonIgnore
    private List<Torneos> torneos;

    @ManyToMany
    @JoinTable(
            name = "noticia_jugadores",
            joinColumns = @JoinColumn(name = "noticia_id"),
            inverseJoinColumns = @JoinColumn(name = "jugador_id")
    )
    @JsonIgnore
    private List<Jugadores> jugadores;

    public List<Equipos> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipos> equipos) {
        this.equipos = equipos;
    }

    public List<Torneos> getTorneos() {
        return torneos;
    }

    public void setTorneos(List<Torneos> torneos) {
        this.torneos = torneos;
    }

    public List<Jugadores> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugadores> jugadores) {
        this.jugadores = jugadores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
