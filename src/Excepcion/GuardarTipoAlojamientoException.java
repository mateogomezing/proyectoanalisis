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
public class GuardarTipoAlojamientoException extends Exception {

    public GuardarTipoAlojamientoException() {
        super("Error al guardar el tipo alojamiento");
    }
}
