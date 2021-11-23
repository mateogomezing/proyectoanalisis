/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOHospedaje;
import Excepcion.BuscarHospedajeException;
import Excepcion.CantidadHuespedesException;
import Excepcion.CargarImagenException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHospedajeException;
import Excepcion.ModificarHospedajeException;
import Excepcion.NombreHospedajeException;
import Modelo.Anfitrion;
import Modelo.Hospedaje;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 */
public class CtlHospedaje {

    BOHospedaje bo;

    public CtlHospedaje() {
        bo = new BOHospedaje();
    }

    public void guardarHospedaje(int idAnfitrion, File ruta, String categoria, String tipo, String cantidadpersonas, String ubicacion, String habitaciones, String camas, String bano, String estado, String servicios, String valorpornoche) throws DatosIncompletosException, NombreHospedajeException, CargarImagenException, GuardarHospedajeException {
        bo.guardarHospedaje(idAnfitrion, ruta, categoria, tipo, cantidadpersonas, ubicacion, habitaciones, camas, bano, estado, servicios, valorpornoche);
    }

    public Hospedaje buscarHospedaje(String tipo) throws BuscarHospedajeException, DatosIncompletosException {
        return bo.buscarHospedaje(tipo);
    }

    public Hospedaje buscarHospedaje2(String tipo, String cantidadpersonas) throws BuscarHospedajeException, DatosIncompletosException, CantidadHuespedesException {
        return bo.buscarHospedaje2(tipo, cantidadpersonas);
    }

    public Hospedaje buscarHospedajeAnfitrion(String tipo, int idAnfitrion) throws BuscarHospedajeException, DatosIncompletosException {
        return bo.buscarHospedajeAnfitrion(tipo, idAnfitrion);
    }

    public ArrayList<Hospedaje> buscarHospedajeCiudad(JComboBox x) throws ComboBoxException, BuscarHospedajeException {
        return bo.buscarHospedajeCiudad(x);
    }

    public ArrayList<Hospedaje> buscarHospedajeTipo(JComboBox x, JComboBox xs) throws ComboBoxException, BuscarHospedajeException {
        return bo.buscarHospedajeTipo(x, xs);
    }

    public DefaultComboBoxModel llenarComboBoxCategoria(ArrayList<Hospedaje> listahospedaje) {
        return bo.llenaerComboBoxCategoria(listahospedaje);

    }

    public DefaultComboBoxModel llenarComboBoxTipo(ArrayList<Hospedaje> listahospedaje) {
        return bo.llenaerComboBoxTipo(listahospedaje);

    }

    public DefaultComboBoxModel llenarComboxAnfitrion(Anfitrion anfitrion) {
        return bo.llenarComboBoxAnfitrion(anfitrion);
    }

    public void modificarHospedaje(int idAnfitrion, File ruta, String categoria, String tipo, String cantidadpersonas, String ubicacion, String habitaciones, String camas, String bano, String estado, String servicios, String valorpornoche) throws BuscarHospedajeException, DatosIncompletosException, NombreHospedajeException, CargarImagenException, ModificarHospedajeException {
        bo.modificarHospedaje(idAnfitrion, ruta, categoria, tipo, cantidadpersonas, ubicacion, habitaciones, camas, bano, estado, servicios, valorpornoche);
    }

    public void modificarHospedaje2(int idAnfitrion, String categoria, String tipo, String cantidadpersonas, String ubicacion, String habitaciones, String camas, String bano, String estado, String servicios, String valorpornoche) throws BuscarHospedajeException, DatosIncompletosException, NombreHospedajeException, ModificarHospedajeException {
        bo.modificarHospedaje2(idAnfitrion, categoria, tipo, cantidadpersonas, ubicacion, habitaciones, camas, bano, estado, servicios, valorpornoche);
    }

    public DefaultTableModel listarElementos() {
        return bo.listarElementos();
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws ComboBoxException {
        return bo.filtrar(opcion, accion);
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);
    }

    public String obtenerDatoJtextArea(JTextArea x) {
        return bo.obtenerDatoJtextArea(x);
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

    public int seleccionarArchivoAnfitrion(int idAnfitrion) {
        return bo.seleccionarArchivoAnfitrion(idAnfitrion);
    }

    public DefaultComboBoxModel llenarComboBox() {
        return bo.llenarComboBox();
    }

    public int obtenerIdAnfitrion(String anfitrion) throws DatosIncompletosException {
        return bo.obtenerIdAnfitrion(anfitrion);
    }
}
