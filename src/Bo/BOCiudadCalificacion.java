/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOCiudadCalificacion;
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
public class BOCiudadCalificacion {

    private IDAOCiudadCalificacion dao;
    private final DateFormat formato;

    public BOCiudadCalificacion() {
        dao = FactoryDAO.getFabrica().creaDAOCiudadCalificacion();
        formato = DateFormat.getDateInstance();
    }

    /**
     * Metodo encargado de lista la consulta Ciudades mas calificadas por medio
     * variable ciudad
     *
     * @param ciudad
     * @return lista de Alojamientos
     * @throws DatosIncompletosException
     * @throws BuscarCiudadDeterminadaException
     */
    public ArrayList<DTO.DTOCiudadCalificacion> listaCiudadCalificacionDTO(String ciudad) throws DatosIncompletosException, BuscarCiudadDeterminadaException {
        if (ciudad == null) {
            throw new DatosIncompletosException();
        }
        ArrayList<DTO.DTOCiudadCalificacion> lista = dao.BuscarCiudadCalificacionDTO(ciudad);
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
    public DefaultTableModel listarElementosCiudadCalificacionDTO(String ciudades) throws DatosIncompletosException, BuscarCiudadDeterminadaException {
        ArrayList<DTO.DTOCiudadCalificacion> lista = listaCiudadCalificacionDTO(ciudades);

        String nombreColumnas[] = {"IdReserva", "Fecha Reserva", "IdHabitacion", "Categoria", "Tipo", "Ciudad", "Calificacion"};
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

        for (DTO.DTOCiudadCalificacion ciudad : lista) {

            String fechareservacion = formato.format(ciudad.getFechareservacion());
            modelo.addRow(new Object[]{ciudad.getIdReserva(), fechareservacion, ciudad.getIdhabitacion(), ciudad.getCategoria(), ciudad.getTipo(), ciudad.getCiudad(), ciudad.getCalificacion()});

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
}
