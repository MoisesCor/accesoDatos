package tema4.Entregas.Actividad2.UtilidadesCONEXIONmain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tema4.Entregas.Actividad2.Equipos.PoEquipo;
import tema4.Entregas.Actividad2.Estadisticas.PoEstadistica;
import tema4.Entregas.Actividad2.Jugadores.PoJugador;
import tema4.Entregas.Actividad2.Partidos.PoPartido;


public class Conexion {
    Connection con = null;
    Statement sentencia;
    String url = "jdbc:mysql://localhost/nbaejercicio2";

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


    public boolean insertarEquipos(List<PoEquipo> equipos) {
        boolean ok= false;
        String sInsert = "INSERT INTO equipos (Nombre,Ciudad,Conferencia,Division) values (?,?,?,?)";
        try {
         //   System.out.println("Ejecutando: " + sInsert);
            PreparedStatement prepStatement = con.prepareStatement(sInsert);
            for (PoEquipo aux : equipos) {
                prepStatement.setString(1, aux.getNombre());
                prepStatement.setString(2, aux.getCiudad());
                prepStatement.setString(3, aux.getConferencia());
                prepStatement.setString(4, aux.getDivision());
                prepStatement.executeUpdate();
                ok = true;
            }

        } catch (SQLException sqlex) {
            System.out.println("Error: " + sqlex.getMessage());
            sqlex.printStackTrace();
          
        }
        return ok;
    }

    public boolean insertarJugadores(List<PoJugador> jugadores) {
        boolean ok= false;
        String sInsert = "INSERT INTO jugadores (Nombre,Procedencia,Altura,Peso,Posicion,Nombre_equipo) values (?,?,?,?,?,?)";
        try {
          //  System.out.println("Ejecutando: " + sInsert);
            PreparedStatement prepStatement = con.prepareStatement(sInsert);
            for (PoJugador aux : jugadores) {
                prepStatement.setString(1, aux.getNombre());
                prepStatement.setString(2, aux.getProcedencia());
                prepStatement.setString(3, aux.getAltura());
                prepStatement.setInt(4, aux.getPeso());
                prepStatement.setString(5, aux.getPosicion());
                prepStatement.setString(6, aux.getNombreEquipo());
                prepStatement.executeUpdate();
                ok = true;
            }

        } catch (SQLException sqlex) {
            System.out.println("Error: " + sqlex.getMessage());
            sqlex.printStackTrace();
          
        }
        return ok;
    }

    public boolean insertarPartidos(List<PoPartido> partidos) {
        boolean ok= false;
        String sInsert = "INSERT INTO partidos (equipo_local,equipo_visitante,puntos_local,puntos_visitante,temporada) values (?,?,?,?,?)";
        try {
         //   System.out.println("Ejecutando: " + sInsert);
            PreparedStatement prepStatement = con.prepareStatement(sInsert);
            for (PoPartido aux : partidos) {
                prepStatement.setString(1, aux.getEquipoLocal());
                prepStatement.setString(2, aux.getEquipoVisitante());
                prepStatement.setInt(3, aux.getPuntosLocal());
                prepStatement.setInt(4, aux.getPuntosVisitante());
                prepStatement.setString(5, aux.getTemporada());
                prepStatement.executeUpdate();
                ok = true;
            }

        } catch (SQLException sqlex) {
            System.out.println("Error: " + sqlex.getMessage());
            sqlex.printStackTrace();
          
        }
        return ok;
    }

    public boolean insertarEstadisticas(List<PoEstadistica> estadisticas) {
        boolean ok= false;
        String sInsert = "INSERT INTO estadisticas (temporada,jugador,Puntos_por_partido,Asistencias_por_partido,Tapones_por_partido,Rebotes_por_partido) values (?,?,?,?,?,?)";
        try {
         //   System.out.println("Ejecutando: " + sInsert);
            PreparedStatement prepStatement = con.prepareStatement(sInsert);
            for (PoEstadistica aux : estadisticas) {
                prepStatement.setString(1, aux.getTemporada());
                prepStatement.setInt(2, aux.getJugador());
                prepStatement.setDouble(3, aux.getPuntosPORpartido());
                prepStatement.setDouble(4, aux.getAsistenciasPORpartido());
                prepStatement.setDouble(5, aux.getTaponesPORpartido());
                prepStatement.setDouble(6, aux.getRebotesPORpartido());
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
