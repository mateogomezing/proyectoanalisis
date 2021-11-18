/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definiciones;

import Excepcion.DatosIncompletosException;
import Modelo.ReservaHospedaje;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public interface IDAOReserva {

    /**
     * Metodo encargado de guardar Reserva
     *
     * @param reserva recibe la reservahabitacion
     * @return verdadero si guardo Reserva,falso si no
     * @throws DatosIncompletosException si algunos de los datos son nulos
     */
    public boolean guardarReserva(ReservaHospedaje reserva) throws DatosIncompletosException;

    /**
     * Método para listar reserva
     *
     * @return una lista con las reservas registradas
     */
    public ArrayList<ReservaHospedaje> listarReserva();

    /**
     * Metodo encargado de modificar la reserva
     *
     * @param estado que desea modificar
     * @param estadoServicio que desea modificar
     * @param id para realizar la modificación
     * @return verdadero si modifica falso si no lo hace
     * @throws DatosIncompletosException
     */
    public boolean modificarReserva(String estado, String estadoServicio, int id) throws DatosIncompletosException;
}
