package tema4.Entregas.Actividad7.UTIL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection con = null;

    public static Connection getInstance(){
        String url = "jdbc:mysql://localhost/instituto";
        String urs="alumno";
        String pass="0123456789";
        try {
            if (con == null) {
                con = DriverManager.getConnection(url, urs, pass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static  void desconectar() {
        try {
            con.close();
            con=null;
        } catch (SQLException sqlex) {
            System.out.println("Error: " + sqlex.getMessage());
        }
    }
 }