package TEMA2.Entregas.Ejercicio7;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoisesCV {
    static Scanner leer=new Scanner(System.in);

    /* POO creado con los datos del curriculum los idiomas se han creado con una constante
     * para que el método que se encarga de convertir a objeto el json encuentre los valores
     * para los idiomas he usado map, para poder darle el valor del nivel y poder cambiarlo de forma sencilla
     * en el constructor le paso el valor del map automático ya que desde llamada al método no se hacerlo
     * se crea un método en la propia clase para cambiar el valor del map.
     */
    private static final String Ingles = "Ingles";
    private static final String Frances = "Frances";
    private String nombre;
    private String apellidos;
    private int edad;
    private List<String> estudios;
    private HashMap<String,String> idiomas;
    private List<String> experiencia;


    
    public MoisesCV(String nombre, String apellidos, int edad, List<String> estudios, HashMap<String, String> idiomas,
            List<String> experiencia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.estudios = estudios;
        if(idiomas==null){
            HashMap <String,String> aux= new HashMap<String,String>();
            aux.put(Ingles, "b1");
            aux.put(Frances, "a2");
            this.idiomas = aux;
        }else{
            this.idiomas = idiomas;
        }
        
        this.experiencia = experiencia;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public List<String> getEstudios() {
        return estudios;
    }
    public void setEstudios(List<String> estudios) {
        this.estudios = estudios;
    }
    public HashMap<String, String> getIdiomas() {
        return idiomas;
    }
    public void setIdiomas(HashMap<String, String> idiomas) {
        this.idiomas = idiomas;
    }
    public List<String> getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(List<String> experiencia) {
        this.experiencia = experiencia;
    }
    @Override
    public String toString() {
        return "MoisesCV [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", estudios=" + estudios
                + ", idiomas=" + idiomas + ", experiencia=" + experiencia + "]";
    }

    public void cambiarNivel(){
        Matcher mat = null;
		Pattern pat1 = Pattern.compile("A1|A2|B1|B2|C1|C2");
        do{
        System.out.println("Que nivel quieres introducir: A1, A2, B1, B2, C1, C2");
        String nivel= leer.next().toUpperCase();
        mat= pat1.matcher(nivel);
        if(!mat.matches()){
            System.out.println("Nivel incorrecto");
        }else{
            this.idiomas.put(Ingles, nivel);
        }

    }while(!mat.matches());
    

    }
    
}
