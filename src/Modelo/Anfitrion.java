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
public class Anfitrion {

    private int id;
    private byte[] foto;
    private String cedula;
    private String nombreCompleto;
    private String residencia;
    private String idioma;
    private String contrasena;
    private String biografia;
    private String estado;

    public Anfitrion() {
        this.id = 0;
        this.foto = null;
        this.cedula = null;
        this.nombreCompleto = null;
        this.residencia = null;
        this.idioma = null;
        this.contrasena = null;
        this.biografia = null;
        this.estado = null;

    }

    public Anfitrion(int id, byte[] foto, String cedula, String nombreCompleto, String residencia, String idioma, String contrasena, String biografia, String estado) {
        this.id = id;
        this.foto = foto;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.residencia = residencia;
        this.idioma = idioma;
        this.contrasena = contrasena;
        this.biografia = biografia;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
