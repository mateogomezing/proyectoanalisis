/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 * * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 *
 */
public class DTOReservaActiva {

    private int idreserva;
    private Date fechareservacion;
    private int idhabitacion;
    private String estado;
    private String valor;

    public DTOReservaActiva() {

    }

    public DTOReservaActiva(int idreserva, Date fechareservacion, int idhabitacion, String estado, String valor) {
        this.idreserva = idreserva;
        this.fechareservacion = fechareservacion;
        this.idhabitacion = idhabitacion;
        this.estado = estado;
        this.valor = valor;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
