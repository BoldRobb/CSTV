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
    private Long ID;

    @Column(nullable=false, length = 100, unique = true)
    private String Username;

    @Column(nullable=false, length = 100)
    private String Password;

    @Column(nullable=false, length = 100, unique = true)
    private String Correo;

    @Column(nullable=true, length = 20)
    private String Pais;

    @Column(nullable=false, length = 50)
    private String Rol;

    public void setCorreo(String correo) {
        Correo = correo;
    }
    public void setPais(String pais) {
        Pais = pais;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public void setRol(String rol) {
        Rol = rol;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getCorreo() {
        return Correo;
    }
    public long getId() {
        return ID;
    }
    public String getPais() {
        return Pais;
    }
    public String getPassword() {
        return Password;
    }
    public String getRol() {
        return Rol;
    }
    public String getUsername() {
        return Username;
    }
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

}
