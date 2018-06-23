package com.grupodot.model;
import java.io.Serializable;

//@XmlAccessorType(XmlAccessType.FIELD)
public class Capital implements Serializable {
    // Atributos propios del JavaBean del Capital
    private float montoDisponible;
    private float tasa;
    private Socio socio;
    
    // Constructor por Defecto
    public Capital() {
        this.montoDisponible = 0;
        this.tasa = 0;
        this.socio = null;
    }
    
    // Constructor Parametrizado
    public Capital(float montoDisponible, float tasa, Socio socio) {
        this.montoDisponible = montoDisponible;
        this.tasa = tasa;
        this.socio = socio;
    }
    
    // Getters y Setters
    public float getMontoDisponible() {
        return montoDisponible;
    }

    public void setMontoDisponible(float montoDisponible) {
        this.montoDisponible = montoDisponible;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}