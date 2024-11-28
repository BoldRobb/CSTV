package com.cstv.cstv.entities.Ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EquipoTrofeosId implements Serializable {
    @Column(name = "ID_Equipo", nullable = false)
    private Long idEquipo;
    @Column (name = "ID_Torneo", nullable = false)
    private Long idTorneo;

    // Constructor, getters y setters

    public EquipoTrofeosId(Long idE, Long idJ) {
        this.idEquipo= idE;
        this.idTorneo= idJ;
    }
    public EquipoTrofeosId() {
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Long getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Long idTorneo) {
        this.idTorneo = idTorneo;
    }


}
