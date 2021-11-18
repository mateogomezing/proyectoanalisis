/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Definiciones.IDAOAnfitrion;
import Excepcion.CedulaAdministradorException;
import Excepcion.CedulaException;
import Excepcion.CedulaHuespedException;
import Excepcion.DatosIncompletosException;
import Modelo.Administrador;
import Modelo.Anfitrion;
import Modelo.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class DAOAnfitrion implements IDAOAnfitrion {

    @Override
    public boolean guardarAnfitrion(Anfitrion anfitrion) throws CedulaException, DatosIncompletosException, CedulaAdministradorException, CedulaHuespedException {
        boolean desicion = false;

        try (Connection con = Conexion.getConnection()) {
            DAOAdministrador daoAdministrador = new DAOAdministrador();
            DAOHuesped daoHuesped = new DAOHuesped();
            Administrador administrador = daoAdministrador.buscarAdministrador(anfitrion.getCedula());
            Huesped huesped = daoHuesped.buscarHuesped(anfitrion.getCedula());
            vaidarCedulas(administrador, huesped);
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO anfitrion (foto,cedula,nombreCompleto,residencia,idioma,contrasena,biografia,estado) values (?,?,?,?,?,?,?,?)");

            pstmt.setBytes(1, anfitrion.getFoto());
            pstmt.setString(2, anfitrion.getCedula());
            pstmt.setString(3, anfitrion.getNombreCompleto());
            pstmt.setString(4, anfitrion.getResidencia());
            pstmt.setString(5, anfitrion.getIdioma());
            pstmt.setString(6, anfitrion.getContrasena());
            pstmt.setString(7, anfitrion.getBiografia());
            pstmt.setString(8, anfitrion.getEstado());
            pstmt.executeUpdate();
            desicion = true;
        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "anfitrion.cedul":
                        throw new CedulaException();

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
    public Anfitrion buscarAnfitrion(String cedula) {
        Anfitrion anfitrion = new Anfitrion();

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,foto,cedula,nombreCompleto,residencia,idioma,contrasena,biografia,estado FROM anfitrion where cedula=?");
            pstmt.setString(1, cedula);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {
                anfitrion.setId(respuesta.getInt("id"));
                anfitrion.setFoto(respuesta.getBytes("foto"));
                anfitrion.setCedula(respuesta.getString("cedula"));
                anfitrion.setNombreCompleto(respuesta.getString("nombreCompleto"));
                anfitrion.setResidencia(respuesta.getString("residencia"));
                anfitrion.setIdioma(respuesta.getString("idioma"));
                anfitrion.setContrasena(respuesta.getString("contrasena"));
                anfitrion.setBiografia(respuesta.getString("biografia"));
                anfitrion.setEstado(respuesta.getString("estado"));
                return anfitrion;
            }

        } catch (SQLException ex) {
            anfitrion = null;
        }
        return null;
    }

    @Override
    public Anfitrion buscarAnfitrionId(int idAnfitrion) {
        Anfitrion anfitrion = new Anfitrion();

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,foto,cedula,nombreCompleto,residencia,idioma,contrasena,biografia,estado FROM anfitrion where id=?");
            pstmt.setInt(1, idAnfitrion);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {
                anfitrion.setId(respuesta.getInt("id"));
                anfitrion.setFoto(respuesta.getBytes("foto"));
                anfitrion.setCedula(respuesta.getString("cedula"));
                anfitrion.setNombreCompleto(respuesta.getString("nombreCompleto"));
                anfitrion.setResidencia(respuesta.getString("residencia"));
                anfitrion.setIdioma(respuesta.getString("idioma"));
                anfitrion.setContrasena(respuesta.getString("contrasena"));
                anfitrion.setBiografia(respuesta.getString("biografia"));
                anfitrion.setEstado(respuesta.getString("estado"));
                return anfitrion;
            }

        } catch (SQLException ex) {
            anfitrion = null;
        }
        return null;
    }

    @Override
    public boolean modificarAnfitrion(Anfitrion anfitrion) throws CedulaException, DatosIncompletosException {
        boolean desicion = false;

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE anfitrion SET  cedula=?,  nombreCompleto=?, residencia=?, idioma=?, contrasena=?, biografia=?, estado=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setString(1, anfitrion.getCedula());
            pstmt.setString(2, anfitrion.getNombreCompleto());
            pstmt.setString(3, anfitrion.getResidencia());
            pstmt.setString(4, anfitrion.getIdioma());
            pstmt.setString(5, anfitrion.getContrasena());
            pstmt.setString(6, anfitrion.getBiografia());
            pstmt.setString(7, anfitrion.getEstado());
            pstmt.setInt(8, anfitrion.getId());
            int res = pstmt.executeUpdate();

            desicion = res > 0;
        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "anfitrion.cedul":
                        throw new CedulaException();

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
    public boolean modificarAnfitrion2(Anfitrion anfitrion) throws CedulaException, DatosIncompletosException {
        boolean desicion = false;

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE anfitrion SET  foto=?, cedula=?,  nombreCompleto=?, residencia=?, idioma=?, contrasena=?, biografia=?, estado=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setBytes(1, anfitrion.getFoto());
            pstmt.setString(2, anfitrion.getCedula());
            pstmt.setString(3, anfitrion.getNombreCompleto());
            pstmt.setString(4, anfitrion.getResidencia());
            pstmt.setString(5, anfitrion.getIdioma());
            pstmt.setString(6, anfitrion.getContrasena());
            pstmt.setString(7, anfitrion.getBiografia());
            pstmt.setString(8, anfitrion.getEstado());
            pstmt.setInt(9, anfitrion.getId());
            int res = pstmt.executeUpdate();

            desicion = res > 0;
        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "anfitrion.cedul":
                        throw new CedulaException();

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
    public ArrayList<Anfitrion> listarAnfitrion() {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,foto,cedula,nombreCompleto,residencia,idioma,contrasena,biografia,estado FROM anfitrion");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Anfitrion> listar = new ArrayList<>();

            boolean condicion = true;

            while (condicion == true) {
                if (respuesta.next()) {
                    Anfitrion anfitrion = new Anfitrion();

                    anfitrion.setId(respuesta.getInt("id"));
                    anfitrion.setFoto(respuesta.getBytes("foto"));
                    anfitrion.setCedula(respuesta.getString("cedula"));
                    anfitrion.setNombreCompleto(respuesta.getString("nombreCompleto"));
                    anfitrion.setResidencia(respuesta.getString("residencia"));
                    anfitrion.setIdioma(respuesta.getString("idioma"));
                    anfitrion.setContrasena(respuesta.getString("contrasena"));
                    anfitrion.setBiografia(respuesta.getString("biografia"));
                    anfitrion.setEstado(respuesta.getString("estado"));
                    listar.add(anfitrion);
                } else {
                    condicion = false;
                }
            }
            return listar;
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

    /**
     * metodo que permite pasar la fecha de tipo java.util.Date a java.sql.Date
     *
     * @param uDate fecha de tipo java.util.Date que se desee cambiar a
     * java.sql.Date
     * @return la fecha lista para ser guardada en mySql
     * @throws DatosIncompletosException si la fecha es null
     */
    private void vaidarCedulas(Administrador administrador, Huesped huesped) throws CedulaAdministradorException, CedulaHuespedException {

        if (administrador != null) {
            throw new CedulaAdministradorException();
        }
        if (huesped != null) {
            throw new CedulaHuespedException();
        }
    }

}
