package TEMA2.clase.EjemplosCLase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileWriteNIO {

    final static String RUTA_FICH="C:\\Users\\Moisés\\Desktop\\DAM 2\\Acceso a datos\\TEMA2\\";
    final static String text_base=" ajajjajajajajajajajajaja";
   
    public static void main(String[] args) {
        
        Path miRut=Paths.get(RUTA_FICH+"info.out");
        try {
            Files.write(miRut,text_base.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Fichero generado en "+RUTA_FICH);

        System.out.println("Ruta del fichero "+miRut.getParent());
        System.out.println("Nombre del fichero "+miRut.getFileName());
        System.out.println("Num directorio "+miRut.getNameCount());
        System.out.println("directorio base"+miRut.getName(0));
        System.out.println("Soy fichero "+Files.isRegularFile(miRut));
        System.out.println("Soy Directorio "+Files.isDirectory(miRut));

        // Leer un fichero con readALLlines

        Path mirut2=Paths.get(RUTA_FICH+"calculanumeros.txt");
        List<String> line;
        try {
            line= Files.readAllLines(mirut2,StandardCharsets.ISO_8859_1);
            System.out.println(line);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
}
