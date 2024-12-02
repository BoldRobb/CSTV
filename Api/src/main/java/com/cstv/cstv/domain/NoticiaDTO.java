package com.cstv.cstv.domain;

import java.sql.Date;
import java.util.List;

public class NoticiaDTO {
    private Long id;
    private Long usuarioId;
    private String imagen;
    private String html;
    private Date fecha;
    private String titulo;
    private List<Long> equiposIds;
    private List<Long> torneosIds;
    private List<Long> jugadoresIds;
    // Getters y Setters

    public List<Long> getEquiposIds() {
        return equiposIds;
    }

    public void setEquiposIds(List<Long> equiposIds) {
        this.equiposIds = equiposIds;
    }

    public List<Long> getTorneosIds() {
        return torneosIds;
    }

    public void setTorneosIds(List<Long> torneosIds) {
        this.torneosIds = torneosIds;
    }

    public List<Long> getJugadoresIds() {
        return jugadoresIds;
    }

    public void setJugadoresIds(List<Long> jugadoresIds) {
        this.jugadoresIds = jugadoresIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
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
