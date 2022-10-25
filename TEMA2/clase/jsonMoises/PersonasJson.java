package TEMA2.clase.jsonMoises;

import java.util.List;

public class PersonasJson {
    private String nombre;
    private String apellido;
    private int edad;
    List<String> aficiones;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public List<String> getAficiones() {
        return aficiones;
    }
    public void setAficiones(List<String> aficiones) {
        this.aficiones = aficiones;
    }
    public PersonasJson(String nombre, String apellido, int edad, List<String> aficiones) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.aficiones = aficiones;
    }


    @Override
    public String toString() {
        return "Personas [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", aficiones=" + aficiones
                + "]";
    }

    

    

    
  

}
