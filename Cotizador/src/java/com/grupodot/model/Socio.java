package com.grupodot.model;


public class Socio {
    // Atributos propios del JavaBean del Socio
    private String nombre;
    private String apellido;
    private long cedula;
    
    // Constructor por Defecto
    public Socio() {
        this.nombre = "";
        this.apellido = "";
        this.cedula = 0;
    }
    
    // Constructor Parametrizado
    public Socio(String nombre, String apellido, long cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }
}
