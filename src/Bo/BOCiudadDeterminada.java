/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOCiudadDeterminada;
import Excepcion.BuscarCiudadDeterminadaException;
import Excepcion.DatosIncompletosException;
import Fabrica.FactoryDAO;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 */
public class BOCiudadDeterminada {

    private IDAOCiudadDeterminada dao;
    private final DateFormat formato;

    public BOCiudadDeterminada() {
        dao = FactoryDAO.getFabrica().crearDAOCiudadDeterminada();
        formato = DateFormat.getDateInstance();
    }

    /**
     * Metodo encargado de lista la consulta Ciudades por medio variable ciudad
     *
     * @param ciudad
     * @return lista de alojamientos
     * @throws DatosIncompletosException
     * @throws BuscarCiudadDeterminadaException
     */
    public ArrayList<DTO.DTOCiudadDeterminada> listaCiudadDeterminadaDTO(String ciudad) throws DatosIncompletosException, BuscarCiudadDeterminadaException {
        if (ciudad == null) {
            throw new DatosIncompletosException();
        }
        ArrayList<DTO.DTOCiudadDeterminada> lista = dao.BuscarCiudadDeterminadaDTO(ciudad);
        if (lista == null) {
            throw new BuscarCiudadDeterminadaException();
        }
        return lista;
    }

    /**
     * Metodo encargado de llenar elementos a la tabla
     *
     * @param ciudades
     * @return modelo de la tabla
     * @throws DatosIncompletosException
     * @throws BuscarCiudadDeterminadaException
     */
    public DefaultTableModel listarElementosCiudadDeterminadaDTO(String ciudades) throws DatosIncompletosException, BuscarCiudadDeterminadaException {
        ArrayList<DTO.DTOCiudadDeterminada> lista = listaCiudadDeterminadaDTO(ciudades);

        String nombreColumnas[] = {"IdReserva", "Fecha Reserva", "IdHabitacion", "Categoria", "Tipo", "Ciudad", "Cedula Cliente", "Nombre Completo", "Nivel De Estudio", "Estrato"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 10:
                        return true;
                    default:
                        return false;
                }
            }
        };

        for (DTO.DTOCiudadDeterminada ciudad : lista) {

            String fechareservacion = formato.format(ciudad.getFechareservacion());
            modelo.addRow(new Object[]{ciudad.getIdReserva(), fechareservacion, ciudad.getIdhabitacion(), ciudad.getCategoria(), ciudad.getTipo(), ciudad.getCiudad(), ciudad.getCedulaCliente(), ciudad.getNombreCompleto(), ciudad.getNivelEstudio(), ciudad.getEstrato()});

        }

        return modelo;
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
     * Metodo encargado de lista la consulta Ciudades por medio variable ciudad
     * de mayor a menor
     *
     * @param ciudad
     * @return lista de alojamientos
     * @throws DatosIncompletosException
     * @throws BuscarCiudadDeterminadaException
     */
    public ArrayList<DTO.DTOCiudadDeterminada> listaCiudadCiudadDeterminadaMayorDTO(String ciudad) throws DatosIncompletosException, BuscarCiudadDeterminadaException {
        if (ciudad == null) {
            throw new DatosIncompletosException();
        }
        ArrayList<DTO.DTOCiudadDeterminada> lista = dao.BuscarCiudadDeterminadaDTO(ciudad);
        if (lista == null) {
            throw new BuscarCiudadDeterminadaException();
        }
        return lista;
    }

    /**
     * Metodo encargado de llenar elementos a la tabla
     *
     * @param ciudades
     * @return modelo de la tabla
     * @throws DatosIncompletosException
     * @throws BuscarCiudadDeterminadaException
     */
    public DefaultTableModel listarElementosCiudadDeterminadaMayorDTO(String ciudades) throws DatosIncompletosException, BuscarCiudadDeterminadaException {
        ArrayList<DTO.DTOCiudadDeterminada> lista = listaCiudadCiudadDeterminadaMayorDTO(ciudades);

        String nombreColumnas[] = {"IdReserva", "Fecha Reserva", "IdHabitacion", "Categoria", "Tipo", "Ciudad", "Cedula Cliente", "Nombre Completo", "Nivel De Estudio", "Estrato"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 10:
                        return true;
                    default:
                        return false;
                }
            }
        };

        for (DTO.DTOCiudadDeterminada ciudad : lista) {

            String fechareservacion = formato.format(ciudad.getFechareservacion());
            modelo.addRow(new Object[]{ciudad.getIdReserva(), fechareservacion, ciudad.getIdhabitacion(), ciudad.getCategoria(), ciudad.getTipo(), ciudad.getCiudad(), ciudad.getCedulaCliente(), ciudad.getNombreCompleto(), ciudad.getNivelEstudio(), ciudad.getEstrato()});

        }

        return modelo;
    }
}
