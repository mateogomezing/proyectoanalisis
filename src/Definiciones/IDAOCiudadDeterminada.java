/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOCiudadDeterminada {

    /**
     * * Metodo encargado de consultar los alojamientos que han tenido una
     * reserva en una ciudad determinada
     *
     * @param ciudad recibe la ciudad de la Reserva
     * @return Arreglo de objeto con los datos de las Ciudades
     */
    public ArrayList<DTO.DTOCiudadDeterminada> BuscarCiudadDeterminadaDTO(String ciudad);
}
