/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOOpiniones;
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

    public DefaultTableModel listarElementos(int idHospedaje) {
        return bo.listarElementos(idHospedaje);
    }
}
