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
public class LogInException extends Exception {
   public LogInException(){
       super("usuario o contraseña incorrecta");
   }
}
