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
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarAnfitrionException;
import Excepcion.ModificarAnfitrionException;
import Fabrica.FactoryDAO;
import Modelo.Anfitrion;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 *
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

    /**
     * Método encargado de guardar el Anfitrion
     *
     * @param ruta
     * @param cedula
     * @param nombrecompleto
     * @param residencia
     * @param idioma
     * @param contrasena
     * @param biografia
     * @param estado
     * @throws CargarImagenException
     * @throws GuardarAnfitrionException
     * @throws CedulaException
     * @throws DatosIncompletosException
     * @throws CedulaAdministradorException
     * @throws CedulaHuespedException
     */
    public void guardarAnfitrion(File ruta, String cedula, String nombrecompleto, String residencia, String idioma, String contrasena, String biografia, String estado) throws CargarImagenException, GuardarAnfitrionException, CedulaException, DatosIncompletosException, CedulaAdministradorException, CedulaHuespedException {

        Anfitrion anfitrion = new Anfitrion(0, cargarImagenBytes(ruta), cedula, nombrecompleto, residencia, idioma, contrasena, biografia, estado);

        if (!dao.guardarAnfitrion(anfitrion)) {
            throw new GuardarAnfitrionException();
        }
    }

    /**
     * Metodo encargado de buscar anfitrion por la cedula
     *
     * @param cedula
     * @return retorna objeto anfitrion
     * @throws DatosIncompletosException
     * @throws BuscarAnfitrionException
     */
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

    /**
     * Metodo encargado de buscar anfitrion por el id
     *
     * @param IdAnfitrion
     * @return retorna objeto anfitrion
     * @throws BuscarAnfitrionException
     */
    public Anfitrion buscarAnfitrionId(int IdAnfitrion) throws BuscarAnfitrionException {
        Anfitrion anfitrion = dao.buscarAnfitrionId(IdAnfitrion);
        if (anfitrion == null) {
            throw new BuscarAnfitrionException();
        }
        return anfitrion;
    }

    /**
     * Metodo encargado de modificar anfitrion sin foto
     *
     * @param cedula
     * @param nombrecompleto
     * @param residencia
     * @param idioma
     * @param contrasena
     * @param biografia
     * @param estado
     * @throws ModificarAnfitrionException
     * @throws CedulaException
     * @throws DatosIncompletosException
     * @throws BuscarAnfitrionException
     */
    public void modificarAnfitrion(String cedula, String nombrecompleto, String residencia, String idioma, String contrasena, String biografia, String estado) throws ModificarAnfitrionException, CedulaException, DatosIncompletosException, BuscarAnfitrionException {

        Anfitrion anfitrion = new Anfitrion(buscarAnfitrion(cedula).getId(), null, cedula, nombrecompleto, residencia, idioma, contrasena, biografia, estado);
        if (!dao.modificarAnfitrion(anfitrion)) {
            throw new ModificarAnfitrionException();
        }
    }

    /**
     * Metodo encargado de modificar anfitrion con foto
     *
     * @param cedula
     * @param ruta
     * @param nombrecompleto
     * @param residencia
     * @param idioma
     * @param contrasena
     * @param biografia
     * @param estado
     * @throws CargarImagenException
     * @throws CedulaException
     * @throws DatosIncompletosException
     * @throws ModificarAnfitrionException
     * @throws BuscarAnfitrionException
     */
    public void modificarAnfitrion2(String cedula, File ruta, String nombrecompleto, String residencia, String idioma, String contrasena, String biografia, String estado) throws CargarImagenException, CedulaException, DatosIncompletosException, ModificarAnfitrionException, BuscarAnfitrionException {

        Anfitrion anfitrion = new Anfitrion(buscarAnfitrion(cedula).getId(), cargarImagenBytes(ruta), cedula, nombrecompleto, residencia, idioma, contrasena, biografia, estado);
        if (!dao.modificarAnfitrion2(anfitrion)) {
            throw new ModificarAnfitrionException();
        }
    }

    /**
     * Metodo que lista los anfitriones
     *
     * @return lista de objetos anfitriones
     */
    public ArrayList<Anfitrion> listaAnfitrion() {
        return dao.listarAnfitrion();
    }

    /**
     * Metodo que se encarga de listar elementos en la tabla
     *
     * @return
     */
    public DefaultTableModel listarElementos() {

        ArrayList<Anfitrion> lista = listaAnfitrion();
        String nombreColumnas[] = {"Id", "Cedula", "Nombre Completo", "Residencia", "Idioma", "Contrasena", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 7:
                        return true;
                    default:
                        return false;
                }
            }
        };

        lista.forEach((Anfitrion) -> {
            if (!Anfitrion.getEstado().equalsIgnoreCase("No Disponible")) {          //"Id", "Cedula", "Nombre Completo", "Residencia", "Idioma", "Contrasena", "Biografia", "Estado"
                modelo.addRow(new Object[]{Anfitrion.getId(), Anfitrion.getCedula(), Anfitrion.getNombreCompleto(), Anfitrion.getResidencia(), Anfitrion.getIdioma(), Anfitrion.getContrasena(), Anfitrion.getEstado()});
            }

        });

        return modelo;
    }

    /**
     * Metodo encargado de filtrar la tabla de anfitriones
     *
     * @param opcion
     * @param accion
     * @return
     * @throws DatosIncompletosException
     * @throws NumberFormatException
     * @throws ComboBoxException
     */
    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        if (accion == null) {
            throw new DatosIncompletosException();
        }

        String nombre = "";
        ArrayList<Anfitrion> lista = listaAnfitrion();
        String nombreColumnas[] = {"Id", "Cedula", "Nombre Completo", "Residencia", "Idioma", "Contrasena", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 7:
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
                lista.forEach((anfitrion) -> {
                    if (anfitrion.getCedula().equalsIgnoreCase(accion)) {

                        if (!anfitrion.getEstado().equalsIgnoreCase("No Disponible")) {
                            modelo.addRow(new Object[]{anfitrion.getId(), anfitrion.getCedula(), anfitrion.getNombreCompleto(), anfitrion.getResidencia(), anfitrion.getIdioma(), anfitrion.getContrasena(), anfitrion.getEstado()});
                        }
                    }
                });
                return modelo;

            case "Estado":
                lista.forEach((anfitrion) -> {
                    if (anfitrion.getEstado().equalsIgnoreCase(accion)) {

                        modelo.addRow(new Object[]{anfitrion.getId(), anfitrion.getCedula(), anfitrion.getNombreCompleto(), anfitrion.getResidencia(), anfitrion.getIdioma(), anfitrion.getContrasena(), anfitrion.getEstado()});

                    }
                });
                return modelo;
            default:
                break;
        }
        return modelo;

    }

    /**
     * Metodo encargado de verificar JtextField
     *
     * @param x
     * @return
     */
    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    /**
     * metodo encargado de verificar JComboBox
     *
     * @param x
     * @return
     */
    public String obtenerDatoJComboBox(JComboBox x) {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione")) {
            informacion = null;
        }
        return informacion;
    }

    /**
     * Metodo encargado de verificar JtextArea
     *
     * @param x
     * @return
     */
    public String obtenerDatoJtextArea(JTextArea x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }
}
