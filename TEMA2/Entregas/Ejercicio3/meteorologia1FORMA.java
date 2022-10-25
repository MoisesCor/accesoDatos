package TEMA2.Entregas.Ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class meteorologia1FORMA {
    static String nombre;
    static String textoIntroducir;
    static Scanner leer=new Scanner(System.in);
    public static void main(String[] args) throws IOException {

       
        int opcion=0;
       
        System.out.println("____TEMPERATURAS LOCALIDADES____");

        do{
            System.out.println("1-Registrar nueva temperatura"+ "\n"+
                               "2-Mostrar historial de registros"  + "\n"+
                               "3-Mostrar media de temperatura"+ "\n"+
                               "4-Salir");
            opcion=leer.nextInt();
            switch(opcion){
                case 1:
                registrarNuevaTemperatura();
                break;

                case 2:
                mostraraHistorialRegistros();
                break;

                case 3:
                calcularMediaTemperatura();
                break;

                case 4:
                System.out.println("ADIOS");
                break;

                default:
                break;
            }

        }while(opcion!=4);
    }

    public static void registrarNuevaTemperatura(){
        /* Método para escribir en el fichero existente al pasarle la ruta indicar un true decimos
         * que no se sobreescriba si no que se ajunte al fichero, por eso primero
         * introducimos un salto de linea y luego los datos introduccidos por teclado con la función append
         * en vez de write ( muy importante el , true en la ruta)
         */
        
        System.out.println("Introduce nombre ciudad");
        textoIntroducir=leer.next();
        System.out.println("Introduce fecha a registrar");
        textoIntroducir+="__"+leer.next();
        System.out.println("Introduce temperatura máxima");
        textoIntroducir+="__"+leer.next();
        System.out.println("Introduce temperatura mínima");
        textoIntroducir+="__"+leer.next();

        try( FileWriter writer = new FileWriter("C:\\Moises\\ppp\\ejercicio3\\metereologia.txt\\",true);
        BufferedWriter bw = new BufferedWriter(writer);){
            bw.append("\r\n"+textoIntroducir);
            bw.close();
                
         } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
         }

       
    }

    public static void mostraraHistorialRegistros() throws IOException{
        /* método para leer el fichero e imprimir la información.
         * Para ello cargamos la linea del ficheo en una variable 
         * y comprobamos si contiene el texto pasado, si es así se imprime
         */
        String sTexto;
        System.out.println("Introduce nombre ciudad");
        textoIntroducir=leer.next();

        try (BufferedReader bfIn = new BufferedReader(new FileReader("C:\\Moises\\ppp\\ejercicio3\\metereologia.txt\\"))) {
            
            sTexto= bfIn.readLine();
           
            while(sTexto!=null){
                if(sTexto.toUpperCase().contains(textoIntroducir.toUpperCase())){
                    System.out.println(sTexto);
                } 
                sTexto=bfIn.readLine();
            }
            bfIn.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void calcularMediaTemperatura() throws IOException{
        /* Método que obtenemos la media por fecha de la temperatura y tambien obtenemos la de su totalidad
         * Se ha usado metodo split que crea un array separando por el patrón indicado
         */
        String sTexto;
        System.out.println("Introduce nombre ciudad");
        textoIntroducir=leer.next();
        int media=0, mediaGlobal=0;

        try (BufferedReader bfIn = new BufferedReader(new FileReader("C:\\Moises\\ppp\\ejercicio3\\metereologia.txt\\"))) {
            
            sTexto= bfIn.readLine();
           
            while(sTexto!=null){

                if(sTexto.toUpperCase().contains(textoIntroducir.toUpperCase())){
                    String[] numero = sTexto.split("__");
                    int max=Integer.parseInt(numero[2]);
                    int min=Integer.parseInt(numero[3]);
                    System.out.println(sTexto+" Media temperatura= "+(max+min)/2);
                    mediaGlobal+=(max+min)/2;
                    media++;
                    
                }
                sTexto=bfIn.readLine();
                
            }
            
            System.out.println(textoIntroducir.toUpperCase()+
            " Tiene una media de temperatura en su total de registros "+
            mediaGlobal/media);
            bfIn.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
