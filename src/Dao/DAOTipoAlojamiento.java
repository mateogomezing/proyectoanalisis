/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Definiciones.IDAOTipoAlojamiento;
import Excepcion.DatosIncompletosException;
import Excepcion.NombreCategoriaException;
import Modelo.TipoAlojamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class DAOTipoAlojamiento implements IDAOTipoAlojamiento {

    @Override
    public boolean guardarTipoAlojamiento(TipoAlojamiento tipoalojamiento) throws NombreCategoriaException, DatosIncompletosException {
        boolean desicion = true;

        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO tipo_alojamiento (categoria,nombre,descripcion) values (?,?,?)");

            pstmt.setString(1, tipoalojamiento.getCategoria());
            pstmt.setString(2, tipoalojamiento.getNombre());
            pstmt.setString(3, tipoalojamiento.getDescripcion());

            pstmt.executeUpdate();
            desicion = true;
        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "tipo_alojamiento.nombr":
                        throw new NombreCategoriaException();

                    default:
                        break;
                }

            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }
            desicion = false;
        }
        return desicion;
    }

    @Override
    public TipoAlojamiento buscarTipoAlojamiento(String nombre) {
        TipoAlojamiento tipoalojamiento = new TipoAlojamiento();

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,categoria,nombre,descripcion FROM tipo_alojamiento where nombre=?");
            pstmt.setString(1, nombre);
            // Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();

            if (respuesta.next()) {

                tipoalojamiento.setId(respuesta.getInt("id"));
                tipoalojamiento.setCategoria(respuesta.getString("categoria"));
                tipoalojamiento.setNombre(respuesta.getString("nombre"));
                tipoalojamiento.setDescripcion(respuesta.getString("descripcion"));

                return tipoalojamiento;
            }
        } catch (SQLException ex) {
            tipoalojamiento = null;

        }
        return null;
    }

    @Override
    public boolean modificarTipoAlojamiento(TipoAlojamiento tipoalojamiento) throws NombreCategoriaException, DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE tipo_alojamiento SET  categoria=?, nombre=?, descripcion=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setString(1, tipoalojamiento.getCategoria());
            pstmt.setString(2, tipoalojamiento.getNombre());
            pstmt.setString(3, tipoalojamiento.getDescripcion());

            int res = pstmt.executeUpdate();

            desicion = res > 0;
        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "tipo_alojamiento.nombr":
                        throw new NombreCategoriaException();

                    default:
                        break;
                }

            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }
            desicion = false;
        }
        return desicion;
    }

    @Override
    public ArrayList<TipoAlojamiento> listarTipoAlojamiento() {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,categoria,nombre,descripcion FROM tipo_alojamiento");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<TipoAlojamiento> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    TipoAlojamiento tipoalojamiento = new TipoAlojamiento();

                    tipoalojamiento.setId(respuesta.getInt("id"));
                    tipoalojamiento.setCategoria(respuesta.getString("categoria"));
                    tipoalojamiento.setNombre(respuesta.getString("nombre"));
                    tipoalojamiento.setDescripcion(respuesta.getString("descripcion"));

                    listar.add(tipoalojamiento);

                } else {
                    condicion = false;
                }
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            System.err.println("Hubo un error al listar");
        }
        return null;
    }

    /**
     * Método extraer la variable que tuvo el codigo de error 1062
     *
     * @param variable mensaje de error de sql (ex.getMessage())
     * @param termina dos ultimos datos que terminar del mensaje del error
     * @return nombre de la variable que tiene el error
     */
    private String extraerVariable(String variable, String termina) {
        int inicio = variable.indexOf("key '");
        int fin = variable.indexOf(termina, inicio + 1);
        return variable.substring(inicio + 5, fin);
    }

    /**
     * Método para extraer las dos ultmias letras de una cadena de texto
     *
     * @param variable cadena de texto
     * @return dos ultimos datos de la cadena de texto
     */
    private String extraerDosUltimasLetras(String variable) {
        int tamano = variable.length();
        return variable.substring((tamano - 2), tamano);
    }

}
