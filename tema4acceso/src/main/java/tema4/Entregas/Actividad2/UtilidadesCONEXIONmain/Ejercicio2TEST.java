package tema4.Entregas.Actividad2.UtilidadesCONEXIONmain;

import java.sql.SQLException;

import javax.xml.bind.JAXBException;

public class Ejercicio2TEST {
    public static void main(String[] args) throws SQLException, JAXBException {
        Conexion conexionActividad2 = new Conexion();

        // Conectamos
        System.out.println("Conectando a la BBDD.......");
        conexionActividad2.conectar();

        //Inserción de datos de las diferentes tablas:
        System.out.println("Inserción de registros en la BBDD.....");

        //Equipos:
        System.out.print("Resultado de inserción en la tabla EQUIPOS: ");
       System.out.println(conexionActividad2.insertarEquipos(Utilidades.cargarEquipos()));

        //Jugadores:
        System.out.print("Resultado de inserción en la tabla jUGADORES: ");
        System.out.println(conexionActividad2.insertarJugadores(Utilidades.cargarJugadores()));

        //Partidos:
        System.out.print("Resultado de inserción en la tabla PARTIDOS: ");
        System.out.println(conexionActividad2.insertarPartidos(Utilidades.cargarPartidos()));

        //Estadisticas:
        System.out.print("Resultado de inserción en la tabla ESTADISTICAS: ");
        System.out.println(conexionActividad2.insertarEstadisticas(Utilidades.cargarEstadisticas()));

        System.out.println("Cerrando conexión...");
        conexionActividad2.desconectar();
    }
}
