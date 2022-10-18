package TEMA2.main.clase.EjemplosCLase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriterIOyNIO {
    public static void main(String[] args) {

        /* Opción con 1 java.io */
        final String RUT_FIN="C:\\Users\\Moisés\\Desktop\\DAM 2\\Acceso a datos\\TEMA2\\";
        String sCadena="Texto a escribir en el fichero";
        try (FileWriter writer = new FileWriter(RUT_FIN+"eeee.txt");
         BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(sCadena);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /* Ocpción 2 java.nio */
        Path path = Paths.get(RUT_FIN+"info2.log");
        try {
            Files.write(path, sCadena.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
