package Definiciones;

import Excepcion.DatosIncompletosException;
import Excepcion.NombreCategoriaException;
import Modelo.TipoAlojamiento;
import java.util.ArrayList;

/**
 *
 * @author Sara Lucía
 */
public interface IDAOTipoAlojamiento {

    /**
     * Método encargado de guardar el tipo Alojamiento
     *
     * @param tipoalojamiento
     * @return
     * @throws NombreCategoriaException
     * @throws DatosIncompletosException
     */
    public boolean guardarTipoAlojamiento(TipoAlojamiento tipoalojamiento) throws NombreCategoriaException, DatosIncompletosException;

    /**
     * Metodo encargado de buscar un de tipo Alojamiento
     *
     * @param nombre recibe el nombre del tipo alojamiento
     * @return con los datos de tipo alojamiento
     *
     *
     */
    public TipoAlojamiento buscarTipoAlojamiento(String nombre);

    /**
     * Metodo encargado de modificar la categoria de un tipo alojamiento
     *
     * @param tipoalojamiento objeto con todo los datos de tipo alojamiento
     * @return verdadero si se modifico tipo alojamiento,falso si no
     * @throws NombreCategoriaException si el nombre de tipo alojamiento ya se
     * encuentra registrada
     * @throws DatosIncompletosException si algunos de los datos son nulos
     */
    public boolean modificarTipoAlojamiento(TipoAlojamiento tipoalojamiento) throws NombreCategoriaException, DatosIncompletosException;

    /**
     * Metodo para listar Tipo Alojamiento
     *
     * @return una lista con las tipo de alojamiento registradas
     */
    public ArrayList<TipoAlojamiento> listarTipoAlojamiento();
}
