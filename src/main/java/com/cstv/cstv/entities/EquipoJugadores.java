package com.cstv.cstv.entities;

import com.cstv.cstv.entities.Ids.EquipoJugadoresId;
import jakarta.persistence.*;

@Entity
@Table(name = "equipo_jugadores")
public class EquipoJugadores {

    @EmbeddedId
    private EquipoJugadoresId id;

    @ManyToOne
    @JoinColumn(name = "ID_Equipo", nullable = false, insertable = false, updatable = false)
    private Equipos equipo;

    @ManyToOne
    @JoinColumn(name = "ID_Jugador", nullable = false, insertable = false, updatable = false)
    private Jugadores jugador;

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public Jugadores getJugador() {
        return jugador;
    }

    public void setJugador(Jugadores jugador) {
        this.jugador = jugador;
    }

}
