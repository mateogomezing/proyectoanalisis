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
public class BuscarAnfitrionException extends Exception {

    public BuscarAnfitrionException() {
        super("Error al buscar el anfitrion, favor verifique la cedula");
    }
}
