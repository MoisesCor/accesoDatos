package TEMA2.clase.jsonMoises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Ejer8 {
    public static void main(String[] args) {
        JsonObject objetoJ1 = new  JsonObject();
        objetoJ1.addProperty("coche", "rojo");
        objetoJ1.addProperty("temperatura", 22.5);
        objetoJ1.addProperty("año", 2010);

        JsonObject objetoJ2 = new  JsonObject();
        objetoJ2.addProperty("hola", "mundo");

        // insertamos objeto en objeto1
        objetoJ1.add("mensaje", objetoJ2);
        JsonArray jsonArrayMeses = new JsonArray();
        jsonArrayMeses.add("Enero");
        jsonArrayMeses.add("Febrero");
        jsonArrayMeses.add("Marzo");

        //insertamos el array en e json
        objetoJ1.add("meses", jsonArrayMeses);
        System.out.println("Obje json = "+objetoJ1);

        /* Volcar a fichero el json  */
        Path path = Paths.get("C:\\Moises\\ppp\\ejercicio4\\objeto.json\\");
        try {//mirar como poder guardarlo con buen formato y no en una linea se hace atraves de Gson con un SetPreti
            Files.write(path, (objetoJ1.toString()).getBytes());
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson objGson = new Gson();
    }
}
