/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.DTOReservaActiva;
import Definiciones.IDAOMiCuenta;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mateo
 */
public class DAOMiCuenta implements IDAOMiCuenta {

    @Override
    public ArrayList<DTOReservaActiva> BuscarReservaActiva(int idHuesped) {
        ArrayList<DTOReservaActiva> listareservas = new ArrayList<>();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("Select r.id,r.fechaCheckIn,r.idHabitacion,r.estado,c.valorApagar from cuentaPersonal c join reservaHospedaje r  on c.idReservahospedaje=r.id where r.idHuesped=?");
            pstmt.setInt(1, idHuesped);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    DTOReservaActiva reservas = new DTOReservaActiva();

                    reservas.setIdreserva(respuesta.getInt(1));
                    reservas.setFechareservacion(convertirDeDatetimeUtilaDate(respuesta.getString(2)));
                    reservas.setIdhabitacion(respuesta.getInt(3));
                    reservas.setEstado(respuesta.getString(4));
                    reservas.setValor(respuesta.getString(5));
                    listareservas.add(reservas);

                } else {
                    condicion = false;
                }
            }

            return listareservas;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }

        return listareservas;
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
