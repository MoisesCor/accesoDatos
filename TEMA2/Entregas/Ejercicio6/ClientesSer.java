package TEMA2.Entregas.Ejercicio6;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ClientesSer implements Serializable,  Comparable<ClientesSer> {
    private String sDNI;
    private String sNombre;
    private LocalDate dFechaNacimiento;
    private double dSaldo;


    /* Getters and Setters */
    public String getsDNI() {
        return sDNI;
    }
    public void setsDNI(String sDNI) {
        this.sDNI = sDNI;
    }
    public String getsNombre() {
        return sNombre;
    }
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }
   
    public double getdSaldo() {
        return dSaldo;
    }
    public void setdSaldo(double dSaldo) {
        this.dSaldo = dSaldo;
    }
    public LocalDate getdFechaNacimiento() {
        return dFechaNacimiento;
    }
    public void setdFechaNacimiento(LocalDate dFechaNacimiento) {
        this.dFechaNacimiento = dFechaNacimiento;
    }

    
    public ClientesSer(String sDNI, String sNombre, String dFechaNacimiento, String dSaldo) {
        /* Los datos se piden como string todos y en el contructor parseamos */
        this.sDNI = sDNI;
        this.sNombre = sNombre;
        this.dFechaNacimiento = LocalDate.parse(dFechaNacimiento,DateTimeFormatter.ofPattern("d/M/yyyy")) ;
        this.dSaldo = Double.parseDouble(dSaldo);
    }
    @Override
    public int compareTo(ClientesSer o) {
       /* Implementado y sobreescrito para poder
         * ordenar el tree con el parametro saldo 
         */
        if(this.dSaldo<o.dSaldo){
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public String toString() {
        /* reescrito para que salga la edad de los clientes, llamando al método calcular edad */
        return "DNI "+sDNI+" Nombre "+sNombre+" fecha nacimiento "+dFechaNacimiento+" saldo "+dSaldo+" EDAD CLIENTE "+calcularAños(dFechaNacimiento)+"\n";
    }

    public long calcularAños(LocalDate fecha){
        /* Método calcular edad */
        return ChronoUnit.YEARS.between(fecha, LocalDate.now());
    }
}
