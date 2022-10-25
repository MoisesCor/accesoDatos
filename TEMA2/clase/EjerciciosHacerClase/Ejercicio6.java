package TEMA2.clase.EjerciciosHacerClase;

import java.io.Serializable;

public class Ejercicio6 implements Serializable {
    
    private String sNombre;
    private int iEdad;




    public String getsNombre() {
        return sNombre;
    }
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }
    public int getiEdad() {
        return iEdad;
    }
    public void setiEdad(int iEdad) {
        this.iEdad = iEdad;
    }

    
    public Ejercicio6(String sNombre, int iEdad) {
        this.sNombre = sNombre;
        this.iEdad = iEdad;
    }
    @Override
    public String toString() {
        return "Ejercicio6 [sNombre=" + sNombre + ", iEdad=" + iEdad + "]";
    }

    
    
}
