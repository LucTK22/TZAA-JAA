package com.example.tienda_perfumes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private int id;

    private String email;
    private String pass;
    private String nombre;
    private String apellidos;
    private String telefono;

    public Usuario() {
    }

    public Usuario(String email, String pass, String nombre,
                   String apellidos, String telefono) {
        this.email = email;
        this.pass = pass;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}