package TEMA2.main.clase.EjerciciosHacerClase;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class contarVocales {
    public static void main(String[] args) {
        
        final String RUT_FIN=Constantes.RUTA;
        String sTexto="";
        int A=0,E=0,I=0,O=0,U = 0;
        String text="";

        try (BufferedReader bfIn = new BufferedReader(new FileReader(RUT_FIN+"prueba.txt")); FileWriter writer = new FileWriter(RUT_FIN+"vocales.txt");
        BufferedWriter bw = new BufferedWriter(writer);) {
           

            sTexto= bfIn.readLine();
            while(sTexto!=null){
                char [] line=sTexto.toLowerCase().toCharArray();
                for(char letras: line){
                    switch(letras){
                        case'a':
                        A++;
                        break;
                        case'e':
                        E++;
                        break;
                        case'i':
                         I++;
                         break;
                        case'o':
                        O++;
                        break;
                        case'u':
                        U++;
                        break;
                        default:
                        break;
                    }
                }
                sTexto= bfIn.readLine();

            }
            text=("A = "+A+ 
                                 "\n" +"E = "+E+ "\n"
                                 +"I = "+I+ "\n"+
                                 "O = "+O+ "\n"+
                                 "U = "+U+ "\n"
            );
            
            System.out.println(text);
            bw.write(text);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
