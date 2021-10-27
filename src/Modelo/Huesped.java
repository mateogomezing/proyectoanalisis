package Modelo;

import java.util.Date;

/**
 *
 * @author Sara Lucía
 */
public class Huesped {
    
    private int id;
    private byte[] foto;
    private String cedula;
    private String nombreCompleto;
    private String genero;
    private String correo;
    private String telefono;
    private String direccion;
    private Date fechaNacimiento;
    private String nacionalidad;
    private String contrasena;
    private String tipo;
    private String estado;
    private String biografia;

    public Huesped() {
        this.id = 0;
        this.foto = null;
        this.cedula = null;
        this.nombreCompleto = null;
        this.genero = null;
        this.correo = null;
        this.telefono = null;
        this.direccion = null;
        this.fechaNacimiento = null;
        this.nacionalidad = null;
        this.contrasena = null;
        this.tipo = null;
        this.estado = null;
        this.biografia = null;
    }

    public Huesped(int id, byte[] foto, String cedula, String nombreCompleto, String genero, String correo, String telefono, String direccion, Date fechaNacimiento, String nacionalidad, String contrasena, String tipo, String estado, String biografia) {
        this.id = id;
        this.foto = foto;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.contrasena = contrasena;
        this.tipo = tipo;
        this.estado = estado;
        this.biografia = biografia;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }
}
