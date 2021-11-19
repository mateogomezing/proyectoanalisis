/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Definiciones.IDAOAdministrador;
import Definiciones.IDAOAnfitrion;
import Definiciones.IDAOCuentaPersonal;
import Definiciones.IDAOFabrica;
import Definiciones.IDAOHospedaje;
import Definiciones.IDAOHuesped;
import Definiciones.IDAOLogIn;
import Definiciones.IDAOMiCuenta;
import Definiciones.IDAOOpiniones;
import Definiciones.IDAOReserva;

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
    public IDAOAnfitrion crearDAOAnfitrion() {
        return new DAOAnfitrion();
    }

    @Override
    public IDAOHospedaje crearDAOHospedaje() {
        return new DAOHospedaje();
    }

    @Override
    public IDAOOpiniones crearDAOOpiniones() {
        return new DAOOpiniones();
    }

    @Override
    public IDAOReserva crearDAOReserva() {
        return new DAOReserva();
    }

    @Override
    public IDAOMiCuenta crearDAOMiCuenta() {
        return new DAOMiCuenta();
    }

    @Override
    public IDAOCuentaPersonal crearDAOCuentaPersonal() {
        return new DAOCuentaPersonal();
    }
}
