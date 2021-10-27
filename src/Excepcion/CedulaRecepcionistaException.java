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
public class CedulaRecepcionistaException extends Exception{
    public CedulaRecepcionistaException(){
        super("Cedula perteneciente a un recepcionista");
    }
}
