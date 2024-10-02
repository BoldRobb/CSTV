package com.cstv.cstv.entities.Ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable
public class EquipoJugadoresId implements Serializable {
    @Column (name = "ID_Equipo", nullable = false)
    private Long idEquipo;
    @Column (name = "ID_Jugador", nullable = false)
    private Long idJugador;

    // Constructor, getters y setters

    public EquipoJugadoresId() {
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    // Equals y hashCode para comparar correctamente las claves compuestas

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquipoJugadoresId)) return false;
        EquipoJugadoresId that = (EquipoJugadoresId) o;
        return idEquipo.equals(that.idEquipo) && idJugador.equals(that.idJugador);
    }

    @Override
    public int hashCode() {
        return idEquipo.hashCode() + idJugador.hashCode();
    }
}
