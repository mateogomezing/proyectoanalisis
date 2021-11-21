/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOOpiniones;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarOpinionesException;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlOpiniones {

    BOOpiniones bo;

    public CtlOpiniones() {
        bo = new BOOpiniones();
    }

    public void guardarOpiniones(int idHuesped, int idHospedaje, String calificacion, String descripcion) throws DatosIncompletosException, GuardarOpinionesException {
        bo.guardarOpinion(idHuesped, idHospedaje, calificacion, descripcion);
    }

    public double calificacionfinal(String calidad, String veracidad, String limpieza, String ubicacion) throws DatosIncompletosException {
        return bo.calificacionfinal(calidad, veracidad, limpieza, ubicacion);
    }

    public DefaultTableModel listarElementosOpinionReserva(int idHospedaje) {
        return bo.listarElementosOpinionReserva(idHospedaje);
    }

    public String obtenerDatoJtextArea(JTextArea x) {
        return bo.obtenerDatoJtextArea(x);
    }

    public DefaultTableModel listarElementos(int idHospedaje) {
        return bo.listarElementos(idHospedaje);
    }
}
