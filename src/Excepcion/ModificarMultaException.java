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
public class ModificarMultaException extends Exception {

    public ModificarMultaException() {
        super("Error al modificar el valor total de la multa");
    }
}
