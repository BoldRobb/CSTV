package com.cstv.cstv.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "respuestas")
public class Respuestas {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "ID_Topico")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "ID_Respuesta")
    private Respuestas respuestaPadre;

    @Column(nullable = false, length = 255)
    private String respuesta;

    @Column(name = "Fecha")
    private Date fecha;

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

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public Respuestas getRespuestaPadre() {
        return respuestaPadre;
    }

    public void setRespuestaPadre(Respuestas respuestaPadre) {
        this.respuestaPadre = respuestaPadre;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
