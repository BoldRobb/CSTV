package com.cstv.cstv.entities;

import com.cstv.cstv.entities.Ids.JugadorTrofeosId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugador_trofeos")
public class JugadorTrofeos {

    @EmbeddedId
    private JugadorTrofeosId id;
    @ManyToOne
    @JoinColumn(name = "ID_Jugador", nullable = false, insertable = false, updatable = false)
    private Jugadores idJugador;

    @ManyToOne
    @JoinColumn(name = "ID_Torneo", nullable = false, insertable = false, updatable = false)
    private Torneos idTorneo;

    public Jugadores getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugadores jugador) {
        this.idJugador = jugador;
    }

    public Torneos getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Torneos torneo) {
        this.idTorneo = torneo;
    }
}
