/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Excepcion.NombreHospedajeException;
import Modelo.Hospedaje;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOHospedaje {

    /**
     * Metodo encargado de guardar Hospedaje
     *
     * @param hospedaje recibe objeto hospedaje
     * @return verdadero si guardo el hospedaje, falso si no
     * @throws DatosIncompletosException si algunos de los datos son nulos
     * @throws NombreHospedajeException si el nombre de la habitacion ya se
     * encuentra registrada
     */
    public boolean guardarHospedaje(Hospedaje hospedaje) throws DatosIncompletosException, NombreHospedajeException;

    /**
     * Metodo encargado de buscar un hospedaje por el tipo
     *
     * @param tipo recibe el tipo de hospedaje del hospedaje al buscar
     * @return objeto con los datos del hospedaje
     */
    public Hospedaje buscarHospedaje(String tipo);

    /**
     *  * Metodo encargado de buscar un hospedaje por el tipo y anfitrion
     *
     * @param tipo recibe el tipo de hospedaje del hospedaje al buscar
     * @param idAnfitrion recibe el anfitrion de hospedaje del hospedaje al
     * buscar
     * @return objeto con los datos del hospedaje
     *
     */
    public Hospedaje buscarHospedajeAnfitrion(String tipo, int idAnfitrion);

    /**
     * Metodo encargado de buscar un hospedaje por ciudad
     *
     * @param ciudad recibe la ciudad del hospedaje al buscar
     * @return recibe la ciudad del hospedaje al buscar
     */
    public ArrayList<Hospedaje> buscarHospedajeCiudad(String ciudad);

    /**
     * Metodo encargado de buscar un hospedaje por ciudad y tipo
     *
     * @param ciudad recibe la ciudad del hospedaje al buscar
     * @param tipo recibe tipo del hospedaje al buscar
     * @return recibe la ciudad y el tipo del hospedaje al buscar
     */
    public ArrayList<Hospedaje> buscarHospedajeTipo(String ciudad, String tipo);

    /**
     * Metodo encargado de modificar el hospedaje cuando modifica la imagen
     *
     * @param hospedaje objeto con todos los datos del hospedaje
     * @return verdadero si se modifico el hospedaje,falso si no
     * @throws Excepcion.NombreHospedajeException si el nombre de la habitacion
     * ya se encuentra registrada
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    /**
     *
     * @return
     */
    public boolean modificarHospedaje(Hospedaje hospedaje) throws NombreHospedajeException, DatosIncompletosException;

    /**
     ** Metodo encargado de modificar el hospedaje cuando no modifica la imagen
     *
     * @param hospedaje objeto con todos los datos del hospedaje
     * @return verdadero si se modifico el hospedaje,falso si no
     * @throws Excepcion.NombreHospedajeException si el nombre de la habitacion
     * ya se encuentra registrada
     * @throws Excepcion.DatosIncompletosException si algunos de los datos son
     * nulos
     */
    public boolean modificarHospedaje2(Hospedaje hospedaje) throws NombreHospedajeException, DatosIncompletosException;

    /**
     * Metodo para listar el hospedaje
     *
     * @return una lista de hospedajes registrados
     */
    public ArrayList<Hospedaje> listarHospedaje();
}
