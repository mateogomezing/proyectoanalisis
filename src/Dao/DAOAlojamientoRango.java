/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import DTO.DTOAlojamientoRango;
import DTO.DTOCiudadDeterminada;
import Definiciones.IDAOAlojamientoRango;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mateo
 */
public class DAOAlojamientoRango implements IDAOAlojamientoRango {

    @Override
    public ArrayList<DTOAlojamientoRango> BuscarAlojamientoRangoDTO(int valorinicial, int valorfinal) {
        ArrayList<DTOAlojamientoRango> listaCiudades = new ArrayList<>();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("select r.id,r.fechaReserva,h.id,h.categoria,h.tipo,h.ubicacion,c.valorApagar from reservahospedaje r join hospedaje h on r.idHabitacion=h.id  join cuentapersonal c on r.id=c.idReservahospedaje where c.valorApagar>=? AND c.valorApagar <=?");
            pstmt.setInt(1, valorinicial);
            pstmt.setInt(2, valorfinal);

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    DTOAlojamientoRango Alojamiento = new DTOAlojamientoRango();

                    Alojamiento.setIdReserva(respuesta.getInt(1));
                    Alojamiento.setFechareservacion(convertirDeDatetimeUtilaDate(respuesta.getString(2)));
                    Alojamiento.setIdhabitacion(respuesta.getInt(3));
                    Alojamiento.setCategoria(respuesta.getString(4));
                    Alojamiento.setTipo(respuesta.getString(5));
                    Alojamiento.setCiudad(respuesta.getString(6));
                    Alojamiento.setRango(respuesta.getString(7));

                    listaCiudades.add(Alojamiento);
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
