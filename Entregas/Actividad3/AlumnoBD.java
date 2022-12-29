package tema4.Entregas.Actividad3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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


    /*Ejecutamos consulta recorremos el resultado */
    public List<Alumno> consultarAlumnos (String clase){
        List<Alumno> aux=new ArrayList<Alumno>();
        ResultSet rsResultado = null;
        String sql="SELECT * FROM alumnos where curso='"+clase+"';";
		try {
			System.out.println("Ejecutando: " + sql);
			PreparedStatement prepStatement = con.prepareStatement(sql);
			rsResultado = prepStatement.executeQuery();


            if (rsResultado != null) {
				// Si hay resultado recuperamos los datos
				while (rsResultado.next()) {
                    Alumno alum= new Alumno(rsResultado.getString("nombre"), rsResultado.getString("fnac"),
                    rsResultado.getDouble("media"), rsResultado.getString("curso"));


                    aux.add(alum);
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}


		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}

       return aux;
       
        
    }

}
