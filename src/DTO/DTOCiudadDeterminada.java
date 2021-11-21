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
public class DTOCiudadDeterminada {

    private int idReserva;
    private Date fechareservacion;
    private int idhabitacion;
    private String categoria;
    private String tipo;
    private String Ciudad;
    private String CedulaCliente;
    private String nombreCompleto;
    private String nivelEstudio;
    private String estrato;
    private String estado;
    public DTOCiudadDeterminada() {

    }

    public DTOCiudadDeterminada(int idReserva, Date fechareservacion, int idhabitacion, String categoria, String tipo, String Ciudad, String CedulaCliente, String nombreCompleto, String nivelEstudio, String estrato, String estado) {
        this.idReserva = idReserva;
        this.fechareservacion = fechareservacion;
        this.idhabitacion = idhabitacion;
        this.categoria = categoria;
        this.tipo = tipo;
        this.Ciudad = Ciudad;
        this.CedulaCliente = CedulaCliente;
        this.nombreCompleto = nombreCompleto;
        this.nivelEstudio = nivelEstudio;
        this.estrato = estrato;
        this.estado = estado;
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

    public String getCedulaCliente() {
        return CedulaCliente;
    }

    public void setCedulaCliente(String CedulaCliente) {
        this.CedulaCliente = CedulaCliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
