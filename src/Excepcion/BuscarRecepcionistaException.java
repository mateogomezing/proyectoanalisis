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
public class BuscarRecepcionistaException extends Exception {

    public BuscarRecepcionistaException() {
        super("Error al buscar el huesped, favor verifique la cedula");
    }
}
