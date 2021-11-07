/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOLogIn;
import Excepcion.DatosIncompletosException;
import Excepcion.LogInException;
import Excepcion.UsuarioSuspendioException;
import Fabrica.FactoryDAO;
import Modelo.Administrador;
import Modelo.Anfitrion;
import Modelo.Huesped;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class BOLogIn {

    private final IDAOLogIn dao;

    public BOLogIn() {
        dao = FactoryDAO.getFabrica().crearDAOLogIn();
    }

    public Huesped LogInHusped(String cedula, String contrasena) {
        Huesped huesped = dao.LogInHuesped(cedula, contrasena);

        return huesped;
    }

    public Administrador LogInAdministrador(String cedula, String contrasena) {
        Administrador administrador = dao.LogInAdministrador(cedula, contrasena);

        return administrador;
    }

    public Anfitrion LogInAnfitrion(String cedula, String contrasena) {
        Anfitrion anfitrion = dao.LogInAnfitrion(cedula, contrasena);
        return anfitrion;
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione")) {
            informacion = null;
        }
        return informacion;
    }

    public Object IniciarSesion(String cedula, String contrasena) throws DatosIncompletosException, LogInException, UsuarioSuspendioException {

        verificarDatos(cedula, contrasena);
        Huesped huesped = LogInHusped(cedula, contrasena);
        Administrador administrador = LogInAdministrador(cedula, contrasena);
        Anfitrion anfitrion = LogInAnfitrion(cedula, contrasena);

        if (huesped != null) {
            if (!huesped.getEstado().equals("No Disponible")) {
                return huesped;
            } else {

                throw new UsuarioSuspendioException();
            }

        } else if (administrador != null) {

            return administrador;
        } else if (anfitrion != null) {
            if (!anfitrion.getEstado().equals("Desactivado")) {
                return anfitrion;
            } else {
                throw new UsuarioSuspendioException();
            }
        } else {
            throw new LogInException();
        }

    }

    private void verificarDatos(String cedula, String contrasena) throws DatosIncompletosException {
        if (cedula == null || contrasena == null) {
            throw new DatosIncompletosException();
        }
    }
}
