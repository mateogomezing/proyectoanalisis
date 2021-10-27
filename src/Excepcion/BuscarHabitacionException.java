/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepcion;

/**
 *
 * @author mateo
 */
public class BuscarHabitacionException extends Exception {

    public BuscarHabitacionException() {
        super("Error al buscar la habitacion, favor verifique el nombre");
    }
}
