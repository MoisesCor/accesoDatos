package TEMA2.clase.EjerciciosHacerClase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class filevisitor implements FileVisitor<Path>{

    @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                        throws IOException {
                    System.out.println("Carpeta: " + dir.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                        throws IOException {
                    System.out.println("Archivo dentro de la carpeta: " + file.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc)
                        throws IOException {
                    System.out.println("visitFileFailed: " + file.getFileName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc)
                        throws IOException {
                    System.out.println("Fin Carpeta: " + dir.getFileName());
                    return FileVisitResult.CONTINUE;
                }

}

public class ejercicio5V2 {
    

    public static void main(String[] args) throws IOException  {
        Scanner leer=new Scanner(System.in);
        int menu=0;
        String ruta="";
        do{
            System.out.println("MENU FICHEROS");
            System.out.println("1 Copiar fichero");
            System.out.println("2 Listar directorio");
            System.out.println("3 SALIR");
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
                Path origen=Paths.get(ruta);
                Files.walkFileTree(origen, new filevisitor());
                    break;
                default :
                    break;
            }


        }while(menu!=3);
    }

    public static boolean copiarFichero(String ruta) {
       // List<String> line;
        Path origen=Paths.get(ruta);
        Path copia=Paths.get(origen.getParent()+"\\copia_de"+origen.getFileName());
        
        
        
        try {
          /*  
            line= Files.readAllLines(origen,StandardCharsets.ISO_8859_1);
            Files.write(copia,"".getBytes());
            for(String cadena :line) {
                System.out.println(cadena);
                Files.write(copia,cadena.getBytes(),StandardOpenOption.APPEND);
                Files.write(copia,"\r\n".getBytes(),StandardOpenOption.APPEND);
                
              }*/
            
           
            Files.copy(origen, copia);
            

            


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        return true;
     }
         

    public static boolean listarDirectorio(String ruta){
        Path origen=Paths.get(ruta);
    /* 
       try(DirectoryStream<Path> lista = Files.newDirectoryStream(origen.getParent())){
             
            for(Path aux : lista){
                System.out.println(aux.getFileName());
            } 
            return true;
       }catch(IOException e){
        System.out.println("error");
        return false;*/
        return true;
    }

    

        
       }


        



    


