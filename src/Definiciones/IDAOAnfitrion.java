/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaException;
import Excepcion.CedulaHuespedException;
import Excepcion.DatosIncompletosException;
import Modelo.Anfitrion;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOAnfitrion {

    /**
     * Método encargado de guardar el huesped
     *
     * @param anfitrion recibe el anfitrion
     * @return vardadero si guardó el anfitrion falso si no
     * @throws CedulaException si la cedula del anfitrion ya se encuentra
     * existente
     * @throws DatosIncompletosException si algunos de los datos son nulos
     * @throws CedulaAdministradorException si la cedula pertenece a un
     * administrador
     * @throws CedulaHuespedException si la cedula pertenece a un Huesped
     */
    public boolean guardarAnfitrion(Anfitrion anfitrion) throws CedulaException, DatosIncompletosException, CedulaAdministradorException, CedulaHuespedException;

    /**
     * Metodo encargado de buscar a un anfitrion
     *
     * @param cedula recibe la cedula del anfitrion al buscar
     * @return objeto con los datos del Anfitrion
     */
    public Anfitrion buscarAnfitrion(String cedula);

    /**
     * Metodo encargado de buscar a un anfitrion por el id
     *
     * @param idAnfitrion recibe el id del anfitrion al buscar
     * @return objeto con los datos del Anfitrion
     */
    public Anfitrion buscarAnfitrionId(int idAnfitrion);

    /**
     * Método encargado de modificar al huesped cuando no se modifica imagen
     *
     * @param anfitrion objeto con todos los datos del anfitrion
     * @return verdadero si se modificó el anfitrion falso si no
     * @throws CedulaException la cedula se encuentra registrada
     * @throws DatosIncompletosException si algunos de los datos son nulos
     */
    public boolean modificarAnfitrion(Anfitrion anfitrion) throws CedulaException, DatosIncompletosException;

    /**
     * Método encargado de modificar al huesped cuando se modifica imagen
     *
     * @param anfitrion objeto con todos los datos del anfitrion
     * @return verdadero si se modificó el anfitrion falso si no
     * @throws CedulaException la cedula se encuentra registrada
     * @throws DatosIncompletosException si algunos de los datos son nulos
     */
    public boolean modificarAnfitrion2(Anfitrion anfitrion) throws CedulaException, DatosIncompletosException;

    /**
     * Método para listar anfitrion
     *
     * @return una lista con los Anfitriones registrados
     */
    public ArrayList<Anfitrion> listarAnfitrion();
}
