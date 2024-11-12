package com.cstv.cstv.entities.Ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class JugadorTrofeosId implements Serializable {

    @Column(name = "ID_Jugador", nullable = false)
    private Long idJugador;

    @Column(name = "ID_Torneo", nullable = false)
    private Long idTorneo;

    // Constructor, getters, setters, equals y hashCode

    public JugadorTrofeosId() {
    }

    public JugadorTrofeosId(Long idJugador, Long idTorneo) {
        this.idJugador = idJugador;
        this.idTorneo = idTorneo;
    }

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public Long getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Long idTorneo) {
        this.idTorneo = idTorneo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadorTrofeosId that = (JugadorTrofeosId) o;
        return Objects.equals(idJugador, that.idJugador) && Objects.equals(idTorneo, that.idTorneo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJugador, idTorneo);
    }
}