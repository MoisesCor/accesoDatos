package TEMA2.Entregas.Ejercicio7;

public class MoisesCVTest {  
public static void main(String[] args) {
    // Llamada al método para leer el json por consola
    System.out.println("-------LEEMOS FICHERO-------");
    System.out.println(UtilidadesMoisesCV.leerJson());

     // Llamamos al método que se encarga de crear el objeto desde el json
     System.out.println("-------CREAMOS OBJETO DESDE  FICHERO-------");
   MoisesCV yo=UtilidadesMoisesCV.crearObjetoDesdeJson();

    // Imprimimos el objeto para ver que se ha creado correctamente
    System.out.println("-------LEEMOS OBJETO-------");
    System.out.println(yo);

    //Llamada al método que sobreescribe el json cambiando el nivel de ingles
    System.out.println("-------CAMBIAMOS NIVEL DE INGLES-------");
    UtilidadesMoisesCV.modificarNivel(yo);
    
    //Volvemos a leer el fichero json para comprobar el cambio y leeomos el objeto:
    System.out.println("Modificación objeto "+yo);
    System.out.println("");
    System.out.println("Modificación fichero json "+UtilidadesMoisesCV.leerJson());
    

    
}



}

