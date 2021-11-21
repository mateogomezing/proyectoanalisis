/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOFactura;
import Excepcion.BuscarHuespedException;
import Excepcion.DatosIncompletosException;
import Excepcion.FacturacionException;
import Excepcion.ModificarCuentaPersonalException;
import Modelo.Huesped;
import Modelo.ReservaHospedaje;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlFactura {

    BOFactura bo;

    public CtlFactura() {
        bo = new BOFactura();
    }

    public Huesped buscarHuesped(String cedula) throws BuscarHuespedException, DatosIncompletosException {
        return bo.buscarHuesped(cedula);
    }

    public DTO.DTOReservaActiva buscarReservaActiva(int idReserva, int idHuesped) {
        return bo.buscarReserva(idReserva, idHuesped);
    }

    public ReservaHospedaje buscarReservaId(int idReserva) throws DatosIncompletosException {
        return bo.buscarReservaId(idReserva);
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public DefaultTableModel listaElementosReserva(int idhuesped) {
        return bo.listarElementosReservacion(idhuesped);
    }

    public String generarValorHabitacion(int idReserva) {
        return bo.generarValorHabitacion(idReserva);
    }

    public String generarValorLimpieza(int idReserva) {
        return bo.generarValorLimpieza(idReserva);
    }

    public String generarValorPlataforma(int idReserva) {
        return bo.generarValorPlataforma(idReserva);
    }

    public String genararValorTotal(int idReserva) {
        return bo.generarValorTotal(idReserva);
    }

    public void pagar(ReservaHospedaje reserva, int idHuesped, String valorpagado, String cuentaBancaria) throws DatosIncompletosException, FacturacionException, ModificarCuentaPersonalException {
        bo.pagar(reserva, idHuesped, valorpagado, cuentaBancaria);
    }
}
