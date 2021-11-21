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
public interface IDAOAlojamientoRango {

    /**
     * Metodo encargado de consultar los alojamientos que han tenido un rango de
     * valor
     *
     * @param valorinicial rango inicial
     * @param valorfinal rango final
     * @return Arreglo de objeto con los datos de las Ciudades
     */
    public ArrayList<DTO.DTOAlojamientoRango> BuscarAlojamientoRangoDTO(int valorinicial, int valorfinal);
}
