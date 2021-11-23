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
import Excepcion.ComboBoxException;
import Excepcion.CorreoException;
import Excepcion.CorreoFormatoException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHuespedException;
import Excepcion.ModificarHuespedException;
import Excepcion.TelefonoException;
import Modelo.Huesped;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
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

    public void modificarHuesped(String cedula, String nombrecompleto, String genero, String correo, String estrato, String nivelestudio, String estadocivil, String telefono, String direccion, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado, String biografia) throws DatosIncompletosException, CorreoFormatoException, BuscarHuespedException, CorreoException, CedulaException, TelefonoException, ModificarHuespedException {
        bo.modificarHuesped(cedula, nombrecompleto, genero, correo, estrato, nivelestudio, estadocivil, telefono, direccion, fechanacimiento, nacionalidad, contrasena, tipo, estado, biografia);

    }

    public void modificarHuesped2(File ruta, String cedula, String nombrecompleto, String genero, String correo, String estrato, String nivelestudio, String estadocivil, String telefono, String direccion, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado, String biografia) throws CedulaException, CorreoException, TelefonoException, DatosIncompletosException, BuscarHuespedException, CargarImagenException, ModificarHuespedException, CorreoFormatoException {
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

    public String obtenerDatoJtextArea(JTextArea x) {
        return bo.obtenerDatoJtextArea(x);
    }

    public byte[] cargarImagenBytes(File file) throws CargarImagenException {
        return bo.cargarImagenBytes(file);
    }

    public BufferedImage cargarImagenBufferedImage(byte[] bytes) throws CargarImagenException {
        return bo.cargarImagenBufferedImage(bytes);
    }

    public DefaultTableModel listarElementos() {
        return bo.listarElementos();
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        return bo.filtrar(opcion, accion);
    }
}
