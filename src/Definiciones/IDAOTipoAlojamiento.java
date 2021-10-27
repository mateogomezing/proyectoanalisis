package Definiciones;

import Excepcion.DatosIncompletosException;
import Excepcion.NombreCategoriaException;
import Modelo.TipoAlojamiento;

/**
 *
 * @author Sara Lucía
 */
public interface IDAOTipoAlojamiento {

    /**
     * Método encargado de guardar el tipo Alojamiento
     *
     * @return
     * @throws NombreCategoriaException
     * @throws DatosIncompletosException
     */
    public boolean guardarTipoAlojamiento() throws NombreCategoriaException, DatosIncompletosException;

    public TipoAlojamiento buscarTipoAlojamiento();

    public TipoAlojamiento modificarTipoAlojamiento();

    public TipoAlojamiento listarTipoAlojamiento();

    public TipoAlojamiento EliminarTipoAlojamiento();
}
