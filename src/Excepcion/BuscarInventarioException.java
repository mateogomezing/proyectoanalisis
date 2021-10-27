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
public class BuscarInventarioException extends Exception {

    public BuscarInventarioException() {
        super("Error al buscar el producto en el inventario, favor verifique el nombre");
    }
}
