package TEMA2.main.clase.EjerciciosHacerClase;
/* Ejercicio para clase 4 (no entregar): Escribe un programa en Java que lea un fichero
de texto con varias líneas (4-5) y genere un archivo de 3 columnas. Por ejemplo:
Texto: THE SKY IS BLUE
Resultado:
T H E
 S K Y
 I S B
 L U E
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class Ejercicio4 {
    final static String text_base="THE SKY IS BLUE";
    public static void main(String[] args) {
        String sTexto;
        String palabra="";
        Path miRut=Paths.get(Constantes.RUTA2+"ejercicio4.txt");
        try {
            Files.write(miRut,text_base.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try (BufferedReader bfIn = new BufferedReader(new FileReader(Constantes.RUTA2+"ejercicio4.txt"));
             FileWriter writer = new FileWriter(Constantes.RUTA2+"ejercicio4COPIA.txt");
             BufferedWriter bw = new BufferedWriter(writer);
            ) {
            sTexto= bfIn.readLine();
            StringTokenizer st = new StringTokenizer(sTexto);
            
            
            while (st.hasMoreTokens()) {
                char [] line=st.nextToken().toCharArray();
                for(char letras: line){
                    palabra=palabra+letras+" ";
                    System.out.println(letras);
                    if(palabra.replaceAll("\\s+","").length()==3){
                        bw.write(palabra);
                        bw.newLine();
                        System.out.println(palabra);
                        palabra="";
                    }
                   
                }
     
              
            }
          
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       

    }
}
