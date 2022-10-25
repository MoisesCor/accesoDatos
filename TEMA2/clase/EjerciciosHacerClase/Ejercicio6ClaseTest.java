package TEMA2.clase.EjerciciosHacerClase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio6ClaseTest {
    public static void main(String[] args) {

        // se puede hacer igual con un array
        
        ArrayList<Ejercicio6> prueba1= new ArrayList<Ejercicio6>();
        prueba1.add(new Ejercicio6("Pedro",  20));
        prueba1.add(new Ejercicio6("Pedro",  20));
        prueba1.add(new Ejercicio6("Pedro",  20));
        prueba1.add(new Ejercicio6("Pedro",  20));

        String nombreFichero = "C:\\Moises\\ppp\\personas.dat";
    try {
        FileOutputStream ficheroSalida = new FileOutputStream(nombreFichero);

    //ObjectOutputStream objetoSalida = new ObjectOutputStream(FileOutputStream ficheroSalida = new FileOutputStream(nombreFichero));
    ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
    // se escriben dos objetos de la clase Persona
        objetoSalida.writeObject( prueba1);

        objetoSalida.close();
    } catch (FileNotFoundException e) {
        System.out.println("¡El fichero no existe!");
    } catch (IOException e) {
        System.out.println(e.getMessage());
     } catch (Exception e) {
        System.out.println(e.getMessage());
    };


    // leer el fichero dat
    
    try {
        FileInputStream ficheroEntrada = new FileInputStream(nombreFichero);
        ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
        // se leen dos objetos de la clase Persona
        ArrayList<Ejercicio6> prueba2= (ArrayList<Ejercicio6>)objetoEntrada.readObject();
        System.out.println(prueba2);
        
        // se cierra el flujo de objetos objetoEntrada
        objetoEntrada.close();
    
        } catch (FileNotFoundException e) {
        System.out.println("¡El fichero no existe!");
        } catch (IOException e) {
        System.out.println(e.getMessage());
        } catch (Exception e) {
        System.out.println(e.getMessage());
        };
        
    }
}
