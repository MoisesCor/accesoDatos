package TEMA2.main.clase.EjemplosCLase;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class EjemploDir {
    public static void main(String[] args) {
        /*Listado del ficheros del directorio actual */
        File miDir = new File("."); // esto quiere decir la ruta actual
        File miDir2 = new File("."); // esto quiere decir la ruta actual
        String[] archivos = miDir.list();

        String[] archivos2 = miDir2.list();

        for( int i = 0; i< archivos.length; i++){
            System.out.println(archivos[i]);
        }


        //For-each
        for(String elem: archivos){
            System.out.println(elem);
        }

        // esto es llamarlo con lambda
        Arrays.asList(archivos).forEach(System.out::println);;

        //EJERCICIO 2
        System.out.println("Ejercicio 2: ");
        // Crear programa que liste el contenido del actual y lo que contiene dentro
        Arrays.asList(archivos2).forEach(System.out::println);;

        


       
    }
}
