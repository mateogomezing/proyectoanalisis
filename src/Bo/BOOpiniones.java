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
 * @author mateo
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

    public void guardarOpinion(int idHuesped, int idHospedaje, String calificacion, String descripcion) throws DatosIncompletosException, GuardarOpinionesException {
        verificarDatos(calificacion);
        verificarDatos(descripcion);
        Opiniones opinion = new Opiniones(0, idHuesped, idHospedaje, calificacion, descripcion);
        if (!dao.guardarOpinion(opinion)) {
            throw new GuardarOpinionesException();
        }
    }

    public void verificarDatos(String dato) throws DatosIncompletosException {
        if (dato == null) {
            throw new DatosIncompletosException();
        }
    }

    public String obtenerDatoJtextArea(JTextArea x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public ArrayList<Opiniones> listarOpiniones(int idHospedaje) {
        return dao.buscarOpinionAdministrador(idHospedaje);
    }

    public ArrayList<Hospedaje> listarHospedajes() {
        return daoHospedaje.listarHospedaje();
    }

    public ArrayList<Huesped> listarHuesped() {
        return daoHuesped.listarHuesped();
    }

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
