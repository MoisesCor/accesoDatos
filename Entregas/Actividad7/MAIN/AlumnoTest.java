package tema4.Entregas.Actividad7.MAIN;



import java.sql.SQLException;
import java.util.Scanner;

import tema4.Entregas.Actividad7.DAO.AlumnoDAOImplementation;
import tema4.Entregas.Actividad7.MODEL.Alumno;



public class AlumnoTest {

   public static void main(String[] args) throws SQLException {
   Scanner leer = new Scanner(System.in);
  
    AlumnoDAOImplementation ax = new AlumnoDAOImplementation();

    //creamos un alumno por defecto para insertar en la bbdd
    Alumno al = new Alumno("Actividad7","24-05-1992",2.0,"DAM2");

   int opcion=0;
do{
    System.out.println("****MENÚ OPCIONES***");
    System.out.println("1-Crear usuario");
    System.out.println("2-Ver todos los alumnos de la bbdd");
    System.out.println("3- Ver alumnos de una clase");
    System.out.println("4-Ver nota media alumnos de una clase");
    System.out.println("5-Ver suspensos de una clase");
    System.out.println("6-Actualizar alumno");
    System.out.println("7-Borrar alumno");
    System.out.println("8-Salir");
    opcion=leer.nextInt();

    switch (opcion){
      case 1:
      //En esta opción he elegido crear alumno por defecto, para simplificar
      ax.create(al);
      System.out.println(AlumnoDAOImplementation.retornarID()+" = idgenerado (num)");
     
      break;

      case 2:
      ax.read(opcion);
   
      break;

      case 3:
      ax.read(opcion);
      break;

      case 4:
      ax.read(opcion);
      break;

      case 5:
      ax.read(opcion);
      break;

      case 6:
      System.out.println("Vamos ha actualizar el campo media del alumno creado para el ejercicio");
      al.setMedia(3.9);
      ax.update(al);
      break;

      case 7:
      System.out.println("Vamos a borrar el alumno creado para el ejercicio, con id: "+AlumnoDAOImplementation.retornarID());
      
      ax.delete(AlumnoDAOImplementation.retornarID());
      break;

      case 8:
      System.out.println("Gracias por su visita. Hasta pronto");
      break;

      default:
      System.out.println("Número no contemplado en las opciones");
      break;

    }
    
   }while(opcion!=8);
   leer.close();

   
   
    
   }


    
}
