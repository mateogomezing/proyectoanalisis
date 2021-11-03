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
public class BuscarTipoAlojamientoException extends Exception {

    public BuscarTipoAlojamientoException() {
        super("Error al buscar el tipo de alojamiento, favor verifique el nombre");
    }
}
