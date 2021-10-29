/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mateo
 */
public class Conexion {
    public static Connection getConnection() {
        Connection con = null;
        try {
            //Cargamos el driver
            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://localhost:3306/hotelsolar?useSSL=false";
            String user = "root";
            String password = "Ingmateo1336";//Ingmateo1336
            //AGREGAR LIBRERIA JDBC
            con = DriverManager.getConnection(db, user, password);
        } catch (ClassNotFoundException ex) {
            System.err.println("Hubo un error al buscar la clase");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Hubo un error al conectar");
        }
        return con;
    }
}
