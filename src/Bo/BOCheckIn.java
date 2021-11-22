/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Excepcion.BuscarHospedajeException;
import Excepcion.CargarImagenException;
import Excepcion.DatosIncompletosException;
import Excepcion.DiaException;
import Excepcion.GuardarCuentaPersonalException;
import Excepcion.anoException;
import Excepcion.horaException;
import Excepcion.mesException;
import Excepcion.modificarReservaCheckIn;
import Modelo.CuentaPersonal;
import Modelo.Hospedaje;
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
import javax.swing.JTextField;

/**
 *
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 */
public class BOCheckIn {

    private final BoHuesped BoHuesped;
    private final BOReserva BoReserva;
    private final BOHospedaje BoHospedaje;
    private final BOCuentaPersonal BoCuentaPersonal;
    private ArrayList<ReservaHospedaje> listaReserva;

    public BOCheckIn() {
        BoHuesped = new BoHuesped();
        BoReserva = new BOReserva();
        BoHospedaje = new BOHospedaje();
        BoCuentaPersonal = new BOCuentaPersonal();
        listaReserva = new ArrayList<>();
    }

    /**
     * Metodo que lista las reservas
     */
    private void listarReservas() {

        listaReserva = BoReserva.listarReserva();
    }

    /**
     * Metodo encargado de buscar hospedaje
     *
     * @param idReserva
     * @return
     * @throws BuscarHospedajeException
     */
    public Hospedaje buscarHospedaje(int idReserva) throws BuscarHospedajeException {
        ReservaHospedaje reserva = null;

        for (ReservaHospedaje reservaHospedaje : listaReserva) {
            if (reservaHospedaje.getId() == idReserva) {
                reserva = reservaHospedaje;
                break;
            }
        }
        if (reserva == null) {
            throw new BuscarHospedajeException();
        }
        ArrayList<Hospedaje> listaHospedaje = BoHospedaje.listarHospedajes();

        for (Hospedaje hospedaje : listaHospedaje) {
            if (hospedaje.getId() == reserva.getIdHabitacion()) {
                return hospedaje;
            }
        }
        throw new BuscarHospedajeException();
    }

    /**
     * Metodo encargado de buscar una rerserva por medio del id
     *
     * @param idReserva
     * @return
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
     *
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
     * Metodo encargado de llenar los comboBox Reserva respecto el idHuesped
     *
     * @param idHuesped
     * @return
     */
    public DefaultComboBoxModel llenarComboBox(int idHuesped) {
        listarReservas();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        listaReserva.stream().filter((reserva) -> (reserva.getEstado().equalsIgnoreCase("Prestado"))).filter((reserva) -> (reserva.getIdHuesped() == idHuesped)).forEachOrdered((reserva) -> {
            modelo.addElement(reserva.getId());
        });
        return modelo;
    }

    /**
     * Metodo encargado de realizar el CheckIn
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
     */
    public void realizarCheckIn(Date fechaHoy, ReservaHospedaje reserva, int idHuesped) throws anoException, mesException, DiaException, horaException, DatosIncompletosException, modificarReservaCheckIn, GuardarCuentaPersonalException {
// int idHuesped, int idReservaHabitacion, String estado, String valorApagar
        Calendar calLlegada = new GregorianCalendar();
        calLlegada.setTime(reserva.getFechaHoraCheckIn());
        int yearHoraFechaLlegada = calLlegada.get(Calendar.YEAR);
        int monthHoraFechaLlegada = calLlegada.get(Calendar.MONTH);
        int dayHoraFechaLlegada = calLlegada.get(Calendar.DAY_OF_MONTH);

        Calendar calHoy = new GregorianCalendar();
        calHoy.setTime(fechaHoy);
        int yearFechaHoraReserva = calHoy.get(Calendar.YEAR);
        int monthFechaHoraReserva = calHoy.get(Calendar.MONTH);
        int dayFechaHoraReserva = calHoy.get(Calendar.DAY_OF_MONTH);

        int hora = calHoy.get(Calendar.HOUR_OF_DAY);

        int minutos = calHoy.get(Calendar.MINUTE);
        int segundos = calHoy.get(Calendar.SECOND);

        if (yearFechaHoraReserva == yearHoraFechaLlegada) {// si es el mismo año
            if (monthFechaHoraReserva == monthHoraFechaLlegada) {// si es el mismo mes

                if (dayHoraFechaLlegada == dayFechaHoraReserva) {
                    if (hora < 14) {
                        throw new horaException();
                    }
                    if (hora >= 14 && hora <= 16) {

                        if (BoReserva.modificarReserva("CheckIn", "Activo", reserva.getId())) {
                            CuentaPersonal cuentaPersonal = new CuentaPersonal(0, reserva.getIdHuesped(), reserva.getId(), "0", "CheckIn", "0");
                            BoCuentaPersonal.guardarCuentaPersonal(cuentaPersonal);

                        } else {
                            throw new modificarReservaCheckIn();
                        }

                    } else {

                        throw new modificarReservaCheckIn();

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
