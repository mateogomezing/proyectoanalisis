/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOAlojamientoRango;
import Excepcion.BuscarCiudadDeterminadaException;
import Excepcion.RangoValoresException;
import javax.swing.table.DefaultTableModel;

/**
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 */
public class CtlAlojamientoRango {

    BOAlojamientoRango bo;

    public CtlAlojamientoRango() {
        bo = new BOAlojamientoRango();
    }

    public DefaultTableModel listarElementosAlojamientoRangoDTO(int valorinicial, int valorfinal) throws BuscarCiudadDeterminadaException, RangoValoresException {
        return bo.listarElementosAlojamientoRangoDTO(valorinicial, valorfinal);
    }

}
