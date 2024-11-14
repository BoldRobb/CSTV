package com.cstv.cstv.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table (name="\"usuarios\"")
public class Usuarios {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length = 100, unique = true)
    private String username;

    @Column(nullable=false, length = 100)
    private String password;

    @Column(nullable=false, length = 100, unique = true)
    private String correo;

    @Column(nullable=true, length = 20)
    private String pais;

    @Column(nullable=false, length = 50)
    private String rol;

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void setPassword(String password) {this.password = password;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getCorreo() {
        return correo;
    }
    public long getId() {
        return id;
    }
    public String getPais() {
        return pais;
    }
    public String getPassword() {
        return password;
    }
    public String getRol() {
        return rol;
    }
    public String getUsername() {
        return username;
    }

    public void setId(Long ID) {
        this.id = ID;
    }

}
