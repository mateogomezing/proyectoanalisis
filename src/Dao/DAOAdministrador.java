/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Definiciones.IDAOAdministrador;
import Modelo.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mateo
 */
public class DAOAdministrador implements IDAOAdministrador {

    @Override
    public Administrador buscarAdministrador(String cedula) {
        Administrador administrador = new Administrador();

        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,cedula,nombreCompleto,contrasena FROM administrador where cedula=?");
            pstmt.setString(1, cedula);

            //Resultset guarda los datos de la busqueda
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

}
