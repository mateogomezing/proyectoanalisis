/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOAnfitrion;
import Excepcion.BuscarAnfitrionException;
import Excepcion.CargarImagenException;
import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaException;
import Excepcion.CedulaHuespedException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarAnfitrionException;
import Fabrica.FactoryDAO;
import Modelo.Anfitrion;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class BOAnfitrion {

    private final IDAOAnfitrion dao;

    public BOAnfitrion() {
        dao = FactoryDAO.getFabrica().crearDAOAnfitrion();
    }

    /**
     * Metodo encargado de convertir un File a bytes
     *
     * @param file ruta de la imagen
     * @return imagen convertida en bytes
     * @throws CargarImagenException si hay algun error al convertir el File
     */
    public byte[] cargarImagenBytes(File file) throws CargarImagenException {
        try {
            byte[] icono = new byte[(int) file.length()];
            InputStream input = new FileInputStream(file);
            input.read(icono);
            return icono;
        } catch (IOException e) {
            throw new CargarImagenException();
        }
    }

    /**
     * Metodo encargado de convertir bytes en un BufferedImage
     *
     * @param bytes que se desea pasar a un BufferedImage
     * @return bytes convertidos en InputStream
     * @throws CargarImagenException si hay algun error al convertitir los bytes
     */
    public BufferedImage cargarImagenBufferedImage(byte[] bytes) throws CargarImagenException {
        try {
            BufferedImage imagen = null;
            InputStream input = new ByteArrayInputStream(bytes);
            imagen = ImageIO.read(input);
            return imagen;
        } catch (IOException e) {
            throw new CargarImagenException();
        }
    }

    public void guardarAnfitrion(File ruta, String cedula, String nombrecompleto, String residencia, String idioma, String contrasena, String biografia, String estado) throws CargarImagenException, GuardarAnfitrionException, CedulaException, DatosIncompletosException, CedulaAdministradorException, CedulaHuespedException {

        Anfitrion anfitrion = new Anfitrion(0, cargarImagenBytes(ruta), cedula, nombrecompleto, residencia, idioma, contrasena, biografia, estado);

        if (!dao.guardarAnfitrion(anfitrion)) {
            throw new GuardarAnfitrionException();
        }
    }

    public Anfitrion buscarAnfitrion(String cedula) throws DatosIncompletosException, BuscarAnfitrionException {
        if (cedula == null) {
            throw new DatosIncompletosException();
        }
        Anfitrion anfitrion = dao.buscarAnfitrion(cedula);

        if (anfitrion == null) {
            throw new BuscarAnfitrionException();
        }
        return anfitrion;
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione")) {
            informacion = null;
        }
        return informacion;
    }
}
