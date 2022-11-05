package TEMA2.clase.jsonMoises;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PersonasTestJson {
    public static void main(String[] args) {
        PersonasJson perso1 = new PersonasJson("mois", "dos", 30, Arrays.asList("esgrima","perros","comer"));
        PersonasJson perso2 = new PersonasJson("pepe", "poner", 32, Arrays.asList("migas","gatos","cagar"));
        List<PersonasJson> listapersoOut= Arrays.asList(perso1,perso2);

        System.out.println(listapersoOut);
        Gson objGson = new Gson();// esto es la clase general que creas, para poder llamar a los métodos
        String jsonPersonas = objGson.toJson(listapersoOut);
        System.out.println("json: " + jsonPersonas);

        //Esto es para pasar de un json a objetos java
        List<PersonasJson> listaPersona2 = objGson.fromJson(jsonPersonas, new TypeToken<List<PersonasJson>>() {
        }.getType());
        System.out.println(listaPersona2);
    }
}
