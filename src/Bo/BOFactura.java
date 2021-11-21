/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DTO.DTOReservaActiva;
import Definiciones.IDAOHospedaje;
import Definiciones.IDAOMiCuenta;
import Definiciones.IDAOReserva;
import Excepcion.BuscarHuespedException;
import Excepcion.DatosIncompletosException;
import Excepcion.FacturacionException;
import Excepcion.ModificarCuentaPersonalException;
import Fabrica.FactoryDAO;
import Modelo.CuentaPersonal;
import Modelo.Hospedaje;
import Modelo.Huesped;
import Modelo.ReservaHospedaje;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BOFactura {

    private IDAOMiCuenta dao;
    private final DateFormat formato;
    private final IDAOHospedaje daoHospedaje;
    private final IDAOReserva daoReserva;
    private final BoHuesped boHuesped;
    private final BOReserva BoReserva;
    private final BOCuentaPersonal boCuentaPersona;

    public BOFactura() {
        dao = FactoryDAO.getFabrica().crearDAOMiCuenta();
        daoHospedaje = FactoryDAO.getFabrica().crearDAOHospedaje();
        daoReserva = FactoryDAO.getFabrica().crearDAOReserva();
        boHuesped = new BoHuesped();
        formato = DateFormat.getDateInstance();
        BoReserva = new BOReserva();
        boCuentaPersona = new BOCuentaPersonal();
    }

    public Huesped buscarHuesped(String cedula) throws BuscarHuespedException, DatosIncompletosException {
        return boHuesped.buscarHuesped(cedula);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public DTO.DTOReservaActiva buscarReserva(int idReserva, int idHuesped) {
        ArrayList<DTOReservaActiva> listasreserva = listaReservas(idHuesped);
        DTOReservaActiva reserva = new DTOReservaActiva();
        for (int i = 0; i < listasreserva.size(); i++) {
            if (listasreserva.get(i).getIdreserva() == idReserva) {
                if (listasreserva.get(i).getEstado().equalsIgnoreCase("CheckIn")) {
                    return listasreserva.get(i);
                }

            }
        }
        return reserva;
    }

    public ArrayList<DTO.DTOReservaActiva> listaReservas(int idHuesped) {

        return dao.BuscarReservaActiva(idHuesped);

    }

    public ArrayList<Hospedaje> listaHabitacion() {
        return daoHospedaje.listarHospedaje();
    }

    public ArrayList<ReservaHospedaje> listaReservas() {
        return daoReserva.listarReserva();
    }

    public String generarValorHabitacion(int idReserva) {
        double valorTotal;

        double valorhabitacion = valorHabitacion(idReserva);

        valorTotal = valorhabitacion;
        return String.valueOf(valorTotal);
    }

    public String generarValorLimpieza(int idReserva) {
        double valorTotal;

        double valorhabitacion = valorHabitacion(idReserva);
        double limpieza = valorhabitacion * 0.05;
        valorTotal = limpieza;
        return String.valueOf(valorTotal);
    }

    public String generarValorPlataforma(int idReserva) {
        double valorTotal;

        double valorhabitacion = valorHabitacion(idReserva);
        double plataforma = valorhabitacion * 0.15;
        valorTotal = plataforma;
        return String.valueOf(valorTotal);
    }

    public String generarValorTotal(int idReserva) {
        double valorTotal;

        double valorhabitacion = valorHabitacion(idReserva);

        double limpieza = valorhabitacion * 0.05;
        double plataforma = valorhabitacion * 0.15;
        valorTotal = valorhabitacion + limpieza + plataforma;
        return String.valueOf(valorTotal);
    }

    public ReservaHospedaje buscarReservaId(int idReserva) throws DatosIncompletosException {
        ArrayList<ReservaHospedaje> listareserva = listaReservas();
        ReservaHospedaje reserva = new ReservaHospedaje();
        if (idReserva == 0) {
            throw new DatosIncompletosException();
        } else {

            for (int i = 0; i < listareserva.size(); i++) {
                if (listareserva.get(i).getId() == idReserva) {
                    reserva = listareserva.get(i);
                    break;
                }
            }
        }

        return reserva;
    }

    public double valorHabitacion(int idReserva) {

        ArrayList<ReservaHospedaje> listareserva = listaReservas();
        ArrayList<Hospedaje> listahabitacion = listaHabitacion();
        for (int i = 0; i < listareserva.size(); i++) {
            if (listareserva.get(i).getId() == idReserva) {
                Calendar calLlegada = new GregorianCalendar();
                calLlegada.setTime(listareserva.get(i).getFechaHoraCheckIn());
                int yearHoraFechaLlegada = calLlegada.get(Calendar.YEAR);
                int monthHoraFechaLlegada = calLlegada.get(Calendar.MONTH);
                int dayHoraFechaLlegada = calLlegada.get(Calendar.DAY_OF_MONTH);

                Calendar calSalida = new GregorianCalendar();
                calSalida.setTime(listareserva.get(i).getFechaHoraCheckOut());
                int yearFechaHoraSalida = calSalida.get(Calendar.YEAR);
                int monthFechaHoraSalida = calSalida.get(Calendar.MONTH);
                int dayFechaHoraSalida = calSalida.get(Calendar.DAY_OF_MONTH);

                int cantidadnoches = dayFechaHoraSalida - dayHoraFechaLlegada;
                double valornoche = 0;
                for (int j = 0; j < listahabitacion.size(); j++) {
                    if (listahabitacion.get(j).getId() == listareserva.get(i).getIdHabitacion()) {
                        valornoche = Double.parseDouble(listahabitacion.get(j).getValorPorNoche());
                        break;
                    }
                }
                return cantidadnoches * valornoche;

            }
        }
        return 0;
    }

    public DefaultTableModel listarElementosReservacion(int idHuesped) {
        ArrayList<DTO.DTOReservaActiva> lista = listaReservas(idHuesped);
        ArrayList<Hospedaje> listaHabitaciones = listaHabitacion();
        String nombreColumnas[] = {"Id Reserva", "Fecha Reservacion", "Habitacion", "Estado", "Valor"};
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
        for (DTO.DTOReservaActiva reserva : lista) {
            if (reserva.getEstado().equalsIgnoreCase("CheckOut")) {
                String fecha = formato.format(reserva.getFechareservacion());
                for (Hospedaje habitacion : listaHabitaciones) {

                    if (reserva.getIdhabitacion() == habitacion.getId()) {

                        habitaciones = habitacion.getTipo();

                        break;
                    }

                }
                modelo.addRow(new Object[]{reserva.getIdreserva(), fecha, habitaciones, reserva.getEstado(), reserva.getValor()});
            }

        }

        return modelo;
    }

    public void pagar(ReservaHospedaje reserva, int idHuesped, String valorpagado, String cuentaBancaria) throws DatosIncompletosException, FacturacionException, ModificarCuentaPersonalException {
        if (cuentaBancaria == null) {
            throw new DatosIncompletosException();
        } else {
            CuentaPersonal cuentapersonal = new CuentaPersonal(0, 0, reserva.getId(), cuentaBancaria, "Pagada", valorpagado);

            if (BoReserva.modificarReserva("Pagada", "Inactivo", reserva.getId())) {
                boCuentaPersona.modificarCuentaPersonal(cuentapersonal);
            } else {
                throw new FacturacionException();
            }
        }
    }
}
