package tema4.Entregas.Actividad5;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Actividad5TestMois {
    
    public static void main(String[] args) throws SQLException {
        /*En el main: se crea una instancia a la clase conexión para poder acceder a los diferentes métodos
         * instancia de Scanner para poder leer por pantalla
         * Creacción de variable donde se recogerá lo introducido por teclado
         * Creamos Matcher, Pattern, dandole un patrón de los números permitidos a introduccir,
         * con ello nos aseguramos que lo que se introduce, es justo lo que queremos, limitamos posibles errores
         * bucle do while, donde aparece las opciones de menú, que se repetirá hasta que usuario decida salir.
         * Según la opción elegida realizadará una condición
         */
        Conexion conexion = new Conexion();
        
        Scanner leer= new Scanner(System.in);
        String opcion="";
        Matcher mat = null;
		Pattern pat1 = Pattern.compile("1||2||3||4||5");
        do{
            System.out.println("****Indica tabla que desea consultar****");
            System.out.println("1-Tabla estadísticas");
            System.out.println("2-Tabla partdios");
            System.out.println("3-Tabla jugadores");
            System.out.println("4-Tabla equipos");
            System.out.println("5-Salir");
            opcion= leer.next();
            mat= pat1.matcher(opcion);
            if(!mat.matches()){
                System.out.println("Caracter no válido, recuerda solo números del 1 al 5");
            }else{
                 if(opcion.equals("5")){
                    System.out.println("Hasta pronto");
                 }else{
                    conexion.conectar();
                    conexion.ejecutarConsulta(opcion);
                    conexion.desconectar();
                 }
            }


             
        }while(!opcion.equals("5"));
        leer.close();
        
        
    }
}
