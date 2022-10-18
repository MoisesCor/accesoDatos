package TEMA2.main.clase.EjerciciosHacerClase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CalculaNumeros {
    public static void main(String[] args) {
        final String RUT_FIN="C:\\Users\\Moisés\\Desktop\\DAM 2\\Acceso a datos\\TEMA2\\";
        String sTexto="";
        String sTexto2="";
        int suma=0;
        int sumadero=0, media=0;
        // en esta opción no se usa el finally
        try (BufferedReader bfIn = new BufferedReader(new FileReader(RUT_FIN+"calculanumeros.txt"))) {
            sTexto= bfIn.readLine();
            System.out.println(sTexto);
            System.out.println(sTexto.length());
            
            for(int i=0; i<sTexto.length();i++){
                if(sTexto.charAt(i) != ' '){
                    sTexto2+=sTexto.charAt(i);
                    //System.out.println(sTexto2);
                }else{
                     sumadero=sumadero+(Integer.parseInt(sTexto2));
                     sTexto2="";
                     media++;
                   
                }
                
            
            }
            System.out.println(sumadero);
                System.out.println(media);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
