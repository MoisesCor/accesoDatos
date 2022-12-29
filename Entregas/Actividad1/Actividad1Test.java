package tema4.Entregas.Actividad1;

import java.sql.SQLException;
import javax.xml.bind.JAXBException;

public class Actividad1Test {
    public static void main(String[] args) throws JAXBException, SQLException {
        AlumnoBD conexionActividad1 = new AlumnoBD();
        
        //Conectar a la BBDD:
        System.out.println("Conectando a la BBDD...");
        conexionActividad1.conectar();

        //Inserción de datos:
        System.out.println("Insertando datos...");
        System.out.print("Resultado de inserción en la tabla alumnos: ");
        System.out.println(conexionActividad1.insertarAlumnos(Utilidades.crearObjetos()));

       
        //Desconexión BBDD
        System.out.println("Cerrando conexión...");
        conexionActividad1.desconectar();
        

    }
}
