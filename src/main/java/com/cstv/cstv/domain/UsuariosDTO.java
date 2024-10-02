package com.cstv.cstv.domain;


import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


public class UsuariosDTO {


    private long ID;

    @NotNull
    private String Username;
    @NotNull
    private String Password;
    @NotNull
    private String Correo;

    private String Pais;
    @NotNull
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
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getID() {
        return ID;
    }
}
