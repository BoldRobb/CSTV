package com.cstv.cstv.domain;

public class JugadoresDTO {
    private String nombreReal;
    private String mote;
    private String estatus;
    private String foto;
    private Long idEquipoActual;


    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getIdEquipoActual() {
        return idEquipoActual;
    }

    public void setIdEquipoActual(Long idEquipoActual) {
        this.idEquipoActual = idEquipoActual;
    }
}
