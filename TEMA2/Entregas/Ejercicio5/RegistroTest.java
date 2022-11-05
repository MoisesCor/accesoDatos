package TEMA2.Entregas.Ejercicio5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RegistroTest {
    public static void main(String[] args) throws IOException {
        int opcion;
        Scanner leer = new Scanner(System.in);
        String datos[]= new String[4];
        String ciudad;

        // Carga inicial de datos Llama  mettodo utilidades donde crea objetos o los carga si el fichero ya existe
        ArrayList<Registro> registroTemperatura = UtilidadesREGISTRO.datosPredeterminados();
   



        do{
            System.out.println("1-Registrar nueva temperatura"+ "\n"+
                               "2-Mostrar historial de registros"  + "\n"+
                               "3-Mostrar media de temperatura"+ "\n"+
                               "4-Salir");
            opcion=leer.nextInt();
            switch(opcion){
                case 1:
                System.out.println("Introduce Ciudad");
                datos[0]=leer.next().replaceAll(" ", "");
              

                System.out.println("Introduce fecha");
                datos[1]=leer.next().replaceAll(" ", "");
              

                System.out.println("Introduce temperatura MAX");
                datos[2]=leer.next().replaceAll(" ", "");
                

                System.out.println("Introduce temperatura MIN");
                datos[3]=leer.next().replaceAll(" ", "");
                registroTemperatura = UtilidadesREGISTRO.ayadirNuevaTemperatura(datos,registroTemperatura);
               
                break;

                case 2:
                System.out.println("Introduce ciudad a consultar");
                UtilidadesREGISTRO.verCIudad(ciudad=leer.next(),registroTemperatura);
                break;

                case 3:
                System.out.println("Introduce Ciudad que quieras saber su media de temperatura");
               UtilidadesREGISTRO.mediaCIudad(ciudad=leer.next(),registroTemperatura);
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


