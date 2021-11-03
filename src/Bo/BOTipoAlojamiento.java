/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOTipoAlojamiento;
import Excepcion.BuscarTipoAlojamientoException;
import Excepcion.CategoriaException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarTipoAlojamientoException;
import Excepcion.ModificarTipoAlojamientoException;
import Excepcion.NombreCategoriaException;
import Fabrica.FactoryDAO;
import Modelo.TipoAlojamiento;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BOTipoAlojamiento {

    private final IDAOTipoAlojamiento dao;

    public BOTipoAlojamiento() {
        dao = FactoryDAO.getFabrica().crearDAOTipoAlojamiento();
    }

    public void guardarTipoAlojamiento(String categoria, String nombre, String descripcion) throws NombreCategoriaException, DatosIncompletosException, GuardarTipoAlojamientoException, CategoriaException {
        verificarCategoria(categoria);
        TipoAlojamiento tipoalojamiento = new TipoAlojamiento(0, categoria, nombre, descripcion);
        if (!dao.guardarTipoAlojamiento(tipoalojamiento)) {
            throw new GuardarTipoAlojamientoException();
        }
    }

    public TipoAlojamiento buscarTipoAlojamiento(String nombre) throws DatosIncompletosException, BuscarTipoAlojamientoException {
        if (nombre == null) {
            throw new DatosIncompletosException();
        }
        TipoAlojamiento tipoalojamiento = dao.buscarTipoAlojamiento(nombre);

        if (tipoalojamiento == null) {
            throw new BuscarTipoAlojamientoException();
        }
        return tipoalojamiento;
    }

    public void modificarTipoAlojamiento(String categoria, String nombre, String descripcion) throws DatosIncompletosException, NombreCategoriaException, ModificarTipoAlojamientoException, BuscarTipoAlojamientoException {
        TipoAlojamiento tipoalojamiento = new TipoAlojamiento(buscarTipoAlojamiento(nombre).getId(), categoria, nombre, descripcion);
        if (!dao.modificarTipoAlojamiento(tipoalojamiento)) {
            throw new ModificarTipoAlojamientoException();
        }
    }

    public ArrayList<TipoAlojamiento> listarTipoAlojamiento() {
        return dao.listarTipoAlojamiento();
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione")) {
            informacion = null;
        }
        return informacion;
    }

    public String obtenerDatoJtextArea(JTextArea x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public DefaultTableModel listarElementos() {

        ArrayList<TipoAlojamiento> lista = listarTipoAlojamiento();
        String nombreColumnas[] = {"Id", "Categoria", "Nombre", "Descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 4:
                        return true;
                    default:
                        return false;
                }
            }
        };
        return modelo;

    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        if (accion == null) {
            throw new DatosIncompletosException();
        }

        String nombre = "";
        ArrayList<TipoAlojamiento> lista = listarTipoAlojamiento();
        String nombreColumnas[] = {"Id", "Categoria", "Nombre", "Descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 4:
                        return true;
                    default:
                        return false;
                }
            }
        };

        switch (opcion) {
            case "Seleccione":
                throw new ComboBoxException();

            case "Categoria":
                lista.forEach((tipoalojamiento) -> {
                    if (tipoalojamiento.getCategoria().equalsIgnoreCase(accion)) {

                        modelo.addRow(new Object[]{tipoalojamiento.getId(), tipoalojamiento.getCategoria(), tipoalojamiento.getNombre(), tipoalojamiento.getDescripcion()});

                    }

                });
                return modelo;

            case "Nombre":
                lista.forEach((tipoalojamiento) -> {

                    if (tipoalojamiento.getNombre().equalsIgnoreCase(accion)) {
                        modelo.addRow(new Object[]{tipoalojamiento.getId(), tipoalojamiento.getCategoria(), tipoalojamiento.getNombre(), tipoalojamiento.getDescripcion()});
                    }

                });
                return modelo;

            default:
                break;
        }
        return modelo;

    }

    private void verificarCategoria(String categoria) throws CategoriaException {
        if (categoria.equals("Seleccione")) {
            throw new CategoriaException();
        }
    }
}
