package TEMA2.Entregas.Ejercicio6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilidadesCLIENTES_SER {
    static ObjectOutputStream objetoSalida;
    static String nombreFichero = "C:\\Moises\\ppp\\ejercicio6\\clientes.dat";
    static FileOutputStream ficheroSalida;
    static Scanner leer = new Scanner(System.in);

    public static TreeSet<ClientesSer> datosPredeterminados() throws IOException{
        /* Método usado para crear los clientes y el fichero seriezable
         * comprobamos si el fichero existe, si existe crea un TreeSet de registros desde el fichero
         si o crea los objetos , un fichero y lo vuelca a mismo
         */
        TreeSet<ClientesSer> registroClientes = new TreeSet<ClientesSer>();
         File fichero = new File(nombreFichero);
         if(!fichero.exists()){
             System.out.println("NO EXISTO ME CREO");
             ficheroSalida = new FileOutputStream(nombreFichero);
             ObjectOutputStream objetoSalida = new ObjectOutputStream( ficheroSalida);
             registroClientes.add(new ClientesSer("9999999E", "Moises", "12/09/1992", "122.11"));
             registroClientes.add(new ClientesSer("8888888E", "Laura", "12/09/1900", "1000000"));
             registroClientes.add(new ClientesSer("7777777E", "Pepe", "12/09/2000", "2000.3"));
             registroClientes.add(new ClientesSer("6666666E", "Lydia", "12/09/1997", "70000.700"));
             
             objetoSalida.writeObject( registroClientes );
             objetoSalida.close();
             
         }else{
             FileInputStream ficheroEntrada = new FileInputStream(nombreFichero);
             ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
             try {
                 System.out.println("Ya existo me cargo del fichero");
                
                 registroClientes =(TreeSet<ClientesSer>)objetoEntrada.readObject();
             } catch (ClassNotFoundException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
         }
        
         return registroClientes;
 }

 public static TreeSet<ClientesSer> introduceNuevoCliente(TreeSet<ClientesSer> modificar) throws IOException{
    /* Creación de un nuevo cliente pidiendo y comprobando los datos, sobreescribiendo el fichero existente y volviendolo a cargar */
    Matcher mat = null;
    Pattern pat1 = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})");
    
    String[] datos= new String[4];
    System.out.println("Introduce DNI cliente");
    datos[0]=leer.next().replaceAll(" ", "");
   

    System.out.println("Introduce nombre cliente");
    datos[1]=leer.next().replaceAll(" ", "");
  

    do{
    System.out.println("Introduce fecha nacimiento cliente FORMATO 01/09/1992");
    datos[2]=leer.next();
    mat= pat1.matcher(datos[2]);
    if(!mat.matches()){
        System.out.println("formato de fecha incorrecto");
    }else{
        datos[2]=datos[2].replaceAll(" ", "");
        
    }
   
    }while(!mat.matches());

    System.out.println("Introduce saldo cliente");
    datos[3]=leer.next().replaceAll(",", "\\.").replaceAll(" ", "");;
   

    File fichero = new File(nombreFichero);
    try  {
      
        if(fichero.exists()){
            modificar.add(new ClientesSer(datos[0], datos[1], datos[2], datos[3]));
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
    return datosPredeterminados(); 

}

public static void calcularMediaDinero() throws IOException{
    /* método para calcular la medía*/
    TreeSet<ClientesSer> listaAux= datosPredeterminados();
    double media=0;
    for(ClientesSer aux: listaAux){
        media= media+ aux.getdSaldo();
    }
    System.out.println(media/listaAux.size());
}

public static TreeSet<ClientesSer> eliminarCLiente(TreeSet<ClientesSer> lista) throws IOException{
    /* Método que  creamos una lista sin el cliente a elimirar y sobreescribimos el fichero y volvemos a cargar los datos */
    Boolean ok=false;
    TreeSet<ClientesSer> listaAux = new TreeSet<ClientesSer>();
    System.out.println("Introduce DNI cliente que quieres borrar");
    String dni=leer.next().replaceAll(" ", "");

    for(ClientesSer compr: lista){
        if(!compr.getsDNI().toUpperCase().equals(dni.toUpperCase())){
            listaAux.add(compr);  
        }
       
    }
    File fichero = new File(nombreFichero);
    try  {
      
        if(fichero.exists()){
            ficheroSalida = new FileOutputStream(nombreFichero);
            ObjectOutputStream objetoSalida = new ObjectOutputStream( ficheroSalida);
            objetoSalida.writeObject(listaAux);
            objetoSalida.close();
        }else{
            System.err.println("Ficher inexistente, se ha creado con los datos por defecto, ahora puedes consultarlo");
    
        }
    
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return datosPredeterminados();

}

}



