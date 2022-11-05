package TEMA2.Entregas.Ejercicio5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UtilidadesREGISTRO  {
    static ObjectOutputStream objetoSalida;
    static String nombreFichero = "C:\\Moises\\ppp\\ejercicio5\\Registro.dat";
    static FileOutputStream ficheroSalida;
    static Scanner leer = new Scanner(System.in);

    
    public static ArrayList<Registro> datosPredeterminados() throws IOException{
       /* Método usado para crear los registros y el fichero seriezable
        * comprobamos si el fichero existe, si existe crea un arraylist de registros desde el fichero
        si o crea los objetos , un fichero y lo vuelca a mismo
        */
        ArrayList<Registro> registroTemperatura = new ArrayList<Registro>();
        File fichero = new File(nombreFichero);
        if(!fichero.exists()){
            System.out.println("NO EXISTO ME CREO");
            ficheroSalida = new FileOutputStream(nombreFichero);
            ObjectOutputStream objetoSalida = new ObjectOutputStream( ficheroSalida);

            registroTemperatura.add(new Registro("Madrid", "2022-10-01", 25, 15));
            registroTemperatura.add(new Registro("Tomelloso", "2022-10-01", 27, 12));
            registroTemperatura.add(new Registro("Guadalajara", "2022-10-01", 23, 16));
            registroTemperatura.add(new Registro("Madrid", "2022-10-01", 23, 11));
            objetoSalida.writeObject( registroTemperatura);
            objetoSalida.close();
            
        }else{
            FileInputStream ficheroEntrada = new FileInputStream(nombreFichero);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
            try {
                System.out.println("Ya existo me cargo del fichero");
               
                registroTemperatura =(ArrayList<Registro>)objetoEntrada.readObject();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       
        return registroTemperatura;
}

// Método donde creamos un registro nuevo lo añadimos a la lista y la sobreescribimos y tambien el fichero
public static ArrayList<Registro> ayadirNuevaTemperatura(String lista[],ArrayList<Registro> modificar) throws IOException{
    File fichero = new File(nombreFichero);
    try  {
      
        if(fichero.exists()){
            modificar.add(new Registro(lista[0], lista[1], Integer.parseInt(lista[2]), Integer.parseInt(lista[2])));
            ficheroSalida = new FileOutputStream(nombreFichero);
            ObjectOutputStream objetoSalida = new ObjectOutputStream( ficheroSalida);
            objetoSalida.writeObject(modificar);
            objetoSalida.close();
        }else{
            System.err.println("Ficher inexistente, se ha creado con los datos por defecto, ahora puedes consultarlo");
    
        }
    
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return modificar;
}
//Recorremos un array buscando la ciudad introducida y la sacamos por pantalla
public static void verCIudad(String nombreCiu,ArrayList<Registro> aux) throws IOException{
    for(Registro muni:aux ){
        if(muni.getsCiudad().toUpperCase().equals(nombreCiu.toUpperCase())){
            System.out.println(muni);
        }
    }
}

public static void mediaCIudad(String nombreCiu,ArrayList<Registro> aux) throws IOException{
    /* Sacamos media de temperatura de un registro, y luego la media de todos sus registros */
    int x=0,contador=0;
    for(Registro muni:aux ){
        if(muni.getsCiudad().toUpperCase().equals(nombreCiu.toUpperCase())){
            System.out.println(muni+" y su media ="+muni.calcularMedia());
            x+=muni.calcularMedia();
            contador++;// contamos cuantas veces aparece esa ciudad, para luego sacar su media total
        }
    }
    System.out.println(nombreCiu.toUpperCase()+
    " Tiene una media de temperatura en su total de registros "+x/contador);
}
}
