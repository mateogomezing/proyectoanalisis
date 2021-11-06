/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOAnfitrion;
import Excepcion.CargarImagenException;
import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaException;
import Excepcion.CedulaHuespedException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarAnfitrionException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class CtlAnfitrion {

    BOAnfitrion bo;

    public CtlAnfitrion() {
        bo = new BOAnfitrion();
    }

    public void guardarAnfitrion(File ruta, String cedula, String nombrecompleto, String residencia, String idioma, String contrasena, String biografia, String estado) throws CargarImagenException, GuardarAnfitrionException, CedulaException, DatosIncompletosException, CedulaAdministradorException, CedulaHuespedException {
        bo.guardarAnfitrion(ruta, cedula, nombrecompleto, residencia, idioma, contrasena, biografia, estado);
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
