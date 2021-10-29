/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Modelo.Administrador;

/**
 *
 * @author mateo
 */
public interface IDAOAdministrador {

    /**
     * Método encargado de buscar a un administrador
     *
     * @param cedula recibe la cedula del administrador al buscar
     * @return objeto con los datos del administrador
     */
    public Administrador buscarAdministrador(String cedula);
}
