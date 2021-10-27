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
public class NombreCategoriaException extends Exception {

    public NombreCategoriaException() {
        super("Nombre repetido, favor ingrese otro");
    }
}
