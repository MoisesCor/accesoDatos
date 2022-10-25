package TEMA2.Entregas.Ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;

public class meteoTest2FORMA {
    public static void main(String[] args) {
        int opcion;
        Scanner leer = new Scanner(System.in);
        String ciudad,cadena="";
        ArrayList<meteForma2OBJETOS> lista1= meteForma2OBJETOS.meteForma2OBJETOS();
       /* Para poder llamar a un método de una clase sin crear objeto antes el método debe ir 
        * en estatico así se puede instar.
        */


        do{
            System.out.println("1-Registrar nueva temperatura"+ "\n"+
                               "2-Mostrar historial de registros"  + "\n"+
                               "3-Mostrar media de temperatura"+ "\n"+
                               "4-Salir");
            opcion=leer.nextInt();
            switch(opcion){
                case 1:
                System.out.println("Introduce Ciudad");
                ciudad=leer.next().replaceAll(" ", "");
                cadena+=ciudad+" ";

                System.out.println("Introduce fecha");
                ciudad=leer.next().replaceAll(" ", "");
                cadena+=ciudad+" ";

                System.out.println("Introduce temperatura MAX");
                ciudad=leer.next().replaceAll(" ", "");
                cadena+=ciudad+" ";

                System.out.println("Introduce temperatura MIN");
                ciudad=leer.next().replaceAll(" ", "");
                cadena+=ciudad+" ";

                meteForma2OBJETOS.introduceNuevaT(cadena);
                break;

                case 2:
                System.out.println("Introduce Ciudad");
                meteForma2OBJETOS.verCIudad(ciudad=leer.next());
                break;

                case 3:
                System.out.println("Introduce Ciudad a registrar");
                meteForma2OBJETOS.mediaCIudad(ciudad=leer.next());
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
