/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOAnfitrion;
import Definiciones.IDAOHospedaje;
import Excepcion.BuscarHospedajeException;
import Excepcion.CargarImagenException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHospedajeException;
import Excepcion.ModificarHospedajeException;
import Excepcion.NombreHospedajeException;
import Fabrica.FactoryDAO;
import Modelo.Anfitrion;
import Modelo.Hospedaje;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BOHospedaje {

    private final IDAOHospedaje dao;
    private final IDAOAnfitrion daoanfitrion;

    public BOHospedaje() {
        dao = FactoryDAO.getFabrica().crearDAOHospedaje();
        daoanfitrion = FactoryDAO.getFabrica().crearDAOAnfitrion();
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

    public void guardarHospedaje(int idAnfitrion, File ruta, String categoria, String tipo, String cantidadpersonas, String ubicacion, String habitaciones, String camas, String bano, String estado, String servicios, String valorpornoche) throws DatosIncompletosException, NombreHospedajeException, CargarImagenException, GuardarHospedajeException {

        Hospedaje hospedaje = new Hospedaje(0, idAnfitrion, cargarImagenBytes(ruta), categoria, tipo, cantidadpersonas, ubicacion, habitaciones, camas, bano, estado, servicios, valorpornoche);
        if (!dao.guardarHospedaje(hospedaje)) {
            throw new GuardarHospedajeException();
        }
    }

    public Hospedaje buscarHospedaje(String tipo) throws BuscarHospedajeException, DatosIncompletosException {
        if (tipo == null) {
            throw new DatosIncompletosException();
        }
        Hospedaje hospedaje = dao.buscarHospedaje(tipo);
        if (hospedaje == null) {
            throw new BuscarHospedajeException();
        }
        return hospedaje;
    }

    public ArrayList<Hospedaje> buscarHospedajeCiudad(JComboBox x) throws ComboBoxException, BuscarHospedajeException {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione")) {
            throw new ComboBoxException();
        }
        ArrayList<Hospedaje> hospedajes = dao.buscarHospedajeCiudad(informacion);

        return hospedajes;
    }

    public ArrayList<Hospedaje> buscarHospedajeTipo(JComboBox x, JComboBox xs) throws ComboBoxException, BuscarHospedajeException {
        String informacion = x.getSelectedItem().toString();
        String informacion2 = xs.getSelectedItem().toString();
        if (informacion2.equals("Seleccione")) {
            throw new ComboBoxException();
        }
        ArrayList<Hospedaje> hospedajes = dao.buscarHospedajeTipo(informacion, informacion2);

        return hospedajes;
    }

    public DefaultComboBoxModel llenaerComboBoxCategoria(ArrayList<Hospedaje> hospedajes) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < hospedajes.size(); i++) {

            if (hospedajes.get(i).getEstado().equalsIgnoreCase("Disponible")) {
                modelo.addElement(hospedajes.get(i).getCategoria());
            }

        }
        return modelo;
    }

    public DefaultComboBoxModel llenaerComboBoxTipo(ArrayList<Hospedaje> hospedajes) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < hospedajes.size(); i++) {

            if (hospedajes.get(i).getEstado().equalsIgnoreCase("Disponible")) {
                modelo.addElement(hospedajes.get(i).getTipo());
            }

        }
        return modelo;
    }

    public void modificarHospedaje(int idAnfitrion, File ruta, String categoria, String tipo, String cantidadpersonas, String ubicacion, String habitaciones, String camas, String bano, String estado, String servicios, String valorpornoche) throws BuscarHospedajeException, DatosIncompletosException, NombreHospedajeException, CargarImagenException, ModificarHospedajeException {
        Hospedaje hospedaje = new Hospedaje(buscarHospedaje(tipo).getId(), idAnfitrion, cargarImagenBytes(ruta), categoria, tipo, cantidadpersonas, ubicacion, habitaciones, camas, bano, estado, servicios, valorpornoche);
        if (!dao.modificarHospedaje(hospedaje)) {
            throw new ModificarHospedajeException();

        }
    }

    public void modificarHospedaje2(int idAnfitrion, String categoria, String tipo, String cantidadpersonas, String ubicacion, String habitaciones, String camas, String bano, String estado, String servicios, String valorpornoche) throws BuscarHospedajeException, DatosIncompletosException, NombreHospedajeException, ModificarHospedajeException {
        Hospedaje hospedaje = new Hospedaje(buscarHospedaje(tipo).getId(), idAnfitrion, null, categoria, tipo, cantidadpersonas, ubicacion, habitaciones, camas, bano, estado, servicios, valorpornoche);
        if (!dao.modificarHospedaje2(hospedaje)) {
            throw new ModificarHospedajeException();

        }
    }

    public ArrayList<Hospedaje> listarHospedajes() {
        return dao.listarHospedaje();
    }

    public ArrayList<Anfitrion> listaAnfitrion() {
        return daoanfitrion.listarAnfitrion();
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

    public DefaultComboBoxModel llenarComboBox() {
        ArrayList<Anfitrion> listarAnfitrion = listaAnfitrion();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        listarAnfitrion.stream().filter((categoria) -> (categoria.getEstado().equalsIgnoreCase("activo"))).forEachOrdered((categoria) -> {
            modelo.addElement(categoria.getNombreCompleto());
        });
        return modelo;
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione")) {
            informacion = null;
        }
        return informacion;
    }

    public int obtenerIdAnfitrion(String anfitrion) throws DatosIncompletosException {
        ArrayList<Anfitrion> listarAnfitrion = listaAnfitrion();
        if (anfitrion.equalsIgnoreCase("Seleccione")) {
            throw new DatosIncompletosException();
        } else {
            for (Anfitrion anfitriones : listarAnfitrion) {

                if (anfitriones.getNombreCompleto().equalsIgnoreCase(anfitrion)) {
                    return anfitriones.getId();
                }
            }
        }
        return 0;
    }

    public int seleccionarArchivoAnfitrion(int idAnfitrion) {
        ArrayList<Anfitrion> listaAnfitrion = listaAnfitrion();
        int valor = 0;

        for (int i = 0; i < listaAnfitrion.size(); i++) {
            if (listaAnfitrion.get(i).getId() == idAnfitrion) {
                valor = i + 1;
                break;
            }
        }
        return valor;
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws ComboBoxException {

        String anfitrion = "";
        ArrayList<Hospedaje> ListaHospedaje = listarHospedajes();
        String nombreColumnas[] = {"Id", "Anfitrion", "Categoria", "Tipo", "Cantidad Personas", "Habitaciones", "Servicios", "Valor Por Noche"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 8:
                        return true;
                    default:
                        return false;
                }
            }
        };
        ArrayList<Anfitrion> listaAnfitrion = listaAnfitrion();
        switch (opcion) {
            case "Seleccione":
                throw new ComboBoxException();

            case "Id":
                try {
                    int x = Integer.parseInt(accion);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException();
                }
                if (!accion.equals("Seleccione")) {
                    for (int i = 0; i < ListaHospedaje.size(); i++) {
                        if (Integer.parseInt(accion) == ListaHospedaje.get(i).getId() && ListaHospedaje.get(i).getEstado().equals("Disponible")) {
                            for (int j = 0; j < listaAnfitrion.size(); j++) {
                                if (ListaHospedaje.get(i).getIdAnfitrion() == listaAnfitrion.get(i).getId() && listaAnfitrion.get(i).getEstado().equals("activo")) {
                                    anfitrion = listaAnfitrion.get(j).getNombreCompleto();
                                    break;
                                }
                            }
                            modelo.addRow(new Object[]{ListaHospedaje.get(i).getId(), anfitrion, ListaHospedaje.get(i).getCategoria(), ListaHospedaje.get(i).getTipo(), ListaHospedaje.get(i).getCantidadpersonas(), ListaHospedaje.get(i).getHabitaciones(), ListaHospedaje.get(i).getServicios(), ListaHospedaje.get(i).getValorPorNoche()});
                        }
                    }
                    return modelo;
                } else {
                    throw new ComboBoxException();
                }

            case "Tipo":
                if (!accion.equals("Seleccione")) {
                    for (int i = 0; i < ListaHospedaje.size(); i++) {
                        if (accion.equals(ListaHospedaje.get(i).getTipo()) && ListaHospedaje.get(i).getEstado().equals("Disponible")) {
                            for (int j = 0; j < listaAnfitrion.size(); j++) {
                                if (ListaHospedaje.get(i).getIdAnfitrion() == listaAnfitrion.get(i).getId() && listaAnfitrion.get(i).getEstado().equals("activo")) {
                                    anfitrion = listaAnfitrion.get(j).getNombreCompleto();
                                    break;
                                }
                            }
                            modelo.addRow(new Object[]{ListaHospedaje.get(i).getId(), anfitrion, ListaHospedaje.get(i).getCategoria(), ListaHospedaje.get(i).getTipo(), ListaHospedaje.get(i).getCantidadpersonas(), ListaHospedaje.get(i).getHabitaciones(), ListaHospedaje.get(i).getServicios(), ListaHospedaje.get(i).getValorPorNoche()});
                        }
                    }
                    return modelo;
                } else {
                    throw new ComboBoxException();
                }
            case "Tipo Alojamiento":
                if (!accion.equals("Seleccione")) {
                    for (int i = 0; i < ListaHospedaje.size(); i++) {
                        if (accion.equals(ListaHospedaje.get(i).getCategoria()) && ListaHospedaje.get(i).getEstado().equals("Disponible")) {
                            for (int j = 0; j < listaAnfitrion.size(); j++) {
                                if (ListaHospedaje.get(i).getIdAnfitrion() == listaAnfitrion.get(i).getId() && listaAnfitrion.get(i).getEstado().equals("activo")) {
                                    anfitrion = listaAnfitrion.get(j).getNombreCompleto();
                                    break;
                                }
                            }
                            modelo.addRow(new Object[]{ListaHospedaje.get(i).getId(), anfitrion, ListaHospedaje.get(i).getCategoria(), ListaHospedaje.get(i).getTipo(), ListaHospedaje.get(i).getCantidadpersonas(), ListaHospedaje.get(i).getHabitaciones(), ListaHospedaje.get(i).getServicios(), ListaHospedaje.get(i).getValorPorNoche()});
                        }
                    }
                    return modelo;
                } else {
                    throw new ComboBoxException();
                }
            //REVISAR

            case "Ubicacion":
                if (!accion.equals("Seleccione")) {
                    for (int i = 0; i < ListaHospedaje.size(); i++) {
                        if (accion.equals(ListaHospedaje.get(i).getUbicacion()) && ListaHospedaje.get(i).getEstado().equals("Disponible")) {
                            for (int j = 0; j < listaAnfitrion.size(); j++) {
                                if (ListaHospedaje.get(i).getIdAnfitrion() == listaAnfitrion.get(i).getId() && listaAnfitrion.get(i).getEstado().equals("activo")) {
                                    anfitrion = listaAnfitrion.get(j).getNombreCompleto();
                                    break;
                                }
                            }
                            modelo.addRow(new Object[]{ListaHospedaje.get(i).getId(), anfitrion, ListaHospedaje.get(i).getCategoria(), ListaHospedaje.get(i).getTipo(), ListaHospedaje.get(i).getCantidadpersonas(), ListaHospedaje.get(i).getHabitaciones(), ListaHospedaje.get(i).getServicios(), ListaHospedaje.get(i).getValorPorNoche()});
                        }
                    }
                    return modelo;
                } else {
                    throw new ComboBoxException();
                }
            default:
                break;
        }
        return modelo;
    }

    public DefaultTableModel listarElementos() {
        ArrayList<Hospedaje> listahospedaje = listarHospedajes();
        ArrayList<Anfitrion> listaanfitrion = listaAnfitrion();
        String nombreColumnas[] = {"Id", "Anfitrion", "Categoria", "Tipo", "Cantidad Personas", "Habitaciones", "Servicios", "Valor Por Noche"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 8:
                        return true;
                    default:
                        return false;
                }
            }
        };
        String anfitriones = "";

        for (Hospedaje hospedaje : listahospedaje) {
            if (hospedaje.getEstado().equalsIgnoreCase("Disponible")) {
                for (Anfitrion anfitrion : listaanfitrion) {
                    if (anfitrion.getId() == hospedaje.getIdAnfitrion()) {
                        anfitriones = anfitrion.getCedula() + "-" + anfitrion.getNombreCompleto();
                        break;
                    }
                }
                modelo.addRow(new Object[]{hospedaje.getId(), anfitriones, hospedaje.getCategoria(), hospedaje.getTipo(), hospedaje.getCantidadpersonas(), hospedaje.getHabitaciones(), hospedaje.getServicios(), hospedaje.getValorPorNoche()});
            }
        }
        return modelo;
    }

}
