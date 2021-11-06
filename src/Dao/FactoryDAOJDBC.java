/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Definiciones.IDAOAdministrador;
import Definiciones.IDAOAnfitrion;
import Definiciones.IDAOFabrica;
import Definiciones.IDAOHuesped;
import Definiciones.IDAOLogIn;
import Definiciones.IDAOTipoAlojamiento;

/**
 *
 * @author mateo
 */
public class FactoryDAOJDBC implements IDAOFabrica {

    @Override
    public IDAOAdministrador crearDAOAdministrador() {
        return new DAOAdministrador();
    }

    @Override
    public IDAOHuesped crearDAOHuesped() {
        return new DAOHuesped();
    }

    @Override
    public IDAOLogIn crearDAOLogIn() {
        return new DAOLogIn();
    }

    @Override
    public IDAOTipoAlojamiento crearDAOTipoAlojamiento() {
        return new DAOTipoAlojamiento();
    }

    @Override
    public IDAOAnfitrion crearDAOAnfitrion() {
        return new DAOAnfitrion();
    }

}
