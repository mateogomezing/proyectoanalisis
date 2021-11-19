/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOCuentaPersonal;
import Excepcion.BuscarCuentaPersonalException;
import Excepcion.DatosIncompletosException;
import Modelo.CuentaPersonal;

/**
 *
 * @author mateo
 */
public class CtlCuentaPersonal {

    BOCuentaPersonal bo;

    public CtlCuentaPersonal() {
        bo = new BOCuentaPersonal();
    }

    public CuentaPersonal buscarCuentaPersonal(int idReserva) throws DatosIncompletosException, BuscarCuentaPersonalException {
        return bo.buscarCuentaPersonal(idReserva);
    }
}
