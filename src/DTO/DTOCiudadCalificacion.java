/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author mateo
 */
public class DTOCiudadCalificacion {

    private int idReserva;
    private Date fechareservacion;
    private int idhabitacion;
    private String categoria;
    private String tipo;
    private String Ciudad;
    private String calificacion;

    public DTOCiudadCalificacion() {

    }

    public DTOCiudadCalificacion(int idReserva, Date fechareservacion, int idhabitacion, String categoria, String tipo, String Ciudad, String calificacion) {
        this.idReserva = idReserva;
        this.fechareservacion = fechareservacion;
        this.idhabitacion = idhabitacion;
        this.categoria = categoria;
        this.tipo = tipo;
        this.Ciudad = Ciudad;
        this.calificacion = calificacion;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Date getFechareservacion() {
        return fechareservacion;
    }

    public void setFechareservacion(Date fechareservacion) {
        this.fechareservacion = fechareservacion;
    }

    public int getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(int idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

}
