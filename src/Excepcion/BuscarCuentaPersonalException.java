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
public class BuscarCuentaPersonalException extends Exception {

    public BuscarCuentaPersonalException() {
        super("Error al buscar la cuenta personal, favor verifique el id de la reserva");
    }
}
