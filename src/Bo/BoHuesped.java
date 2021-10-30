/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;


import Definiciones.IDAOHuesped;
import Excepcion.BuscarHuespedException;
import Excepcion.CargarImagenException;
import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaException;
import Excepcion.CorreoException;
import Excepcion.CorreoFormatoException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHuespedException;
import Excepcion.TelefonoException;
import Fabrica.FactoryDAO;
import Modelo.Huesped;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

/**
 *
 * @author mateo
 */
public class BoHuesped {

    private final IDAOHuesped dao;
    private final DateFormat formato;
    private final Pattern pattern;

    public BoHuesped() {
        dao = FactoryDAO.getFabrica().crearDAOHuesped();
        formato = DateFormat.getDateInstance();
        pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
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

    public void guardarHuesped(File ruta, String cedula, String nombrecompleto, String genero, String correo, String telefono, String direccion, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado, String biografia) throws DatosIncompletosException, CorreoFormatoException, CargarImagenException, CedulaException, CorreoException, TelefonoException, CedulaAdministradorException, GuardarHuespedException {
        verificarCorreo(correo);

        Huesped huesped = new Huesped(0, cargarImagenBytes(ruta), cedula, nombrecompleto, genero, correo, telefono, direccion, fechanacimiento, nacionalidad, contrasena, tipo, estado, biografia);

        if (!dao.guardarHuesped(huesped)) {
            throw new GuardarHuespedException();
        }
    }

    public Huesped buscarHuesped(String cedula) throws DatosIncompletosException, BuscarHuespedException {
        if (cedula == null) {
            throw new DatosIncompletosException();
        }
        Huesped huesped = dao.buscarHuesped(cedula);
        if (huesped == null) {
            throw new BuscarHuespedException();
        }
        return huesped;
    }

    private void verificarCorreo(String correo) throws DatosIncompletosException, CorreoFormatoException {
        if (correo == null) {
            throw new DatosIncompletosException();
        }
        Matcher mather = pattern.matcher(correo);
        if (mather.find()) {
        } else {
            throw new CorreoFormatoException();
        }
    }
}
