package com.cstv.cstv.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "torneo_main")
public class TorneoMain {
    @Id
    @Column(name = "ID_Torneo")
    private long id;


    public long getId() {
        return id;
    }

    public void setId(long id_torneo) {
        this.id = id_torneo;
    }
}
