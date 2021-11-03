/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOTipoAlojamiento;
import Excepcion.BuscarTipoAlojamientoException;
import Excepcion.CategoriaException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarTipoAlojamientoException;
import Excepcion.ModificarTipoAlojamientoException;
import Excepcion.NombreCategoriaException;
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
public class CtlTipoAlojamiento {
    
    BOTipoAlojamiento bo;
    
    public CtlTipoAlojamiento() {
        bo = new BOTipoAlojamiento();
    }
    
    public void guardarTipoAlojamiento(String categoria, String nombre, String descripcion) throws NombreCategoriaException, DatosIncompletosException, GuardarTipoAlojamientoException, CategoriaException {
        bo.guardarTipoAlojamiento(categoria, nombre, descripcion);
    }
    
    public TipoAlojamiento buscarTipoAlojamiento(String nombre) throws DatosIncompletosException, BuscarTipoAlojamientoException {
        return bo.buscarTipoAlojamiento(nombre);
    }
    
    public void modificar(String categoria, String nombre, String descripcion) throws DatosIncompletosException, NombreCategoriaException, ModificarTipoAlojamientoException, BuscarTipoAlojamientoException {
        bo.modificarTipoAlojamiento(categoria, nombre, descripcion);
    }
    
    public ArrayList<TipoAlojamiento> listarTipoAlojamiento() {
        return bo.listarTipoAlojamiento();
    }
    
    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }
    
    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);
    }

    public String obtenerDatoJtextArea(JTextArea x) {
        return bo.obtenerDatoJtextArea(x);
    }
    
    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        return bo.filtrar(opcion, accion);
    }
    
    public DefaultTableModel listarElementos() {
        return bo.listarElementos();
    }
}
