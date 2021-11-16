/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOHospedaje;
import Definiciones.IDAOHuesped;
import Definiciones.IDAOOpiniones;
import Fabrica.FactoryDAO;
import Modelo.Hospedaje;
import Modelo.Huesped;
import Modelo.Opiniones;
import java.util.ArrayList;
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

    public ArrayList<Opiniones> listarOpiniones(int idHospedaje) {
        return dao.buscarOpinionAdministrador(idHospedaje);
    }

    public ArrayList<Hospedaje> listarHospedajes() {
        return daoHospedaje.listarHospedaje();
    }

    public ArrayList<Huesped> listarHuesped() {
        return daoHuesped.listarHuesped();
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
