package TEMA2.clase.EjerciciosHacerClase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class calculnum2 {
    public static void main(String[] args) {
        final String RUT_FIN="C:\\Users\\Moisés\\Desktop\\DAM 2\\Acceso a datos\\TEMA2\\";
        String sTexto="";
        int suma=0;
       
        // en esta opción no se usa el finally
        try (BufferedReader bfIn = new BufferedReader(new FileReader(RUT_FIN+"calculanumeros.txt"))) {
            sTexto= bfIn.readLine();
            StringTokenizer st = new StringTokenizer(sTexto);
            int media=(st.countTokens());
            
            while (st.hasMoreTokens()) {
                    
                 suma +=(Integer.parseInt((st.nextToken())));
                  
                System.out.println(suma);
            }
          
            System.out.println(suma/media+" res");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
