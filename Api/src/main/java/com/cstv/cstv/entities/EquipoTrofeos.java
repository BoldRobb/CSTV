package com.cstv.cstv.entities;


import com.cstv.cstv.entities.Ids.EquipoJugadoresId;
import com.cstv.cstv.entities.Ids.EquipoTrofeosId;
import jakarta.persistence.*;

@Entity
@Table(name = "equipo_trofeos")
public class EquipoTrofeos {


    @EmbeddedId
    private EquipoTrofeosId id;

    @ManyToOne
    @JoinColumn(name = "ID_Equipo", nullable = false, insertable = false, updatable = false)
    private Equipos equipo;

    @ManyToOne
    @JoinColumn(name = "ID_Torneo", nullable = false, insertable = false, updatable = false)
    private Torneos torneos;

    public EquipoTrofeosId getId() {
        return id;
    }

    public void setId(EquipoTrofeosId id) {
        this.id = id;
    }

    public Equipos getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipos equipo) {
        this.equipo = equipo;
    }

    public Torneos getTorneos() {
        return torneos;
    }

    public void setTorneos(Torneos torneos) {
        this.torneos = torneos;
    }

}