/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOReserva;
import Excepcion.DatosIncompletosException;
import Excepcion.DayException;
import Excepcion.FechaException;
import Excepcion.GuardarReservaException;
import Excepcion.ReservaActivaException;
import Excepcion.UsuarioMultadoException;
import Excepcion.anoException;
import Excepcion.mesException;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class CtlReserva {

    BOReserva bo;

    public CtlReserva() {
        bo = new BOReserva();
    }

    public void guardarReserva(int idHuesped, int idHabitacion, Date fechaHoraReserva, Date fechaHoraLlegada, Date fechaHoraSalida) throws DatosIncompletosException, UsuarioMultadoException, ReservaActivaException, GuardarReservaException, anoException, mesException, FechaException, DayException {
        bo.guardarReserva(idHuesped, idHabitacion, fechaHoraReserva, fechaHoraLlegada, fechaHoraSalida);
    }

    public String obtenerStringDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);
    }
}
