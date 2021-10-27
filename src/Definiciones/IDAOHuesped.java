/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaException;
import Excepcion.CorreoException;
import Excepcion.DatosIncompletosException;
import Excepcion.TelefonoException;
import Modelo.Huesped;

/**
 *
 * @author mateo
 */
public interface IDAOHuesped {

    /**
     * Método encargado de guardar el huesped
     *
     * @param huesped recibe el huesped
     * @return vardadero si guardó el huesped falso si no
     * @throws CedulaException si la cedula del huesped ya se encuentra
     * existente
     * @throws CorreoException si el correo del huesped ya se encuentra
     * existente
     * @throws DatosIncompletosException si algunos de los datos son nulos
     * @throws TelefonoException si el telefono del huesped ya se encuentra
     * existente
     * @throws CedulaAdministradorException si la cedula pertenece a un
     * administrador
     *
     */
    public boolean guardarHuesped(Huesped huesped) throws CedulaException, CorreoException, DatosIncompletosException, TelefonoException, CedulaAdministradorException;
}
