package TEMA2.Entregas.Ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CalcularMediaMoises {
    public static void main(String[] args) throws IOException {
        final String RUT_FIN="C:\\Users\\Moisés\\Desktop\\DAM 2\\Acceso a datos\\TEMA2\\";
        String sTexto="";
        double sumaEdad=0;
        double sumaAlt=0;
        int media=0;

        try (BufferedReader bfIn = new BufferedReader(new FileReader(RUT_FIN+"jugadores.txt"))) {
            
            sTexto= bfIn.readLine();
           
            while(sTexto!=null){
                media++;
                String[] numero = sTexto.split(" ");
                sumaEdad += Double.parseDouble(numero[1]);
                sumaAlt += Double.parseDouble(numero[2]);
                System.out.println(sTexto);
                sTexto=bfIn.readLine();
                
            }
            System.out.println("Media de altura= "+sumaAlt/media);
            System.out.println("Media de edad= "+sumaEdad/media);
            bfIn.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
