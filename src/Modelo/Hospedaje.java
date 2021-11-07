/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author mateo
 */
public class Hospedaje {

    private int id;
    private int idAnfitrion;
    private byte[] imagen;
    private String categoria;
    private String tipo;
    private String cantidadpersonas;
    private String ubicacion;
    private String habitaciones;
    private String camas;
    private String bano;
    private String estado;
    private String servicios;
    private String valorPorNoche;

    public Hospedaje() {
        this.id = 0;
        this.idAnfitrion = 0;
        this.imagen = null;
        this.categoria = null;
        this.tipo = null;
        this.cantidadpersonas = null;
        this.ubicacion = null;
        this.habitaciones = null;
        this.camas = null;
        this.bano = null;
        this.estado = null;
        this.servicios = null;
        this.valorPorNoche = null;

    }

    public Hospedaje(int id, int idAnfitrion, byte[] imagen, String categoria, String tipo, String cantidadpersonas, String ubicacion, String habitaciones, String camas, String bano, String estado, String servicios, String valorPorNoche) {
        this.id = id;
        this.idAnfitrion = idAnfitrion;
        this.imagen = imagen;
        this.categoria = categoria;
        this.tipo = tipo;
        this.cantidadpersonas = cantidadpersonas;
        this.ubicacion = ubicacion;
        this.habitaciones = habitaciones;
        this.camas = camas;
        this.bano = bano;
        this.estado = estado;
        this.servicios = servicios;
        this.valorPorNoche = valorPorNoche;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAnfitrion() {
        return idAnfitrion;
    }

    public void setIdAnfitrion(int idAnfitrion) {
        this.idAnfitrion = idAnfitrion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
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

    public String getCantidadpersonas() {
        return cantidadpersonas;
    }

    public void setCantidadpersonas(String cantidadpersonas) {
        this.cantidadpersonas = cantidadpersonas;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(String habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getCamas() {
        return camas;
    }

    public void setCamas(String camas) {
        this.camas = camas;
    }

    public String getBano() {
        return bano;
    }

    public void setBano(String bano) {
        this.bano = bano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getValorPorNoche() {
        return valorPorNoche;
    }

    public void setValorPorNoche(String valorPorNoche) {
        this.valorPorNoche = valorPorNoche;
    }

}
