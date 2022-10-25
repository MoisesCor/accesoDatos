package TEMA2.clase.EjerciciosHacerClase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Ejercicio5 {
    
    private static final File File = null;

    public static void main(String[] args)  {
        Scanner leer=new Scanner(System.in);
        int menu=0;
        String ruta="";
        do{
            System.out.println("MENU FICHEROS");
            System.out.println("1 Copiar fichero");
            System.out.println("2 Listar directorio");
            menu=leer.nextInt();
            switch(menu){
                case 1:
                    System.out.println("Introduce ruta fichero");
                    ruta=leer.next();
                    boolean ok= copiarFichero(ruta);


                    
                    break;
                case 2:
                System.out.println("Introduce ruta fichero");
                ruta=leer.next();
                boolean ok2= copiarFichero(ruta);
                    break;
                default :
                    break;
            }


        }while(menu!=3);
    }

    public static boolean copiarFichero(String ruta) {
       

        File origen = new File(ruta);
        System.out.println(origen.getPath());
            String subca="";
            subca= origen.getPath();
            subca=subca.replaceAll(origen.getName(), "copia_de_"+origen.getName());
            File destino = new File(subca);
       
        try {
            
            InputStream padre = new FileInputStream(origen);
            OutputStream hijo = new FileOutputStream(destino);
    
            byte[] buf = new byte[1024];
            int len;
    
                while ((len = padre.read(buf)) > 0) {
                    
                        hijo.write(buf, 0, len);
                   
                }     
                padre.close();
                hijo.close();  

        } catch (Exception e) {
            // TODO: handle exception
        }
       

        
        return true;
     }
         

    public static boolean listarDirectorio(String ruta){
       
        return false;
    }
}
