/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.DTOCiudadDeterminada;
import Definiciones.IDAOCiudadDeterminada;
import java.sql.Connection;
import java.util.ArrayList;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mateo
 */
public class DAOCiudadDeterminada implements IDAOCiudadDeterminada {

    @Override
    public ArrayList<DTOCiudadDeterminada> BuscarCiudadDeterminadaDTO(String ciudad) {
        ArrayList<DTOCiudadDeterminada> listaCiudades = new ArrayList<>();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("select r.id,r.fechaReserva,h.id,h.categoria,h.tipo,h.ubicacion,hu.cedula,hu.nombreCompleto,hu.nivelestudio,hu.estrato,r.estado from reservahospedaje r join hospedaje h on r.idHabitacion=h.id join huesped hu on r.idHuesped=hu.id where h.ubicacion=?");
            pstmt.setString(1, ciudad);

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    DTOCiudadDeterminada ciudadDeterminada = new DTOCiudadDeterminada();

                    ciudadDeterminada.setIdReserva(respuesta.getInt(1));
                    ciudadDeterminada.setFechareservacion(convertirDeDatetimeUtilaDate(respuesta.getString(2)));
                    ciudadDeterminada.setIdhabitacion(respuesta.getInt(3));
                    ciudadDeterminada.setCategoria(respuesta.getString(4));
                    ciudadDeterminada.setTipo(respuesta.getString(5));
                    ciudadDeterminada.setCiudad(respuesta.getString(6));
                    ciudadDeterminada.setCedulaCliente(respuesta.getString(7));
                    ciudadDeterminada.setNombreCompleto(respuesta.getString(8));
                    ciudadDeterminada.setNivelEstudio(respuesta.getString(9));
                    ciudadDeterminada.setEstrato(respuesta.getString(10));
                    ciudadDeterminada.setEstado(respuesta.getString(11));
                    listaCiudades.add(ciudadDeterminada);
                } else {
                    condicion = false;
                }
            }
            return listaCiudades;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return listaCiudades;
    }

    /**
     * Metodo convertir el datetime de la base de datos a tipo date
     *
     * @param datetime objeto de la fechatime de la base dato
     * @return objeto tipo dato
     */
    private Date convertirDeDatetimeUtilaDate(String datetime) {
        SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//      dd/MM/yyyy
        try {
            Date date6 = formatter6.parse(datetime);
            return date6;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }
}
