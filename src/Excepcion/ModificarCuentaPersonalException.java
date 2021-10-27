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
public class ModificarCuentaPersonalException extends Exception{
    public ModificarCuentaPersonalException(){
        super("Error al modificar la cuenta perosnal");
    }
}
