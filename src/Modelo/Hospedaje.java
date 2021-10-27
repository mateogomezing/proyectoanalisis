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
    private byte[] imagen;
    private int idTipoAlojamiento;
    private String nombre;
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
        this.imagen = null;
        this.idTipoAlojamiento = 0;
        this.nombre = null;
        this.cantidadpersonas = null;
        this.ubicacion = null;
        this.habitaciones = null;
        this.camas = null;
        this.bano = null;
        this.estado = null;
        this.servicios = null;
        this.valorPorNoche = null;

    }

    public Hospedaje(int id, byte[] imagen, int idTipoAlojamiento, String nombre, String cantidadpersonas, String ubicacion, String habitaciones, String camas, String bano, String estado, String servicios, String valorPorNoche) {
        this.id = id;
        this.imagen = imagen;
        this.idTipoAlojamiento = idTipoAlojamiento;
        this.nombre = nombre;
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getIdTipoAlojamiento() {
        return idTipoAlojamiento;
    }

    public void setIdTipoAlojamiento(int idTipoAlojamiento) {
        this.idTipoAlojamiento = idTipoAlojamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
