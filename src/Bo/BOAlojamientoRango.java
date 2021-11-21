/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOAlojamientoRango;
import Excepcion.BuscarCiudadDeterminadaException;
import Excepcion.RangoValoresException;
import Fabrica.FactoryDAO;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BOAlojamientoRango {

    private IDAOAlojamientoRango dao;
    private final DateFormat formato;

    public BOAlojamientoRango() {
        dao = FactoryDAO.getFabrica().crearDAOAlojamientoRango();
        formato = DateFormat.getDateInstance();
    }

    public ArrayList<DTO.DTOAlojamientoRango> listaAlojamientoRangoDTO(int valorinicial, int valorfinal) throws BuscarCiudadDeterminadaException, RangoValoresException {
        if (valorinicial > valorfinal) {
            throw new RangoValoresException();
        }
        ArrayList<DTO.DTOAlojamientoRango> lista = dao.BuscarAlojamientoRangoDTO(valorinicial, valorfinal);
        if (lista == null) {
            throw new BuscarCiudadDeterminadaException();
        }
        return lista;
    }

    public DefaultTableModel listarElementosAlojamientoRangoDTO(int valorinicial, int valorfinal) throws BuscarCiudadDeterminadaException, RangoValoresException {
        ArrayList<DTO.DTOAlojamientoRango> lista = listaAlojamientoRangoDTO(valorinicial, valorfinal);

        String nombreColumnas[] = {"IdReserva", "Fecha Reserva", "IdHabitacion", "Categoria", "Tipo", "Ciudad", "Valor A Pagar"};
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

        for (DTO.DTOAlojamientoRango ciudad : lista) {

            String fechareservacion = formato.format(ciudad.getFechareservacion());
            modelo.addRow(new Object[]{ciudad.getIdReserva(), fechareservacion, ciudad.getIdhabitacion(), ciudad.getCategoria(), ciudad.getTipo(), ciudad.getCiudad(), ciudad.getRango()});

        }

        return modelo;
    }
}
