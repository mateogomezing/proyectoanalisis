/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOMiCuenta;
import javax.swing.table.DefaultTableModel;

/**
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 */
public class CtlMiCuenta {

    BOMiCuenta bo;

    public CtlMiCuenta() {
        bo = new BOMiCuenta();
    }

    public DefaultTableModel listaElementosReservaInactiva(int idHuesped) {
        return bo.listarElementosReservacionInactiva(idHuesped);
    }
}
