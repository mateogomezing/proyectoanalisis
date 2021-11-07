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
public class NombreHospedajeException extends Exception {

    public NombreHospedajeException() {
        super("Tipo Hospedaje repetido, favor ingrese otra");
    }

}
