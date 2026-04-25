package com.uca.ncapas.laboratorio01.model;

public class Bow {

    private String nombre;
    private String virusBase;
    private int nivelPeligro;
    private String puntoDebil;
    private String estadoActual;
    private String ultimaUbicacion;
    private String aulaOrigen;

    public Bow() {
    }

    public Bow(String nombre, String virusBase, int nivelPeligro, String puntoDebil,
               String estadoActual, String ultimaUbicacion, String aulaOrigen) {
        this.nombre = nombre;
        this.virusBase = virusBase;
        this.nivelPeligro = nivelPeligro;
        this.puntoDebil = puntoDebil;
        this.estadoActual = estadoActual;
        this.ultimaUbicacion = ultimaUbicacion;
        this.aulaOrigen = aulaOrigen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getVirusBase() {
        return virusBase;
    }

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public String getPuntoDebil() {
        return puntoDebil;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public String getUltimaUbicacion() {
        return ultimaUbicacion;
    }

    public String getAulaOrigen() {
        return aulaOrigen;
    }
}
