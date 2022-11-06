package TEMA2.clase.jsonMoises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Ejer9ExportarJSON {
   static String rutaJson="C:\\DAM2C\\ACCESODATOSVISUAL\\AccesoDatosDam2\\src\\TEMA2\\clase\\jsonMoises\\ficherosJSON";
    public static void main(String[] args) {
        
        
        PersonasJson perso1 = new PersonasJson("mois", "dos", 30, Arrays.asList("esgrima","perros","comer"));
        PersonasJson perso2 = new PersonasJson("pepe", "poner", 32, Arrays.asList("migas","gatos","cagar"));
        List<PersonasJson> listapersoOut= Arrays.asList(perso1,perso2);

        System.out.println(listapersoOut);
        Gson objGson = new Gson();// esto es la clase general que creas, para poder llamar a los métodos
        String jsonPersonas = (new GsonBuilder().setPrettyPrinting().create().toJson(listapersoOut));// dar formato json al string

        //Esto es para pasar de un json a objetos java
        List<PersonasJson> listaPersona2 = objGson.fromJson(jsonPersonas, new TypeToken<List<PersonasJson>>() {
        }.getType());
        System.out.println(listaPersona2);


        // Escribimos el json
        Path path = Paths.get(rutaJson+"\\personas.json\\");
        try {//de esta forma se le da formato para que salga ordenado
            Files.write(path, (new GsonBuilder().setPrettyPrinting().create().toJson(listapersoOut)).getBytes());
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }
    
