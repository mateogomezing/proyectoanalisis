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
public class UsuarioSuspendioException extends Exception{
    public UsuarioSuspendioException(){
        super("Usuario suspendido, comunicarse con un recepcionista o un administrador para solucionarlo");
    }
}
