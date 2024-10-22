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
    private JugadorTrofeosId Id;
    @ManyToOne
    @JoinColumn(name = "ID_Jugador", nullable = false, insertable = false, updatable = false)
    private Long idJugador;

    @ManyToOne
    @JoinColumn(name = "ID_Torneo", nullable = false, insertable = false, updatable = false)
    private Long idTorneo;

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long jugador) {
        this.idJugador = jugador;
    }

    public Long getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Long torneo) {
        this.idTorneo = torneo;
    }
}
