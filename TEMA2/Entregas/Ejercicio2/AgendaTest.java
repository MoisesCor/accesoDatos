package TEMA2.Entregas.Ejercicio2;
import java.util.Scanner;

public class AgendaTest {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int opcion=0;
        String nombre;
        int telefono;
        Agenda2 ag= new Agenda2();
       

        do{
            System.out.println("1-Nuevo contacto"+ "\n"+
                               "2-Buscar por nombres"  + "\n"+
                               "3-Mostrar todos"+ "\n"+
                               "4-Salir");
            opcion=leer.nextInt();
            switch(opcion){
                case 1:
                System.out.println("Nombre");
                nombre=leer.next().toUpperCase();
                System.out.println("Número de teléfono");
                telefono=leer.nextInt();
                System.out.println(ag.crearNuevoContacto(nombre, telefono));
                break;

                case 2:
                System.out.println(" Introduce patrón de busqueda");
                nombre=leer.next().toUpperCase();
                ag.buscarContacto(nombre);
                break;

                case 3:
                ag.listarAgenda();
                break;
                case 4:
                System.out.println("ADIOS");
                break;
                default:
                break;
            }

        }while(opcion!=4);
        
       
    }

  
}
