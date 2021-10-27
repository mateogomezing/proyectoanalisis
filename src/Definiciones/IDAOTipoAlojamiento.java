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

    public TipoAlojamiento buscarTipoAlojamiento(String nombre) throws DatosIncompletosException;

    public TipoAlojamiento modificarTipoAlojamiento(TipoAlojamiento tipoalojamiento) throws NombreCategoriaException, DatosIncompletosException;

    public ArrayList<TipoAlojamiento> listarTipoAlojamiento();
}
