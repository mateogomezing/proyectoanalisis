/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Definiciones.IDAOHospedaje;
import Excepcion.DatosIncompletosException;
import Excepcion.NombreHospedajeException;
import Modelo.Hospedaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class DAOHospedaje implements IDAOHospedaje {

    @Override
    public boolean guardarHospedaje(Hospedaje hospedaje) throws DatosIncompletosException, NombreHospedajeException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO hospedaje (idAnfitrion,imagen,categoria,tipo,cantidadpersonas,ubicacion,habitaciones,camas,bano,estado,servicios,valorPorNoche) values (?,?,?,?,?,?,?,?,?,?,?,?)");

            pstmt.setInt(1, hospedaje.getIdAnfitrion());
            pstmt.setBytes(2, hospedaje.getImagen());
            pstmt.setString(3, hospedaje.getCategoria());
            pstmt.setString(4, hospedaje.getTipo());
            pstmt.setString(5, hospedaje.getCantidadpersonas());
            pstmt.setString(6, hospedaje.getUbicacion());
            pstmt.setString(7, hospedaje.getHabitaciones());
            pstmt.setString(8, hospedaje.getCamas());
            pstmt.setString(9, hospedaje.getBano());
            pstmt.setString(10, hospedaje.getEstado());
            pstmt.setString(11, hospedaje.getServicios());
            pstmt.setString(12, hospedaje.getValorPorNoche());
            pstmt.executeUpdate();
            desicion = true;
        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "hospedaje.tip":
                        throw new NombreHospedajeException();
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
    public Hospedaje buscarHospedaje(String tipo) {
        Hospedaje hospedaje = new Hospedaje();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idAnfitrion,imagen,categoria,tipo,cantidadpersonas,ubicacion,habitaciones,camas,bano,estado,servicios,valorPorNoche FROM hospedaje where tipo=?");
            pstmt.setString(1, tipo);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();

            if (respuesta.next()) {
                hospedaje.setId(respuesta.getInt("id"));
                hospedaje.setIdAnfitrion(respuesta.getInt("idAnfitrion"));
                hospedaje.setImagen(respuesta.getBytes("imagen"));
                hospedaje.setCategoria(respuesta.getString("categoria"));
                hospedaje.setTipo(respuesta.getString("tipo"));
                hospedaje.setCantidadpersonas(respuesta.getString("cantidadpersonas"));
                hospedaje.setUbicacion(respuesta.getString("ubicacion"));
                hospedaje.setHabitaciones(respuesta.getString("habitaciones"));
                hospedaje.setCamas(respuesta.getString("camas"));
                hospedaje.setBano(respuesta.getString("bano"));
                hospedaje.setEstado(respuesta.getString("estado"));
                hospedaje.setServicios(respuesta.getString("servicios"));
                hospedaje.setValorPorNoche(respuesta.getString("valorPorNoche"));
                return hospedaje;
            }

        } catch (SQLException ex) {
            hospedaje = null;

        }
        return null;
    }

    @Override
    public ArrayList<Hospedaje> buscarHospedajeCiudad(String ciudad) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idAnfitrion,imagen,categoria,tipo,cantidadpersonas,ubicacion,habitaciones,camas,bano,estado,servicios,valorPorNoche FROM hospedaje where ubicacion=?");
            pstmt.setString(1, ciudad);

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Hospedaje> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Hospedaje hospedaje = new Hospedaje();

                    hospedaje.setId(respuesta.getInt("id"));
                    hospedaje.setIdAnfitrion(respuesta.getInt("idAnfitrion"));
                    hospedaje.setImagen(respuesta.getBytes("imagen"));
                    hospedaje.setCategoria(respuesta.getString("categoria"));
                    hospedaje.setTipo(respuesta.getString("tipo"));
                    hospedaje.setCantidadpersonas(respuesta.getString("cantidadpersonas"));
                    hospedaje.setUbicacion(respuesta.getString("ubicacion"));
                    hospedaje.setHabitaciones(respuesta.getString("habitaciones"));
                    hospedaje.setCamas(respuesta.getString("camas"));
                    hospedaje.setBano(respuesta.getString("bano"));
                    hospedaje.setEstado(respuesta.getString("estado"));
                    hospedaje.setServicios(respuesta.getString("servicios"));
                    hospedaje.setValorPorNoche(respuesta.getString("valorPorNoche"));
                    listar.add(hospedaje);
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

    @Override
    public ArrayList<Hospedaje> buscarHospedajeTipo(String ciudad, String tipo) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idAnfitrion,imagen,categoria,tipo,cantidadpersonas,ubicacion,habitaciones,camas,bano,estado,servicios,valorPorNoche FROM hospedaje where ubicacion=? AND categoria=?");
            pstmt.setString(1, ciudad);
            pstmt.setString(2, tipo);

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Hospedaje> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Hospedaje hospedaje = new Hospedaje();

                    hospedaje.setId(respuesta.getInt("id"));
                    hospedaje.setIdAnfitrion(respuesta.getInt("idAnfitrion"));
                    hospedaje.setImagen(respuesta.getBytes("imagen"));
                    hospedaje.setCategoria(respuesta.getString("categoria"));
                    hospedaje.setTipo(respuesta.getString("tipo"));
                    hospedaje.setCantidadpersonas(respuesta.getString("cantidadpersonas"));
                    hospedaje.setUbicacion(respuesta.getString("ubicacion"));
                    hospedaje.setHabitaciones(respuesta.getString("habitaciones"));
                    hospedaje.setCamas(respuesta.getString("camas"));
                    hospedaje.setBano(respuesta.getString("bano"));
                    hospedaje.setEstado(respuesta.getString("estado"));
                    hospedaje.setServicios(respuesta.getString("servicios"));
                    hospedaje.setValorPorNoche(respuesta.getString("valorPorNoche"));
                    listar.add(hospedaje);
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

    @Override
    public boolean modificarHospedaje(Hospedaje hospedaje) throws NombreHospedajeException, DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE hospedaje SET  idAnfitrion=?, imagen=?, categoria=?, tipo=?, cantidadpersonas=?, ubicacion=?, habitaciones=?, camas=?, bano=?, estado=?, servicios=?, valorPorNoche=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setInt(1, hospedaje.getIdAnfitrion());
            pstmt.setBytes(2, hospedaje.getImagen());
            pstmt.setString(3, hospedaje.getCategoria());
            pstmt.setString(4, hospedaje.getTipo());
            pstmt.setString(5, hospedaje.getCantidadpersonas());
            pstmt.setString(6, hospedaje.getUbicacion());
            pstmt.setString(7, hospedaje.getHabitaciones());
            pstmt.setString(8, hospedaje.getCamas());
            pstmt.setString(9, hospedaje.getBano());
            pstmt.setString(10, hospedaje.getEstado());
            pstmt.setString(11, hospedaje.getServicios());
            pstmt.setString(12, hospedaje.getValorPorNoche());
            pstmt.setInt(13, hospedaje.getId());
            int res = pstmt.executeUpdate();
            desicion = res > 0;
        } catch (SQLException ex) {
            //ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "hospedaje.tip":
                        throw new NombreHospedajeException();

                }

            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }
            desicion = false;
        }
        return desicion;
    }

    @Override
    public boolean modificarHospedaje2(Hospedaje hospedaje) throws NombreHospedajeException, DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE hospedaje SET  idAnfitrion=?, categoria=?, tipo=?, cantidadpersonas=?, ubicacion=?, habitaciones=?, camas=?, bano=?, estado=?, servicios=?, valorPorNoche=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setInt(1, hospedaje.getIdAnfitrion());
            pstmt.setString(2, hospedaje.getCategoria());
            pstmt.setString(3, hospedaje.getTipo());
            pstmt.setString(4, hospedaje.getCantidadpersonas());
            pstmt.setString(5, hospedaje.getUbicacion());
            pstmt.setString(6, hospedaje.getHabitaciones());
            pstmt.setString(7, hospedaje.getCamas());
            pstmt.setString(8, hospedaje.getBano());
            pstmt.setString(9, hospedaje.getEstado());
            pstmt.setString(10, hospedaje.getServicios());
            pstmt.setString(11, hospedaje.getValorPorNoche());
            pstmt.setInt(12, hospedaje.getId());
            int res = pstmt.executeUpdate();
            desicion = res > 0;
        } catch (SQLException ex) {
            //ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "hospedaje.tip":
                        throw new NombreHospedajeException();

                }

            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }
            desicion = false;
        }
        return desicion;
    }

    @Override
    public ArrayList<Hospedaje> listarHospedaje() {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idAnfitrion,imagen,categoria,tipo,cantidadpersonas,ubicacion,habitaciones,camas,bano,estado,servicios,valorPorNoche FROM hospedaje");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Hospedaje> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {
                    Hospedaje hospedaje = new Hospedaje();

                    hospedaje.setId(respuesta.getInt("id"));
                    hospedaje.setIdAnfitrion(respuesta.getInt("idAnfitrion"));
                    hospedaje.setImagen(respuesta.getBytes("imagen"));
                    hospedaje.setCategoria(respuesta.getString("categoria"));
                    hospedaje.setTipo(respuesta.getString("tipo"));
                    hospedaje.setCantidadpersonas(respuesta.getString("cantidadpersonas"));
                    hospedaje.setUbicacion(respuesta.getString("ubicacion"));
                    hospedaje.setHabitaciones(respuesta.getString("habitaciones"));
                    hospedaje.setCamas(respuesta.getString("camas"));
                    hospedaje.setBano(respuesta.getString("bano"));
                    hospedaje.setEstado(respuesta.getString("estado"));
                    hospedaje.setServicios(respuesta.getString("servicios"));
                    hospedaje.setValorPorNoche(respuesta.getString("valorPorNoche"));
                    listar.add(hospedaje);
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

}
