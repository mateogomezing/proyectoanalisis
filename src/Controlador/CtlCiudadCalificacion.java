/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOCiudadCalificacion;
import Excepcion.BuscarCiudadDeterminadaException;
import Excepcion.DatosIncompletosException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlCiudadCalificacion {

    BOCiudadCalificacion bo;

    public CtlCiudadCalificacion() {
        bo = new BOCiudadCalificacion();
    }

    public DefaultTableModel listarElementosCiudadCalificacionDTO(String ciudades) throws DatosIncompletosException, BuscarCiudadDeterminadaException {
        return bo.listarElementosCiudadCalificacionDTO(ciudades);
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);
    }
}
