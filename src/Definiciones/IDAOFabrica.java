/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

/**
 *
 * @author mateo
 */
public interface IDAOFabrica {

    /**
     * Metodó para la creación de un DAOAdministrador
     *
     * @return Abstraccion de DAOAdministrador
     */
    public IDAOAdministrador crearDAOAdministrador();

    /**
     * Metodó para la creación de un DAOHuesped
     *
     * @return Abstraccion de DAOHuesped
     */
    public IDAOHuesped crearDAOHuesped();

    /**
     * Metodó para la creación de un DAOLogIn
     *
     * @return Abstraccion de DAOLogIn
     */
    public IDAOLogIn crearDAOLogIn();

    /**
     * Metodo para la creacion de un DAOAnfitrion
     *
     * @return Abstraccion de DAOAnfitrion
     */
    public IDAOAnfitrion crearDAOAnfitrion();

    /**
     * Metodo para la creacion de un DAOHospedaje
     *
     * @return Abstraccion de DAOHospedaje
     */
    public IDAOHospedaje crearDAOHospedaje();

    /**
     * Metodo para la creacion de un DAOOpioniones
     *
     * @return Abstraccion de DAOOpiniones
     */
    public IDAOOpiniones crearDAOOpiniones();
}
