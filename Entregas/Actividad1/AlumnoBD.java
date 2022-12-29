package tema4.Entregas.Actividad1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class AlumnoBD {
    Connection con = null;
    Statement sentencia;
    String url = "jdbc:mysql://localhost/instituto";

    public void conectar() throws SQLException {
        con = DriverManager.getConnection(url, "alumno", "0123456789");
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException sqlex) {
            System.out.println("Error: " + sqlex.getMessage());
        }
    }

    public boolean insertarAlumnos(List<Alumno> listaAlumnos) {
        boolean ok= false;
        String sInsert = "INSERT INTO alumnos (nombre,fnac,media,curso) values (?,?,?,?)";
        try {
           // System.out.println("Ejecutando: " + sInsert);
            PreparedStatement prepStatement = con.prepareStatement(sInsert);
            for (Alumno aux : listaAlumnos) {
                prepStatement.setString(1, aux.getNombre());
                prepStatement.setString(2, aux.getFnac());
                prepStatement.setDouble(3, aux.getNotaMedia());
                prepStatement.setString(4, aux.getCurso());
                prepStatement.executeUpdate();
                ok = true;
            }

        } catch (SQLException sqlex) {
            System.out.println("Error: " + sqlex.getMessage());
            sqlex.printStackTrace();
          
        }
        return ok;
    }
}
