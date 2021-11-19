/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Dao.DAOCuentaPersonal;
import Dao.DAOHospedaje;
import Dao.DAOHuesped;
import Definiciones.IDAOReserva;
import Excepcion.DatosIncompletosException;
import Excepcion.DayException;
import Excepcion.FechaException;
import Excepcion.GuardarCuentaPersonalException;
import Excepcion.GuardarReservaException;
import Excepcion.ReservaActivaException;
import Excepcion.UsuarioMultadoException;
import Excepcion.anoException;
import Excepcion.mesException;
import Fabrica.FactoryDAO;
import Modelo.CuentaPersonal;
import Modelo.Huesped;
import Modelo.ReservaHospedaje;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class BOReserva {

    private final IDAOReserva daoReserva;
    private final DAOHuesped daoHuesped;
    private final DAOHospedaje daoHospedaje;
    private final DAOCuentaPersonal daoCuentaPersonal;

    public BOReserva() {
        daoReserva = FactoryDAO.getFabrica().crearDAOReserva();
        daoHuesped = new DAOHuesped();
        daoHospedaje = new DAOHospedaje();
        daoCuentaPersonal = new DAOCuentaPersonal();
    }

    public void validarDatos(Date fechaHoraReserva, Date fechaHoraLlegada, Date fechaHoraSalida) throws DatosIncompletosException {
        if (fechaHoraReserva == null || fechaHoraLlegada == null || fechaHoraSalida == null) {
            throw new DatosIncompletosException();
        }
    }

    public boolean modificarReserva(String estado, String estadoServicio, int idReserva) throws DatosIncompletosException {
        return daoReserva.modificarReserva(estado, estadoServicio, idReserva);
    }

    public void guardarReserva(int idHuesped, int idHabitacion, Date fechaHoraReserva, Date fechaHoraLlegada, Date fechaHoraSalida) throws DatosIncompletosException, UsuarioMultadoException, ReservaActivaException, GuardarReservaException, anoException, mesException, FechaException, DayException, GuardarCuentaPersonalException {
        validarDatos(fechaHoraReserva, fechaHoraLlegada, fechaHoraSalida);
        fechaHoraLlegada.setHours(0);
        fechaHoraLlegada.setMinutes(0);
        fechaHoraLlegada.setSeconds(0);
        fechaHoraSalida.setHours(0);
        fechaHoraSalida.setMinutes(0);
        fechaHoraSalida.setSeconds(0);
        if (verificarTipoUsuario(idHuesped).equalsIgnoreCase("regular")) {
            verificarSiTieneReserva(idHuesped, idHabitacion);
        } else {
            verificarSiTieneDosReserva(idHuesped, idHabitacion);
        }
        verificarFecha(fechaHoraReserva, fechaHoraLlegada, fechaHoraSalida, idHabitacion);
        ReservaHospedaje reserva = new ReservaHospedaje(0, idHuesped, idHabitacion, fechaHoraReserva, fechaHoraLlegada, fechaHoraSalida, fechaHoraLlegada, fechaHoraSalida, "Prestado", "inactivo");

        if (!daoReserva.guardarReserva(reserva)) {
            throw new GuardarReservaException();

        }

    }

    private String verificarTipoUsuario(int idHuesped) {
        ArrayList<Huesped> ListaHuesped = daoHuesped.listarHuesped();

        for (Huesped huesped : ListaHuesped) {
            if (huesped.getId() == idHuesped) {
                return huesped.getTipo();
            }
        }

        return null;

    }

    public ArrayList<ReservaHospedaje> listarReserva() {
        return daoReserva.listarReserva();
    }

    private void verificarSiTieneReserva(int idHuesped, int idHabitacion) throws UsuarioMultadoException, ReservaActivaException {

        ArrayList<ReservaHospedaje> lista = listarReserva();//todas las reservas
        if (!lista.isEmpty()) {
            for (ReservaHospedaje reservaHabitacion : lista) {
                if (reservaHabitacion.getIdHuesped() == idHuesped && reservaHabitacion.getIdHabitacion() == idHabitacion) {
                    if (reservaHabitacion.getEstado().equalsIgnoreCase("Multado")) {
                        throw new UsuarioMultadoException();
                    } else if (reservaHabitacion.getEstado().equalsIgnoreCase("Prestado")) {
                        throw new ReservaActivaException();
                    } else if (reservaHabitacion.getEstado().equalsIgnoreCase("CheckIn")) {
                        throw new ReservaActivaException();
                    }
                }
            }
        }

    }

    private void verificarSiTieneDosReserva(int idHuesped, int idHabitacion) throws UsuarioMultadoException, ReservaActivaException {

        ArrayList<ReservaHospedaje> lista = listarReserva();//todas las reservas
        int contador = 0;
        if (!lista.isEmpty()) {
            for (ReservaHospedaje reservaHabitacion : lista) {
                if (reservaHabitacion.getIdHuesped() == idHuesped && reservaHabitacion.getIdHabitacion() == idHabitacion) {
                    if (reservaHabitacion.getEstado().equalsIgnoreCase("Multado")) {
                        throw new UsuarioMultadoException();
                    } else if (reservaHabitacion.getEstado().equalsIgnoreCase("Prestado")) {
                        contador++;
                        if (contador == 2) {
                            throw new ReservaActivaException();
                        }
                    } else if (reservaHabitacion.getEstado().equalsIgnoreCase("CheckIn")) {
                        contador++;
                        if (contador == 2) {
                            throw new ReservaActivaException();
                        }
                    }
                }

            }
        }

    }

    /**
     * Metodo para verificar la validez de la fecha
     *
     * @param horaFechaLlegada fecha de llegada de la reserva
     * @param fechaHoraSalida fecha de salida de la reserva
     * @param fechaHoraReserva fecha del dia hoy
     */
    private void verificarFecha(Date fechaHoraReserva, Date horaFechaLlegada, Date fechaHoraSalida, int idHabitacion) throws anoException, mesException, FechaException, DayException {
        Calendar calLlegada = new GregorianCalendar();
        calLlegada.setTime(horaFechaLlegada);
        int yearHoraFechaLlegada = calLlegada.get(Calendar.YEAR);
        int monthHoraFechaLlegada = calLlegada.get(Calendar.MONTH);
        int dayHoraFechaLlegada = calLlegada.get(Calendar.DAY_OF_MONTH);

        Calendar calSalida = new GregorianCalendar();
        calSalida.setTime(fechaHoraSalida);
        int yearFechaHoraSalida = calSalida.get(Calendar.YEAR);
        int monthFechaHoraSalida = calSalida.get(Calendar.MONTH);
        int dayFechaHoraSalida = calSalida.get(Calendar.DAY_OF_MONTH);

        Calendar calHoy = new GregorianCalendar();
        calHoy.setTime(fechaHoraReserva);
        int yearFechaHoraReserva = calHoy.get(Calendar.YEAR);
        int monthFechaHoraReserva = calHoy.get(Calendar.MONTH);
        int dayFechaHoraReserva = calHoy.get(Calendar.DAY_OF_MONTH);

        if (yearFechaHoraReserva == yearHoraFechaLlegada && yearFechaHoraReserva == yearFechaHoraSalida) {// si es el mismo año
            if (monthFechaHoraReserva == monthHoraFechaLlegada && monthFechaHoraReserva == monthFechaHoraSalida) {// si es el mismo mes

                if (dayFechaHoraReserva == dayHoraFechaLlegada) {
                    throw new DayException();
                } else if (dayFechaHoraSalida <= dayHoraFechaLlegada) {
                    throw new DayException();
                } else {
                    ArrayList<ReservaHospedaje> lista = listarReserva();//todas las reservas
                    if (!lista.isEmpty()) {
                        for (ReservaHospedaje reservaHabitacion : lista) {
                            if (idHabitacion == reservaHabitacion.getIdHabitacion()) {

                                if (reservaHabitacion.getEstado().equals("Prestado") || reservaHabitacion.getEstado().equalsIgnoreCase("CheckIn")) {

                                    Calendar calCheckIn = new GregorianCalendar();
                                    calCheckIn.setTime(reservaHabitacion.getFechaHoraCheckIn());
                                    int yearCheckIn = calCheckIn.get(Calendar.YEAR);
                                    int monthCheckIn = calCheckIn.get(Calendar.MONTH);
                                    int dayCheckIn = calCheckIn.get(Calendar.DAY_OF_MONTH);

                                    Calendar calCheckOut = new GregorianCalendar();
                                    calCheckOut.setTime(reservaHabitacion.getFechaHoraCheckOut());
                                    int yearCheckOut = calCheckOut.get(Calendar.YEAR);
                                    int monthCheckOut = calCheckOut.get(Calendar.MONTH);
                                    int dayCheckOut = calCheckOut.get(Calendar.DAY_OF_MONTH);

                                    if (yearFechaHoraReserva == yearCheckIn && yearFechaHoraReserva == yearCheckOut) {// si es el mismo año
                                        if (monthFechaHoraReserva == monthCheckIn && monthFechaHoraReserva == monthCheckOut) {// si es el mismo mes

                                            if (dayHoraFechaLlegada > dayCheckIn) {

                                            } else {
                                                throw new FechaException();
                                            }

                                        }

                                    }
                                }
                            }

                        }

                    }

                }

            } else {
                throw new mesException();
            }
        } else {
            throw new anoException();
        }

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
        if (informacion.equals("Seleccione habitacion")) {
            informacion = null;
        }
        return informacion;
    }

}
