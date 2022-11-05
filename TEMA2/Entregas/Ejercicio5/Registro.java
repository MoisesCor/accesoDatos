package TEMA2.Entregas.Ejercicio5;

import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Registro implements Serializable {
    private String sCiudad;
    private String sFecha;
    private int iTmax;
    private int iTmin;

    ObjectOutputStream objetoSalida;


    public String getsCiudad() {
        return sCiudad;
    }
    public void setsCiudad(String sCiudad) {
        this.sCiudad = sCiudad;
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


    public Registro(String sCiudad, String sFecha, int iTmax, int iTmin) {
        this.sCiudad = sCiudad;
        this.sFecha = sFecha;
        this.iTmax = iTmax;
        this.iTmin = iTmin;
    }
    @Override
    public String toString() {
        return "Ciudad: " + sCiudad + " Fecha: " + sFecha + " Temperatura max: " + iTmax + " Temperatura min: " + iTmin
        + "\n";
    }

    //Método calcular temperatura media
    public int calcularMedia(){
        return (this.iTmax+this.iTmin)/2;
         
     }

    


    
}
