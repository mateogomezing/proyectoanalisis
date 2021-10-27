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
public class BuscarCedulaHuespedException extends Exception {

    public BuscarCedulaHuespedException() {
        super("No se ha llenado el campo cedula del huesped");
    }
}
