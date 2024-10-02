package com.cstv.cstv.entities.Ids;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BanlistId implements Serializable {
    @Column(name = "ID_Equipo", nullable = false)
    private Long idPartido;
    @Column (name = "Mapa", nullable = false)
    private String mapa;

    // Constructor sin argumentos (requerido por JPA)
    public BanlistId() {
    }

    // Constructor con argumentos
    public BanlistId(Long idPartido, String mapa) {
        this.idPartido = idPartido;
        this.mapa = mapa;
    }

    // Getters y Setters
    public Long getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(Long idPartido) {
        this.idPartido = idPartido;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    // Métodos equals y hashCode (importantes para JPA)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BanlistId banlistId = (BanlistId) o;
        return Objects.equals(idPartido, banlistId.idPartido) && Objects.equals(mapa, banlistId.mapa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPartido, mapa);
    }
}
