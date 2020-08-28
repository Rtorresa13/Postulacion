/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

/**
 *
 * @author rody_
 */
public class ViajesBean {
    private int idViaje;
    private String disponibilidad;
    private String LugarSalida;
    private String LugarDestino;
    private int idBus;
    private int numVendidos;
    private String matricula;
    private Double precio;
    private String fecha;
    private int numAsientos;

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getLugarSalida() {
        return LugarSalida;
    }

    public void setLugarSalida(String LugarSalida) {
        this.LugarSalida = LugarSalida;
    }

    public String getLugarDestino() {
        return LugarDestino;
    }

    public void setLugarDestino(String LugarDestino) {
        this.LugarDestino = LugarDestino;
    }


    public int getNumVendidos() {
        return numVendidos;
    }

    public void setNumVendidos(int numVendidos) {
        this.numVendidos = numVendidos;
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }
    
}
