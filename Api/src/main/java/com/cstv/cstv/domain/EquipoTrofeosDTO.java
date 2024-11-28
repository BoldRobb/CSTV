package com.cstv.cstv.domain;

public class EquipoTrofeosDTO {
    private Long idEquipo;
    private Long idTorneo;


    public EquipoTrofeosDTO(Long idEquipo, Long idTorneo) {
        this.idEquipo = idEquipo;
        this.idTorneo = idTorneo;

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
