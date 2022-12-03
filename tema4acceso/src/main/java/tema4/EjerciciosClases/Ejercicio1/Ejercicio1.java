package tema4.EjerciciosClases.Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio1 {
    public static void main(String[] args) {
        Connection con=null;
        Statement sentencia;
        String url="jdbc:mysql://localhost/instituto";

        /*Datos a insertar */
        String nombre="Moises";
        String fnac="12-09-1992";
        double media= 9.0;
        String curso="acceso a datos";

        


        try {
            con= DriverManager.getConnection(url, "alumno", "0123456789");
            sentencia= con.createStatement();

            // Sentencia a insertar datos
        StringBuffer sbCadena= new StringBuffer();
        sbCadena.append("INSERT INTO alumnos (nombre,fnac,media,curso) ");
        sbCadena.append("VALUES ('"+nombre+"','"+fnac+"',"+media+",'"+curso+"');");
        System.out.println("Senrencia a ejecutar "+sbCadena);

        // ejecutamos el insert
        sentencia.executeUpdate(sbCadena.toString());
        System.out.println("se ha insertado el nuevo alumno");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
        
    

