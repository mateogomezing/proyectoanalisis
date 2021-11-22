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
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 */
public class BOLogIn {

    private final IDAOLogIn dao;

    public BOLogIn() {
        dao = FactoryDAO.getFabrica().crearDAOLogIn();
    }

    /**
     * Metodo encargado del logIn Huesped
     *
     * @param cedula
     * @param contrasena
     * @return objeto Huesped
     */
    public Huesped LogInHusped(String cedula, String contrasena) {
        Huesped huesped = dao.LogInHuesped(cedula, contrasena);

        return huesped;
    }

    /**
     * Metodo encargado del Login Administrador
     *
     * @param cedula
     * @param contrasena
     * @return objeto Administrador
     */
    public Administrador LogInAdministrador(String cedula, String contrasena) {
        Administrador administrador = dao.LogInAdministrador(cedula, contrasena);

        return administrador;
    }

    /**
     * Metodo encargado del Login Anfitrion
     *
     * @param cedula
     * @param contrasena
     * @return
     */
    public Anfitrion LogInAnfitrion(String cedula, String contrasena) {
        Anfitrion anfitrion = dao.LogInAnfitrion(cedula, contrasena);
        return anfitrion;
    }

    /**
     * metodo encargado de verificar JTextField
     *
     * @param x
     * @return
     */
    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    /**
     * metodo encargado de verificar JComboBox
     *
     * @param x
     * @return
     */
    public String obtenerDatoJComboBox(JComboBox x) {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione")) {
            informacion = null;
        }
        return informacion;
    }

    /**
     * Metodo de verificar que tipo de objecto es y dar inicio de sesion
     *
     * @param cedula
     * @param contrasena
     * @return objeto encontrado
     * @throws DatosIncompletosException
     * @throws LogInException
     * @throws UsuarioSuspendioException
     */
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

    /**
     * valida los datos nulos
     *
     * @param cedula
     * @param contrasena
     * @throws DatosIncompletosException
     */
    private void verificarDatos(String cedula, String contrasena) throws DatosIncompletosException {
        if (cedula == null || contrasena == null) {
            throw new DatosIncompletosException();
        }
    }
}
