package TEMA2.clase.jsonMoises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;


public class Ejer10IMPORTARJSONlista {
    static String rutaJson="C:\\DAM2C\\ACCESODATOSVISUAL\\AccesoDatosDam2\\src\\TEMA2\\clase\\jsonMoises\\ficherosJSON";
    /**
     * @param args
     */
    public static void main(String[] args) {
        String json = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaJson+"\\personas.json\\"));

            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
            }

            br.close();
            
        } catch (FileNotFoundException ex) {
           
        } catch (IOException ex) {
            
        }

       // System.out.println(json);
       
        Gson gson = new Gson();
      /*Funciona pero luego el foreach da fallo 
         ArrayList<PersonasJson> pp=gson.fromJson(json,ArrayList.class);
         */
        PersonasJson[] p = gson.fromJson(json, PersonasJson[].class);
        System.out.println(p);

        /* Con un array Funciona pero con listas no por que? */
        for(PersonasJson aux: p){
            System.out.println(aux);
        }
        //JsonParser parser = new JsonParser(); para parsear
        
    }

}