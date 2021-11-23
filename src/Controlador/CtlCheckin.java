/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOCheckIn;
import Excepcion.BuscarHospedajeException;
import Excepcion.CargarImagenException;
import Excepcion.DatosIncompletosException;
import Excepcion.DiaException;
import Excepcion.GuardarCuentaPersonalException;
import Excepcion.anoException;
import Excepcion.horaException;
import Excepcion.mesException;
import Excepcion.modificarReservaCheckIn;
import Modelo.Hospedaje;
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
public class CtlCheckin {

    BOCheckIn bo;

    public CtlCheckin() {
        bo = new BOCheckIn();
    }

    public Hospedaje buscarHospedaje(int idReserva) throws BuscarHospedajeException {
        return bo.buscarHospedaje(idReserva);
    }

    public ReservaHospedaje buscarReserva(int idReserva) {
        return bo.buscarReserva(idReserva);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public DefaultComboBoxModel llenarComboBox(int idHuesped) {
        return bo.llenarComboBox(idHuesped);
    }

    public BufferedImage cargarImagenBufferedImage(byte[] bytes) throws CargarImagenException {
        return bo.cargarImagenBufferedImage(bytes);
    }

    public void realizarCheckIn(Date fechaHoy, ReservaHospedaje reserva, int idhuesped) throws anoException, mesException, DiaException, horaException, DatosIncompletosException, modificarReservaCheckIn, GuardarCuentaPersonalException {
        bo.realizarCheckIn(fechaHoy, reserva, idhuesped);
    }
}
