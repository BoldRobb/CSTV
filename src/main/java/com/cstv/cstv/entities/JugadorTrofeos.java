package com.cstv.cstv.entities;

import com.cstv.cstv.entities.Ids.JugadorTeamlistId;
import com.cstv.cstv.entities.Ids.JugadorTrofeosId;
import jakarta.persistence.*;

@Entity
@Table(name = "jugador_trofeos")
public class JugadorTrofeos {

    @EmbeddedId
    private JugadorTrofeosId Id;
    @ManyToOne
    @JoinColumn(name = "ID_Jugador", nullable = false, insertable = false, updatable = false)
    private Jugadores jugador;

    @ManyToOne
    @JoinColumn(name = "ID_Torneo", nullable = false, insertable = false, updatable = false)
    private Torneos torneo;

    public Jugadores getJugador() {
        return jugador;
    }

    public void setJugador(Jugadores jugador) {
        this.jugador = jugador;
    }

    public Torneos getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneos torneo) {
        this.torneo = torneo;
    }
}
