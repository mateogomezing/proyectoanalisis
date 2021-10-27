/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepcion;

/**
 *
 * @author santiago
 */
public class TelefonoException extends Exception{
    public TelefonoException (){
        super("Telefono existente, favor ingrese otro");
    }
}
