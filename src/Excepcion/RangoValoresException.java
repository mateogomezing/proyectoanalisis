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
public class RangoValoresException extends Exception {

    public RangoValoresException() {
        super("El rango inical no debe ser mayor al rango final");
    }
}
