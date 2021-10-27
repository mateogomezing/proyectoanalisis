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
public class TipoAlojamiento {
    private int id;
    private String categoria;
    private String nombre;
    private String descripcion;
    
    public TipoAlojamiento() {
        this.id = 0;
        this.categoria = null;
        this.nombre = null;
        this.descripcion = null;
    }

    public TipoAlojamiento(int id, String categoria, String nombre, String descripcion) {
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
