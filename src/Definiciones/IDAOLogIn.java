/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Modelo.Administrador;
import Modelo.Anfitrion;
import Modelo.Huesped;

/**
 *
 * @author mateo
 */
public interface IDAOLogIn {

    /**
     * Método encargado de ingresar\logear a un huesped
     *
     * @param cedula del huesped
     * @param contrasena del huesped
     * @return objeto con los datos del huesped
     */
    public Huesped LogInHuesped(String cedula, String contrasena);

    /**
     * Método encargado de ingresar\logear a un administrador
     *
     * @param cedula del administrador
     * @param contrasena del administrador
     * @return objeto con los datos del administrador
     */
    public Administrador LogInAdministrador(String cedula, String contrasena);

    /**
     * Método encargado de ingresar\logear a un anfitrion
     *
     * @param cedula del anfitrion
     * @param contrasena del anfitrion
     * @return objeto con los datos del anfitrion
     */
    public Anfitrion LogInAnfitrion(String cedula, String contrasena);
}
