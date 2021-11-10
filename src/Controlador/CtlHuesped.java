/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BoHuesped;
import Excepcion.BuscarHuespedException;
import Excepcion.CargarImagenException;
import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaAnfitrionException;
import Excepcion.CedulaException;
import Excepcion.CorreoException;
import Excepcion.CorreoFormatoException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHuespedException;
import Excepcion.ModificarHospedajeException;
import Excepcion.TelefonoException;
import Modelo.Huesped;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class CtlHuesped {

    BoHuesped bo;

    public CtlHuesped() {
        bo = new BoHuesped();
    }

    public void guardarHuesped(File ruta, String cedula, String nombrecompleto, String genero, String correo, String estrato, String nivelestudio, String estadocivil, String telefono, String direccion, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado, String biografia) throws DatosIncompletosException, CorreoFormatoException, CargarImagenException, CedulaException, CorreoException, TelefonoException, CedulaAdministradorException, GuardarHuespedException, CedulaAnfitrionException {
        bo.guardarHuesped(ruta, cedula, nombrecompleto, genero, correo, estrato, nivelestudio, estadocivil, telefono, direccion, fechanacimiento, nacionalidad, contrasena, tipo, estado, biografia);
    }

    public Huesped buscarHuesped(String cedula) throws DatosIncompletosException, BuscarHuespedException {
        return bo.buscarHuesped(cedula);
    }

    public void modificarHuesped(String cedula, String nombrecompleto, String genero, String correo, String estrato, String nivelestudio, String estadocivil, String telefono, String direccion, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado, String biografia) throws DatosIncompletosException, CorreoFormatoException, BuscarHuespedException, CorreoException, CedulaException, TelefonoException, ModificarHospedajeException {
        bo.modificarHuesped(cedula, nombrecompleto, genero, correo, estrato, nivelestudio, estadocivil, telefono, direccion, fechanacimiento, nacionalidad, contrasena, tipo, estado, biografia);

    }

    public void modificarHuesped2(File ruta, String cedula, String nombrecompleto, String genero, String correo, String estrato, String nivelestudio, String estadocivil, String telefono, String direccion, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado, String biografia) throws ModificarHospedajeException, CedulaException, CorreoException, TelefonoException, DatosIncompletosException, BuscarHuespedException, CargarImagenException {
        bo.modificarHuesped2(ruta, cedula, nombrecompleto, genero, correo, estrato, nivelestudio, estadocivil, telefono, direccion, fechanacimiento, nacionalidad, contrasena, tipo, estado, biografia);
    }

    public ArrayList<Huesped> listaHuespedes() {
        return bo.listaHuesped();
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public byte[] cargarImagenBytes(File file) throws CargarImagenException {
        return bo.cargarImagenBytes(file);
    }

    public BufferedImage cargarImagenBufferedImage(byte[] bytes) throws CargarImagenException {
        return bo.cargarImagenBufferedImage(bytes);
    }
}
