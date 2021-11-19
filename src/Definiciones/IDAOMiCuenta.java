/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import DTO.DTOReservaActiva;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOMiCuenta {

    /**
     * Metodo encargado de consultar las reservas activas del huesped
     *
     *
     * @param idHuesped recibe el id del huesped
     * @return Arreglo de objeto con los datos de las reservas activas
     */
    public ArrayList<DTOReservaActiva> BuscarReservaActiva(int idHuesped);
}
