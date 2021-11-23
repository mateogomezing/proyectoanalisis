/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOAnfitrion;
import Excepcion.BuscarAnfitrionException;
import Excepcion.CargarImagenException;
import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaException;
import Excepcion.CedulaHuespedException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarAnfitrionException;
import Excepcion.ModificarAnfitrionException;
import Modelo.Anfitrion;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
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
public class CtlAnfitrion {

    BOAnfitrion bo;

    public CtlAnfitrion() {
        bo = new BOAnfitrion();
    }

    public void guardarAnfitrion(File ruta, String cedula, String nombrecompleto, String residencia, String idioma, String contrasena, String biografia, String estado) throws CargarImagenException, GuardarAnfitrionException, CedulaException, DatosIncompletosException, CedulaAdministradorException, CedulaHuespedException {
        bo.guardarAnfitrion(ruta, cedula, nombrecompleto, residencia, idioma, contrasena, biografia, estado);
    }

    public Anfitrion buscarAnfitrion(String cedula) throws DatosIncompletosException, BuscarAnfitrionException {
        return bo.buscarAnfitrion(cedula);
    }

    public Anfitrion buscarAnfitrionId(int IdAnfitrion) throws BuscarAnfitrionException {
        return bo.buscarAnfitrionId(IdAnfitrion);
    }

    public void modificarAnfitrion(String cedula, String nombrecompleto, String residencia, String idioma, String contrasena, String biografia, String estado) throws ModificarAnfitrionException, CedulaException, DatosIncompletosException, BuscarAnfitrionException {
        bo.modificarAnfitrion(cedula, nombrecompleto, residencia, idioma, contrasena, biografia, estado);

    }

    public void modificarAnfitrion2(String cedula, File ruta, String nombrecompleto, String residencia, String idioma, String contrasena, String biografia, String estado) throws CargarImagenException, CedulaException, DatosIncompletosException, ModificarAnfitrionException, BuscarAnfitrionException {
        bo.modificarAnfitrion2(cedula, ruta, nombrecompleto, residencia, idioma, contrasena, biografia, estado);
    }

    public ArrayList<Anfitrion> listaAnfitrion() {
        return bo.listaAnfitrion();
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
