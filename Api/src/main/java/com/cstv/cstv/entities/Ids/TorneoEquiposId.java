package com.cstv.cstv.entities.Ids;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TorneoEquiposId implements Serializable {

    @Column(name = "ID_Torneo", nullable = false)
    private Long idTorneo;
    @Column (name = "ID_Equipo", nullable = false)
    private Long idEquipo;

    // Constructor vacío (requerido por JPA)
    public TorneoEquiposId() {
    }

    // Constructor con argumentos
    public TorneoEquiposId(Long idTorneo, Long idEquipo) {
        this.idTorneo = idTorneo;
        this.idEquipo = idEquipo;
    }

    // Getters y Setters
    public Long getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Long idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    // Métodos equals y hashCode (necesarios para JPA)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TorneoEquiposId that = (TorneoEquiposId) o;
        return Objects.equals(idTorneo, that.idTorneo) && Objects.equals(idEquipo, that.idEquipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTorneo, idEquipo);
    }
}
