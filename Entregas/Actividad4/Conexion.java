package tema4.Entregas.Actividad4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    Connection con;
    Statement sentencia;
    String url = "jdbc:mysql://localhost/nbaejercicio2";

    // método que se encarga de conectar a la BBDD
    public void conectar() throws SQLException {
        con = DriverManager.getConnection(url, "alumno", "0123456789");
    }

    // método que se encarga de desconectar la BBDD
    public void desconectar() {
        try {
            con.close();
        } catch (SQLException sqlex) {
            System.out.println("Error: " + sqlex.getMessage());
        }
    }

    /*Método que se le pasa por parametro un número formato String (previamente verificado en main que es un número)
     * que equivale a la sentencia (SELECT...) que vamos a realizar sobre la BBDD
     * según el número dará valor a la sentencia con la select correspondiente al menú creado en el main
     * Ejecutamos la sentencia con PreparedStatement y volcamos el resultado en ResultSet
     * Después recorremos con while el ResultSet, depende el valor del numero pasado por parámetro entrará en una condición
     * permitiendo así que si la select es de partidos (por ejemplo) muestre por pantalla los resultados acorde a este tabla
     * y así con las demás. El bucle al llamar al get.. tienes que indicarle que el label(el nombre de la columna) este debe coincidir
     * con el de la BBDD.
     */
    public void ejecutarConsulta(String numero) {
        String sentencia="";
        
        //Dar valor a sentencia según parámetro
        if(numero.equals("1")){
             sentencia="SELECT * FROM estadisticas;";
            }else if(numero.equals("2")){
                sentencia="SELECT * FROM partidos;";
            }else if(numero.equals("3")){
                sentencia="SELECT * FROM jugadores;";
            }else{
                sentencia="SELECT * FROM equipos;";
            }

		ResultSet rsResultado = null;
       

		try {
            // ejecutamos sentencia y recogemos valor
			System.out.println("Ejecutando: " + sentencia);
			PreparedStatement prepStatement = con.prepareStatement(sentencia);
			rsResultado = prepStatement.executeQuery();

            //comprobar si resultado obtuvo valor, si lo cumple recorre el resultado, si no imprime mensaje de no resultados
            if (rsResultado != null) {
				
				while (rsResultado.next()) {

                    //ESTADÍSTICAS
                    if(numero.equals("1")){
                    System.out.print("Temoporada: "+rsResultado.getString("temporada")+", ");
                    System.out.print("Jugador: "+rsResultado.getString("jugador")+", ");
                    System.out.print("Puntos_por_partido: "+rsResultado.getDouble("Puntos_por_partido")+", ");
                    System.out.print("Asistencias_por_partido: "+rsResultado.getDouble("Asistencias_por_partido")+", ");
                    System.out.print("Tapones_por_partido: "+rsResultado.getDouble("Tapones_por_partido")+", ");
                    System.out.print("Rebotes_por_partido: "+rsResultado.getDouble("Rebotes_por_partido"));
                    System.out.println("");

                    //PARTIDOS
                    }else if(numero.equals("2")){
                        System.out.print("Codigo: " + rsResultado.getInt("codigo")+", ");
                        System.out.print("Equipo Visitante: " + rsResultado.getString("equipo_visitante")+ ", ");
                        System.out.print("Puntos Local: " + rsResultado.getInt("puntos_local") +", ");
                        System.out.print("Puntos Visitante: " + rsResultado.getInt("puntos_visitante") +", ");
                        System.out.print("Temporada: " + rsResultado.getString("temporada"));
                        System.out.println("");

                    //JUGADORES
                    }else if(numero.equals("3")){
                        System.out.print("Codigo: " + rsResultado.getInt("codigo")+", ");
                        System.out.print("Nombre: " + rsResultado.getString("Nombre")+ " ");
                        System.out.print("Procedencia: " + rsResultado.getString("Procedencia") +", ");
                        System.out.print("Altura: " + rsResultado.getString("Altura") +", ");
                        System.out.print("Peso: " + rsResultado.getInt("Peso")+" ");
                        System.out.print("Posicion: " + rsResultado.getString("Posicion")+", ");
                        System.out.print("Equipo: " + rsResultado.getString("Nombre_equipo"));
                        System.out.println("");

                    //EQUIPOS
                    }else{
                        System.out.print("Nombre: " + rsResultado.getString("Nombre")+ ", ");
                        System.out.print("Ciudad: " + rsResultado.getString("Ciudad") +", ");
                        System.out.print("Conferencia: " + rsResultado.getString("Conferencia") +", ");
                        System.out.print("Division: " + rsResultado.getString("Division"));
                        System.out.println("");
                    }
				}
			} else {
				System.out.println("La consulta no devuelve resultados");
			}

            


		} catch (SQLException sqlex) {
			System.out.println("Error: " + sqlex.getMessage());
		}
		
	}


   

    
}
