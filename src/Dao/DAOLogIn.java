/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Definiciones.IDAOLogIn;
import Modelo.Administrador;
import Modelo.Anfitrion;
import Modelo.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mateo
 */
public class DAOLogIn implements IDAOLogIn {

    @Override
    public Huesped LogInHuesped(String cedula, String contrasena) {
        Huesped huesped = new Huesped();

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,foto,cedula,nombreCompleto,genero,correo,telefono,direccion,fechaNacimiento,nacionalidad,contrasena,tipo,estado,biografia FROM huesped where cedula=? AND contrasena=?");
            pstmt.setString(1, cedula);
            pstmt.setString(2, contrasena);

            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                huesped.setId(respuesta.getInt("id"));
                huesped.setFoto(respuesta.getBytes("foto"));
                huesped.setCedula(respuesta.getString("cedula"));
                huesped.setNombreCompleto(respuesta.getString("nombreCompleto"));
                huesped.setGenero(respuesta.getString("genero"));
                huesped.setCorreo(respuesta.getString("correo"));
                huesped.setTelefono(respuesta.getString("telefono"));
                huesped.setDireccion(respuesta.getString("direccion"));
                huesped.setFechaNacimiento(respuesta.getDate("fechaNacimiento"));
                huesped.setNacionalidad(respuesta.getString("nacionalidad"));
                huesped.setContrasena(respuesta.getString("contrasena"));
                huesped.setTipo(respuesta.getString("tipo"));
                huesped.setEstado(respuesta.getString("estado"));
                huesped.setBiografia(respuesta.getString("biografia"));
                return huesped;

            }

        } catch (SQLException ex) {
            huesped = null;
        }
        return null;
    }

    @Override
    public Administrador LogInAdministrador(String cedula, String contrasena) {
        Administrador administrador = new Administrador();

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,cedula,nombreCompleto,contrasena FROM administrador WHERE cedula=? AND contrasena=?");
            pstmt.setString(1, cedula);
            pstmt.setString(2, contrasena);
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                administrador.setId(respuesta.getInt("id"));
                administrador.setCedula(respuesta.getString("cedula"));
                administrador.setNombrecompleto(respuesta.getString("nombreCompleto"));
                administrador.setContrasena(respuesta.getString("contrasena"));

                return administrador;
            }
        } catch (SQLException ex) {
            administrador = null;

        }
        return null;
    }

    @Override
    public Anfitrion LogInAnfitrion(String cedula, String contrasena) {
        Anfitrion anfitrion = new Anfitrion();

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,foto,cedula,nombreCompleto,residencia,idioma,contrasena,biografia,estado FROM anfitrion where cedula=? AND contrasena=?");
            pstmt.setString(1, cedula);
            pstmt.setString(2, contrasena);

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

}
