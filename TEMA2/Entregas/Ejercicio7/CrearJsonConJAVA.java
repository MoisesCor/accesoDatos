package TEMA2.Entregas.Ejercicio7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.google.gson.GsonBuilder;

public class CrearJsonConJAVA {
    private static final String rutaJson="C:\\DAM2C\\ACCESODATOSVISUAL\\AccesoDatosDam2\\src\\TEMA2\\Entregas\\Ejercicio7\\MoisesCV.json\\";
    public static void main(String[] args) {
        MoisesCV yo= new MoisesCV("Moises",
         "Jimenez Garcia", 30, Arrays.asList("ESO","Bachiller","DAM"),
          null,
          Arrays.asList("Carrefour","primark","brasayleña"));


           // Escribimos el json
        Path path = Paths.get(rutaJson);
        try {//de esta forma se le da formato para que salga ordenado
            Files.write(path, (new GsonBuilder().setPrettyPrinting().create().toJson(yo)).getBytes());
        
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



   
}
