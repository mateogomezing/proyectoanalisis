/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOCiudadDeterminada;
import Excepcion.BuscarCiudadDeterminadaException;
import Excepcion.DatosIncompletosException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlCiudadDeterminada {

    BOCiudadDeterminada bo;

    public CtlCiudadDeterminada() {
        bo = new BOCiudadDeterminada();
    }

    public DefaultTableModel listarElementosCiudadDeterminadaDTO(String ciudades) throws DatosIncompletosException, BuscarCiudadDeterminadaException {
        return bo.listarElementosCiudadDeterminadaDTO(ciudades);
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);
    }

    public DefaultTableModel listarElementosCiudadDeterminadaMayorDTO(String ciudades) throws DatosIncompletosException, BuscarCiudadDeterminadaException {
        return bo.listarElementosCiudadDeterminadaMayorDTO(ciudades);

    }
}
