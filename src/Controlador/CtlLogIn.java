/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOLogIn;
import Excepcion.DatosIncompletosException;
import Excepcion.LogInException;
import Excepcion.UsuarioSuspendioException;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class CtlLogIn {

    private final BOLogIn bo;

    public CtlLogIn() {
        bo = new BOLogIn();
    }

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);
    }

    public Object IniciarSesion(String cedula, String contrasena) throws DatosIncompletosException, LogInException, UsuarioSuspendioException {
        return bo.IniciarSesion(cedula, contrasena);
    }
}
