package TEMA2.Entregas.Ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class meteForma2OBJETOS {
    private String sNombre;
    private String sFecha;
    private int iTmax;
    private int iTmin;


    public String getsNombre() {
        return sNombre;
    }
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }
    public String getsFecha() {
        return sFecha;
    }
    public void setsFecha(String sFecha) {
        this.sFecha = sFecha;
    }
    public int getiTmax() {
        return iTmax;
    }
    public void setiTmax(int iTmax) {
        this.iTmax = iTmax;
    }
    public int getiTmin() {
        return iTmin;
    }
    public void setiTmin(int iTmin) {
        this.iTmin = iTmin;
    }

    

    public meteForma2OBJETOS(String sNombre, String sFecha, int iTmax, int iTmin) {
        this.sNombre = sNombre;
        this.sFecha = sFecha;
        this.iTmax = iTmax;
        this.iTmin = iTmin;
    }

    public static ArrayList<meteForma2OBJETOS> meteForma2OBJETOS(){
        ArrayList<meteForma2OBJETOS> lista1= new ArrayList<meteForma2OBJETOS>();
        
        try (BufferedReader bfIn = new BufferedReader(new FileReader("C:\\Moises\\ppp\\ejercicio3\\metereo2.txt\\"))) {
            String sTexto= bfIn.readLine();
            while(sTexto!=null){
                String[] partes= sTexto.split(" ");
                lista1.add(new meteForma2OBJETOS(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes[3])));
                sTexto=bfIn.readLine();
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista1;

    }
    @Override
    public String toString() {
        return "Municipio Nombre " + sNombre + ", Fecha " + sFecha + ", iTmax " + iTmax + ", iTmin " + iTmin
                + "\n";
    } 

    public static void verCIudad(String nombreCiu){
        ArrayList<meteForma2OBJETOS> aux = meteForma2OBJETOS();
        for(meteForma2OBJETOS muni:aux ){
            if(muni.getsNombre().toUpperCase().equals(nombreCiu.toUpperCase())){
                System.out.println(muni);
            }
        }
    }

    public static void mediaCIudad(String nombreCiu){
        ArrayList<meteForma2OBJETOS> aux = meteForma2OBJETOS();
        int x=0,contador=0;
        for(meteForma2OBJETOS muni:aux ){
            if(muni.getsNombre().toUpperCase().equals(nombreCiu.toUpperCase())){
                System.out.println(muni+" y su media ="+muni.calcularMedia());
                x+=muni.calcularMedia();
                contador++;
            }
        }
        System.out.println(nombreCiu.toUpperCase()+
        " Tiene una media de temperatura en su total de registros "+x/contador);
    }

    public static ArrayList<meteForma2OBJETOS> introduceNuevaT(String datos){
        Path path = Paths.get("C:\\Moises\\ppp\\ejercicio3\\metereo2.txt\\");
        try {
            Files.write(path, ("\r\n"+datos).getBytes(), StandardOpenOption.APPEND);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return meteForma2OBJETOS(); 

    }

    public int calcularMedia(){
       return (this.iTmax+this.iTmin)/2;
        
    }

    

    
}
