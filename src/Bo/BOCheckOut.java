/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Excepcion.BuscarHospedajeException;
import Excepcion.BuscarHuespedException;
import Excepcion.CargarImagenException;
import Excepcion.DatosIncompletosException;
import Excepcion.DayException;
import Excepcion.DiaException;
import Excepcion.GuardarCuentaPersonalException;
import Excepcion.ModificarCuentaPersonalException;
import Excepcion.anoException;
import Excepcion.horaException;
import Excepcion.mesException;
import Excepcion.modificarReservaCheckIn;
import Modelo.CuentaPersonal;
import Modelo.Hospedaje;
import Modelo.Huesped;
import Modelo.ReservaHospedaje;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 */
public class BOCheckOut {

    private final BoHuesped BoHuesped;
    private final BOReserva BoReserva;
    private final BOHospedaje boHabitacion;
    private final BOCuentaPersonal boCuentaPersona;
    private ArrayList<ReservaHospedaje> listaReserva;

    public BOCheckOut() {
        BoHuesped = new BoHuesped();
        BoReserva = new BOReserva();
        boHabitacion = new BOHospedaje();
        boCuentaPersona = new BOCuentaPersonal();
        listaReserva = new ArrayList<>();

    }

    /**
     * Metodo que lista las reservas
     */
    private void listarReservas() {

        listaReserva = BoReserva.listarReserva();
    }

    /**
     * Metodo encargado de buscar huesped por medio de la cedula
     *
     * @param cedula
     * @return objeto Huesped
     * @throws BuscarHuespedException
     * @throws DatosIncompletosException
     */
    public Huesped buscarHuesped(String cedula) throws BuscarHuespedException, DatosIncompletosException {
        return BoHuesped.buscarHuesped(cedula);
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
     * Metodo encargado de buscar Reserva por medio del id
     *
     * @param idReserva
     * @return objeto ReservaHospedaje
     */
    public ReservaHospedaje buscarReserva(int idReserva) {
        listarReservas();
        for (ReservaHospedaje reservaHabitacion : listaReserva) {
            if (reservaHabitacion.getId() == idReserva) {
                return reservaHabitacion;

            }
        }
        return null;
    }

    /**
     * Metodo encargado de Buscar Habitacion
     *
     * @param idReserva
     * @return objeto Hospedaje
     * @throws BuscarHospedajeException
     */
    public Hospedaje buscarHabitacion(int idReserva) throws BuscarHospedajeException {

        ReservaHospedaje reserva = null;

        for (ReservaHospedaje reservaHabitacion : listaReserva) {
            if (reservaHabitacion.getId() == idReserva) {
                reserva = reservaHabitacion;
                break;
            }
        }
        if (reserva == null) {
            throw new BuscarHospedajeException();
        }

        ArrayList<Hospedaje> listaHabitacion = boHabitacion.listarHospedajes();

        for (Hospedaje habitacion : listaHabitacion) {
            if (habitacion.getId() == reserva.getIdHabitacion()) {
                return habitacion;
            }
        }
        throw new BuscarHospedajeException();

    }

    /**
     * Metodo encargado de llenar ComboBox de la reserva por medio del idhuesped
     *
     * @param idHuesped
     * @return model ComboBox
     */
    public DefaultComboBoxModel llenarComboBox(int idHuesped) {
        listarReservas();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        listaReserva.stream().filter((reserva) -> (reserva.getEstado().equalsIgnoreCase("CheckIn"))).filter((reserva) -> (reserva.getIdHuesped() == idHuesped)).forEachOrdered((reserva) -> {
            modelo.addElement(reserva.getId());
        });
        return modelo;
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
     * Metodo encargado realizar CheckOut
     *
     * @param fechaHoy
     * @param reserva
     * @param idHuesped
     * @throws anoException
     * @throws mesException
     * @throws DiaException
     * @throws horaException
     * @throws DatosIncompletosException
     * @throws modificarReservaCheckIn
     * @throws GuardarCuentaPersonalException
     * @throws ModificarCuentaPersonalException
     * @throws DayException
     */
    public void realizarCheckOut(Date fechaHoy, ReservaHospedaje reserva, int idHuesped) throws anoException, mesException, DiaException, horaException, DatosIncompletosException, modificarReservaCheckIn, GuardarCuentaPersonalException, ModificarCuentaPersonalException, DayException {
// int idHuesped, int idReservaHabitacion, String estado, String valorApagar
        Calendar calLlegada = new GregorianCalendar();
        calLlegada.setTime(reserva.getFechaHoraLlegada());
        int yearHoraFechaLlegada = calLlegada.get(Calendar.YEAR);
        int monthHoraFechaLlegada = calLlegada.get(Calendar.MONTH);
        int dayHoraFechaLlegada = calLlegada.get(Calendar.DAY_OF_MONTH);

        Calendar calSalida = new GregorianCalendar();
        calSalida.setTime(reserva.getFechaHoraSalida());
        int yearFechaHoraSalida = calSalida.get(Calendar.YEAR);
        int monthFechaHoraSalida = calSalida.get(Calendar.MONTH);
        int dayFechaHoraSalida = calSalida.get(Calendar.DAY_OF_MONTH);

        Calendar calHoy = new GregorianCalendar();
        calHoy.setTime(fechaHoy);
        int yearFechaHoraReserva = calHoy.get(Calendar.YEAR);
        int monthFechaHoraReserva = calHoy.get(Calendar.MONTH);
        int dayHoy = calHoy.get(Calendar.DAY_OF_MONTH);

        int hora = calHoy.get(Calendar.HOUR_OF_DAY);

        if (yearFechaHoraReserva == yearHoraFechaLlegada) {// si es el mismo año
            if (monthFechaHoraReserva == monthHoraFechaLlegada) {// si es el mismo mes
                if (dayHoy == dayHoraFechaLlegada) {
                    throw new DayException();
                }
                if (dayHoy >= dayHoraFechaLlegada) {
                    JOptionPane.showMessageDialog(null, "Entra");
                    if (hora >= 10 && hora <= 12) {
                        JOptionPane.showMessageDialog(null, "Entra hora");
                        CuentaPersonal cuentaPersonal = new CuentaPersonal(0, 0, reserva.getId(), "", "CheckOut", "0");
                        if (BoReserva.modificarReserva("CheckOut", "Inactivo", reserva.getId())) {
                            boCuentaPersona.modificarCuentaPersonal(cuentaPersonal);

                        } else {
                            throw new modificarReservaCheckIn();
                        }

                    } else {
                        throw new horaException();
                    }

                } else {
                    throw new DiaException();
                }

            } else {
                throw new mesException();
            }
        } else {
            throw new anoException();
        }

    }

}
