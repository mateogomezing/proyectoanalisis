/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Definiciones.IDAOOpiniones;
import Modelo.Opiniones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class DAOOpiniones implements IDAOOpiniones {

    @Override
    public ArrayList<Opiniones> buscarOpinionAdministrador(int idHospedaje) {
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idHuesped,idHospedaje,calificacion,descripcion FROM opiniones where idHospedaje=?");
            pstmt.setInt(1, idHospedaje);

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Opiniones> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    Opiniones opinion = new Opiniones();

                    opinion.setId(respuesta.getInt("id"));
                    opinion.setIdHuesped(respuesta.getInt("idHuesped"));
                    opinion.setIdHospedaje(respuesta.getInt("idHospedaje"));
                    opinion.setCalificacion(respuesta.getString("calificacion"));
                    opinion.setDescripcion(respuesta.getString("descripcion"));

                    listar.add(opinion);

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

}
