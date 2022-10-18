package TEMA2.main.clase.EjemplosCLase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerIOsinFINALLY {
    public static void main(String[] args) {
        final String RUT_FIN="C:\\Users\\Moisés\\Desktop\\DAM 2\\Acceso a datos\\TEMA2\\";
        String sTexto="";
        // en esta opción no se usa el finally
        try (BufferedReader bfIn = new BufferedReader(new FileReader(RUT_FIN+"jugadores.txt"))) {
            sTexto= bfIn.readLine();
            while(sTexto!=null){
                System.out.println(sTexto);
                sTexto=bfIn.readLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
