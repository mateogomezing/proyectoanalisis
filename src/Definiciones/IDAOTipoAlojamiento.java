package Definiciones;

import Modelo.TipoAlojamiento;

/**
 *
 * @author Sara Lucía
 */
public interface IDAOTipoAlojamiento{

    public boolean guardarTipoAlojamiento();
    
    public TipoAlojamiento buscarTipoAlojamiento();
            
    public TipoAlojamiento modificarTipoAlojamiento();
    
    public TipoAlojamiento listarTipoAlojamiento();
    
    public TipoAlojamiento EliminarTipoAlojamiento();
}
