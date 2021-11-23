/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOCheckOut;
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
import Modelo.Hospedaje;
import Modelo.Huesped;
import Modelo.ReservaHospedaje;
import java.awt.image.BufferedImage;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

/**
 *
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 */
public class CtlCheckOut {

    private final BOCheckOut bo;

    public CtlCheckOut() {
        bo = new BOCheckOut();
    }

    public Huesped buscarHuesped(String cedula) throws BuscarHuespedException, DatosIncompletosException {
        return bo.buscarHuesped(cedula);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public Hospedaje buscarHospedaje(int idReserva) throws BuscarHospedajeException {
        return bo.buscarHabitacion(idReserva);
    }

    public BufferedImage cargarImagenBufferedImage(byte[] bytes) throws CargarImagenException {
        return bo.cargarImagenBufferedImage(bytes);
    }

    public ReservaHospedaje buscarReserva(int idReserva) {
        return bo.buscarReserva(idReserva);
    }

    public DefaultComboBoxModel llenarComboBox(int idHuesped) {
        return bo.llenarComboBox(idHuesped);
    }

    public void realizarCheckOut(Date fechaHoy, ReservaHospedaje reserva, int idHuesped) throws anoException, mesException, DiaException, horaException, DatosIncompletosException, modificarReservaCheckIn, GuardarCuentaPersonalException, ModificarCuentaPersonalException, DayException {
        bo.realizarCheckOut(fechaHoy, reserva, idHuesped);
    }
}
