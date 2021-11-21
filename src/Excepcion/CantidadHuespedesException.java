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
public class CantidadHuespedesException extends Exception {

    public CantidadHuespedesException() {
        super("La Habitacion seleccionada no cumple con su busqueda,verifique cantidad Huespedes");
    }
}
