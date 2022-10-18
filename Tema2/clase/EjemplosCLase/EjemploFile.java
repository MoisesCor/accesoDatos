package TEMA2.main.clase.EjemplosCLase;

import java.io.File;

public class EjemploFile {

    final static String RUTA_FICH="C:\\Users\\Moisés\\Desktop\\DAM 2\\Acceso a datos\\TEMA2";
    public static void main(String[] args) {
        
        // 1 constructor con String
         File fich1 = new File("c:prueba.txt");

         // 2 constructor con ruta+nombre
        File fich2 = new File(RUTA_FICH,"prueba.txt");

         // 3 Constructor de FILE+NOMBRE
         File direc = new File(RUTA_FICH);
         File fich3 = new File(direc, "prueba.txt");

         /* Ver información de fichero */
         System.out.println("Nombre del fichero: "+fich2.getName());
         System.out.println("Ruta de un fichero "+fich2.getPath());
         System.out.println("Ruta absoluta "+fich2.getAbsolutePath());
         System.out.println("Se puede leer "+fich2.canRead());
         System.out.println("Tamaño "+fich2.length());
         System.out.println("es ditectorio "+fich2.isDirectory());
         System.out.println("es fichero "+fich2.isFile());
         System.out.println("es fichero "+fich2.mkdir()); //Esto crea carpetas

    }
}
