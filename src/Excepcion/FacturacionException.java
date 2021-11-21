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
public class FacturacionException extends Exception {

    public FacturacionException() {
        super("Error a la hora de realizar el pago");
    }
}
