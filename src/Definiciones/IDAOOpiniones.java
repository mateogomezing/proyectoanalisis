/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Excepcion.GuardarOpinionesException;
import Modelo.Opiniones;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOOpiniones {

    /**
     * Metodo encargado de guardar Opiniones
     *
     * @param opinion recibe objeto Opiniones
     * @return verdadero si guardo el hospedaje, falso si no
     * @throws DatosIncompletosException si algunos de los datos son nulos
     * @throws GuardarOpinionesException error al guardar opiniones
     */
    public boolean guardarOpinion(Opiniones opinion) throws DatosIncompletosException, GuardarOpinionesException;

    /**
     * * Metodo encargado de buscar a un opinion administrador
     *
     * @param idHospedaje recibe id hospedaje de Opinion al buscar
     * @return objetos con los datos de opiniones
     */
    public ArrayList<Opiniones> buscarOpinionAdministrador(int idHospedaje);

}
