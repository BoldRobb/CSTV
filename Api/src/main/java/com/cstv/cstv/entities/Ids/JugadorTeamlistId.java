package com.cstv.cstv.entities.Ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class JugadorTeamlistId implements Serializable {

    @Column(name = "ID_Jugador", nullable = false)
    private Long idJugador;

    @Column (name = "ID_Equipo", nullable = false)
    private Long idEquipo;

    // Constructor, getters, setters, equals y hashCode

    public JugadorTeamlistId() {
    }

    public JugadorTeamlistId(Long idJugador, Long idEquipo) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
    }

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadorTeamlistId that = (JugadorTeamlistId) o;
        return Objects.equals(idJugador, that.idJugador) && Objects.equals(idEquipo, that.idEquipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJugador, idEquipo);
    }
}