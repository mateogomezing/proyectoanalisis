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
import Excepcion.CedulaAnfitrionException;
import Excepcion.CedulaException;
import Excepcion.ComboBoxException;
import Excepcion.CorreoException;
import Excepcion.CorreoFormatoException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHuespedException;
import Excepcion.ModificarHospedajeException;
import Excepcion.ModificarHuespedException;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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

    public void guardarHuesped(File ruta, String cedula, String nombrecompleto, String genero, String correo, String estrato, String nivelestudio, String estadocivil, String telefono, String direccion, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado, String biografia) throws DatosIncompletosException, CorreoFormatoException, CargarImagenException, CedulaException, CorreoException, TelefonoException, CedulaAdministradorException, GuardarHuespedException, CedulaAnfitrionException {
        verificarCorreo(correo);

        Huesped huesped = new Huesped(0, cargarImagenBytes(ruta), cedula, nombrecompleto, genero, correo, estrato, nivelestudio, estadocivil, telefono, direccion, fechanacimiento, nacionalidad, contrasena, tipo, estado, biografia);

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

    public void modificarHuesped(String cedula, String nombrecompleto, String genero, String correo, String estrato, String nivelestudio, String estadocivil, String telefono, String direccion, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado, String biografia) throws DatosIncompletosException, CorreoFormatoException, BuscarHuespedException, CedulaException, CorreoException, TelefonoException, ModificarHuespedException {
        verificarCorreo(correo);
        Huesped huesped = new Huesped(buscarHuesped(cedula).getId(), null, cedula, nombrecompleto, genero, correo, estrato, nivelestudio, estadocivil, telefono, direccion, fechanacimiento, nacionalidad, contrasena, tipo, estado, biografia);
        if (!dao.modificarHuesped(huesped)) {
            throw new ModificarHuespedException();
        }
    }

    public void modificarHuesped2(File ruta, String cedula, String nombrecompleto, String genero, String correo, String estrato, String nivelestudio, String estadocivil, String telefono, String direccion, Date fechanacimiento, String nacionalidad, String contrasena, String tipo, String estado, String biografia) throws CedulaException, CorreoException, TelefonoException, DatosIncompletosException, BuscarHuespedException, CargarImagenException, ModificarHuespedException, CorreoFormatoException {

        verificarCorreo(correo);
        Huesped huesped = new Huesped(buscarHuesped(cedula).getId(), cargarImagenBytes(ruta), cedula, nombrecompleto, genero, correo, estrato, nivelestudio, estadocivil, telefono, direccion, fechanacimiento, nacionalidad, contrasena, tipo, estado, biografia);
        if (!dao.modificarHuesped2(huesped)) {
            throw new ModificarHuespedException();
        }
    }

    public ArrayList<Huesped> listaHuesped() {
        return dao.listarHuesped();
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public String obtenerDatoJtextArea(JTextArea x) {
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

    public DefaultTableModel listarElementos() {

        ArrayList<Huesped> lista = listaHuesped();
        String nombreColumnas[] = {"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Estrato", "Nivel Estudio", "Estado CIvil", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 14:
                        return true;
                    default:
                        return false;
                }
            }
        };

        lista.forEach((huesped) -> {
            String fecha = formato.format(huesped.getFechaNacimiento());
            if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"
                modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombreCompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getEstrato(), huesped.getNivelestudio(), huesped.getEstadocivil(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
            }

        });

        return modelo;
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        if (accion == null) {
            throw new DatosIncompletosException();
        }

        String nombre = "";
        ArrayList<Huesped> lista = listaHuesped();
        String nombreColumnas[] = {"Id", "Cedula", "Nombre Completo", "Genero", "Correo", "Estrato", "Nivel Estudio", "Estado CIvil", "Telefono", "Fecha Nacimiento", "Nacionalidad", "Contrasena", "Tipo", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 14:
                        return true;
                    default:
                        return false;
                }
            }
        };

        switch (opcion) {
            case "Seleccione":
                throw new ComboBoxException();
            case "Cedula":
                lista.forEach((huesped) -> {
                    if (huesped.getCedula().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechaNacimiento());
                        if (!huesped.getEstado().equalsIgnoreCase("No Disponible")) {
                            modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombreCompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getEstrato(), huesped.getNivelestudio(), huesped.getEstadocivil(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});
                        }
                    }
                });
                return modelo;

            case "Estado":
                lista.forEach((huesped) -> {
                    if (huesped.getEstado().equalsIgnoreCase(accion)) {
                        String fecha = formato.format(huesped.getFechaNacimiento());

                        modelo.addRow(new Object[]{huesped.getId(), huesped.getCedula(), huesped.getNombreCompleto(), huesped.getGenero(), huesped.getCorreo(), huesped.getEstrato(), huesped.getNivelestudio(), huesped.getEstadocivil(), huesped.getTelefono(), fecha, huesped.getNacionalidad(), huesped.getContrasena(), huesped.getTipo(), huesped.getEstado()});

                    }
                });
                return modelo;
            default:
                break;
        }
        return modelo;

    }
}
