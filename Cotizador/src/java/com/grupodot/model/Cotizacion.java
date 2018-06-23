package com.grupodot.model;
import java.io.Serializable;

public class Cotizacion implements Serializable {
    // Atributos propios del JavaBean de la Cotizacion
    private String nombreSocio;
    private String tasaEfectivaAnual;
    private String tasaEfectivaMensual;
    private String cuotaMensual;
    private String valorCredito;
    private String plazo;
    
    // Constructor por Defecto
    public Cotizacion(){
        this.nombreSocio = "";
        this.tasaEfectivaAnual = "";
        this.tasaEfectivaMensual = "";
        this.cuotaMensual = "";
        this.valorCredito = "";
        this.plazo = "";
    }
    // Constructor Parametrizado
    public Cotizacion(String nombreSocio, String tasaEfectivaAnual, String tasaEfectivaMensual, String cuotaMensual, String valorCredito, String plazo) {
        this.nombreSocio = nombreSocio;
        this.tasaEfectivaAnual = tasaEfectivaAnual;
        this.tasaEfectivaMensual = tasaEfectivaMensual;
        this.cuotaMensual = cuotaMensual;
        this.valorCredito = valorCredito;
        this.plazo = plazo;
    }
    
    // Getters y Setters
    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public String getTasaEfectivaAnual() {
        return tasaEfectivaAnual;
    }

    public void setTasaEfectivaAnual(String tasaEfectivaAnual) {
        this.tasaEfectivaAnual = tasaEfectivaAnual;
    }

    public String getTasaEfectivaMensual() {
        return tasaEfectivaMensual;
    }

    public void setTasaEfectivaMensual(String tasaEfectivaMensual) {
        this.tasaEfectivaMensual = tasaEfectivaMensual;
    }

    public String getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(String cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public String getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(String valorCredito) {
        this.valorCredito = valorCredito;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }    
}
