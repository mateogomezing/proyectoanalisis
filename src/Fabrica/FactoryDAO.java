/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fabrica;

import Dao.FactoryDAOJDBC;
import Definiciones.IDAOFabrica;

/**
 *
 * @author mateo
 */
public class FactoryDAO {

    /**
     * Método que retorna la fábrica del medio de persistencia que se va a usar
     *
     * @return una abstracción del medio de persistencia
     */
    public static IDAOFabrica getFabrica() {
        return new FactoryDAOJDBC();
    }
}
