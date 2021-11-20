/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHospedaje;
import Definiciones.IDAOMiCuenta;
import Definiciones.IDAOReserva;
import Fabrica.FactoryDAO;
import Modelo.Hospedaje;
import Modelo.ReservaHospedaje;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BOMiCuenta {

    private IDAOMiCuenta dao;
    private final DateFormat formato;
    private final IDAOHospedaje daoHospedaje;
    private final IDAOReserva daoReserva;

    public BOMiCuenta() {
        dao = FactoryDAO.getFabrica().crearDAOMiCuenta();
        daoHospedaje = FactoryDAO.getFabrica().crearDAOHospedaje();
        daoReserva = FactoryDAO.getFabrica().crearDAOReserva();
        formato = DateFormat.getDateInstance();
    }

    public ArrayList<ReservaHospedaje> listareservas() {
        return daoReserva.listarReserva();
    }

    public DefaultTableModel listarElementosReservacionInactiva(int idHuesped) {
        ArrayList<ReservaHospedaje> lista = listareservas();
        ArrayList<Hospedaje> listaHabitaciones = listaHabitacion();
        String nombreColumnas[] = {"Id Reserva", "Fecha Reservacion", "Habitacion", "Estado", "Estado Servicio"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 5:
                        return true;
                    default:
                        return false;
                }
            }
        };
        String habitaciones = "";
        for (ReservaHospedaje reserva : lista) {
            if (reserva.getEstado().equalsIgnoreCase("Prestado") && reserva.getIdHuesped() == idHuesped) {
                String fecha = formato.format(reserva.getFechaHoraReserva());
                for (Hospedaje habitacion : listaHabitaciones) {

                    if (reserva.getIdHabitacion() == habitacion.getId()) {

                        habitaciones = habitacion.getTipo();

                        break;
                    }

                }
                modelo.addRow(new Object[]{reserva.getId(), fecha, habitaciones, reserva.getEstado(), reserva.getEstadoServicio()});
            }

        }

        return modelo;
    }

    public ArrayList<Hospedaje> listaHabitacion() {
        return daoHospedaje.listarHospedaje();
    }
}
