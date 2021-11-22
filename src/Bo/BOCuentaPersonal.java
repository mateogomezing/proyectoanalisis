/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOCuentaPersonal;
import Excepcion.BuscarCuentaPersonalException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarCuentaPersonalException;
import Excepcion.ModificarCuentaPersonalException;
import Fabrica.FactoryDAO;
import Modelo.CuentaPersonal;

/**
 *
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 */
public class BOCuentaPersonal {

    private final IDAOCuentaPersonal dao;

    public BOCuentaPersonal() {
        dao = FactoryDAO.getFabrica().crearDAOCuentaPersonal();
    }

    /**
     * Metodo encargado de buscar cuentapersonal por medio de la idReserva
     *
     * @param idReserva
     * @return objeto CuentaPersonal
     * @throws DatosIncompletosException
     * @throws BuscarCuentaPersonalException
     */
    public CuentaPersonal buscarCuentaPersonal(int idReserva) throws DatosIncompletosException, BuscarCuentaPersonalException {
        if (idReserva == 0) {
            throw new DatosIncompletosException();
        }
        CuentaPersonal cuenta = dao.buscarCuentaPersonal(idReserva);
        if (cuenta == null) {
            throw new BuscarCuentaPersonalException();
        }
        return cuenta;
    }

    /**
     * Metodo encargado de guardar CuentaPersonal
     *
     * @param cuentaPersonal
     * @throws DatosIncompletosException
     * @throws GuardarCuentaPersonalException
     */
    public void guardarCuentaPersonal(CuentaPersonal cuentaPersonal) throws DatosIncompletosException, GuardarCuentaPersonalException {

        if (!dao.guardarCuentaPersonal(cuentaPersonal)) {
            throw new GuardarCuentaPersonalException();
        }

    }

    /**
     * Metodo encargado de modificae Cuenta Personal
     *
     * @param cuentapersonal
     * @throws DatosIncompletosException
     * @throws ModificarCuentaPersonalException
     */
    public void modificarCuentaPersonal(CuentaPersonal cuentapersonal) throws DatosIncompletosException, ModificarCuentaPersonalException {
        if (!dao.modificarCuentaPersonal(cuentapersonal)) {
            throw new ModificarCuentaPersonalException();
        }
    }

}
