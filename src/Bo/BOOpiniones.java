/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHospedaje;
import Definiciones.IDAOHuesped;
import Definiciones.IDAOOpiniones;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarOpinionesException;
import Fabrica.FactoryDAO;
import Modelo.Hospedaje;
import Modelo.Huesped;
import Modelo.Opiniones;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo Gomez Ramirez 2320182006
 * @author Sara Lucia Carmona 240220191021
 * @author Didier Andres LLanten Velez 240220201013
 */
public class BOOpiniones {

    private final IDAOOpiniones dao;
    private final IDAOHuesped daoHuesped;
    private final IDAOHospedaje daoHospedaje;

    public BOOpiniones() {
        dao = FactoryDAO.getFabrica().crearDAOOpiniones();
        daoHuesped = FactoryDAO.getFabrica().crearDAOHuesped();
        daoHospedaje = FactoryDAO.getFabrica().crearDAOHospedaje();
    }

    /**
     * Metodo encarfado de dar la calificacion final
     *
     * @param calidad
     * @param veracidad
     * @param limpieza
     * @param ubicacion
     * @return valor de la calificacion
     * @throws DatosIncompletosException
     */
    public double calificacionfinal(String calidad, String veracidad, String limpieza, String ubicacion) throws DatosIncompletosException {
        double valorfinal = 0;
        if (calidad == null | veracidad == null | limpieza == null | ubicacion == null) {
            throw new DatosIncompletosException();
        } else {
            int calidades = Integer.parseInt(calidad);
            int veracidades = Integer.parseInt(veracidad);
            int limpiezas = Integer.parseInt(limpieza);
            int ubicaciones = Integer.parseInt(ubicacion);
            int suma = calidades + veracidades + limpiezas + ubicaciones;
            valorfinal = suma / 4;
        }
        return valorfinal;
    }

    /**
     * Metodo encargado de guardar Opinion
     *
     * @param idHuesped
     * @param idHospedaje
     * @param calificacion
     * @param descripcion
     * @throws DatosIncompletosException
     * @throws GuardarOpinionesException
     */
    public void guardarOpinion(int idHuesped, int idHospedaje, String calificacion, String descripcion) throws DatosIncompletosException, GuardarOpinionesException {
        verificarDatos(calificacion);
        verificarDatos(descripcion);
        Opiniones opinion = new Opiniones(0, idHuesped, idHospedaje, calificacion, descripcion);
        if (!dao.guardarOpinion(opinion)) {
            throw new GuardarOpinionesException();
        }
    }

    /**
     * Metodo de verifica los datos nulos
     *
     * @param dato
     * @throws DatosIncompletosException
     */
    public void verificarDatos(String dato) throws DatosIncompletosException {
        if (dato == null) {
            throw new DatosIncompletosException();
        }
    }

    /**
     * metodo encargado de verificar JTextArea
     *
     * @param x
     * @return
     */
    public String obtenerDatoJtextArea(JTextArea x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    /**
     * Metodo encargado de listar las opiniones
     *
     * @param idHospedaje
     * @return lista de opiniones
     */
    public ArrayList<Opiniones> listarOpiniones(int idHospedaje) {
        return dao.buscarOpinionAdministrador(idHospedaje);
    }

    /**
     * metodo encargado de listarHospedaje
     *
     * @return lista de hospedaje
     */
    public ArrayList<Hospedaje> listarHospedajes() {
        return daoHospedaje.listarHospedaje();
    }

    /**
     * Metodo encargado de listar Huesped
     *
     * @return lista de Huesped
     */
    public ArrayList<Huesped> listarHuesped() {
        return daoHuesped.listarHuesped();
    }

    /**
     * Metodo encargado listar elementos de opinion en la tabla
     *
     * @param idHospedaje
     * @return modelo de la tabla
     */
    public DefaultTableModel listarElementosOpinionReserva(int idHospedaje) {
        ArrayList<Opiniones> listaropiniones = listarOpiniones(idHospedaje);
        ArrayList<Hospedaje> listahospedaje = listarHospedajes();
        ArrayList<Huesped> listaHuesped = listarHuesped();
        String nombreColumnas[] = {"Huesped", "Hospedaje", "Calificacion"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 3:
                        return true;
                    default:
                        return false;
                }
            }
        };
        String huesped = "";
        String hospedaje = "";
        for (Opiniones opiniones : listaropiniones) {

            for (Huesped huespedes : listaHuesped) {
                for (Hospedaje hospedajes : listahospedaje) {
                    if (opiniones.getIdHospedaje() == hospedajes.getId() && huespedes.getId() == opiniones.getIdHuesped()) {
                        huesped = huespedes.getNombreCompleto();
                        hospedaje = hospedajes.getCategoria() + "-" + hospedajes.getTipo();
                        break;
                    }
                }

            }
            modelo.addRow(new Object[]{huesped, hospedaje, opiniones.getCalificacion()});
        }
        return modelo;
    }

    /**
     * Metodo de listar elementos de la opinion
     *
     * @param idHospedaje
     * @return modelo de la tabla
     */
    public DefaultTableModel listarElementos(int idHospedaje) {
        ArrayList<Opiniones> listaropiniones = listarOpiniones(idHospedaje);
        ArrayList<Hospedaje> listahospedaje = listarHospedajes();
        ArrayList<Huesped> listaHuesped = listarHuesped();
        String nombreColumnas[] = {"Id", "Huesped", "Hospedaje", "Calificacion", "Descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 5:
                        return true;
                    default:
                        return false;
                }
            }
        };
        String huesped = "";
        String hospedaje = "";
        for (Opiniones opiniones : listaropiniones) {

            for (Huesped huespedes : listaHuesped) {
                for (Hospedaje hospedajes : listahospedaje) {
                    if (opiniones.getIdHuesped() == huespedes.getId() && opiniones.getIdHospedaje() == hospedajes.getId()) {
                        huesped = huespedes.getCedula() + "-" + huespedes.getNombreCompleto();
                        hospedaje = hospedajes.getCategoria() + "-" + hospedajes.getTipo();
                        break;
                    }
                }

            }
            modelo.addRow(new Object[]{opiniones.getId(), huesped, hospedaje, opiniones.getCalificacion(), opiniones.getDescripcion()});
        }
        return modelo;
    }

}
