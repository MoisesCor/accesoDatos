package entregasMJG.Ejercicio3;

import java.time.LocalDateTime;

public class vehiculo {
    private String sMatricula;
    private  LocalDateTime lFechaInicio;
    private LocalDateTime lFechaSalida;



    public String getsMatricula() {
        return sMatricula;
    }
    public void setsMatricula(String sMatricula) {
        this.sMatricula = sMatricula;
    }
    public LocalDateTime getlFechaInicio() {
        return lFechaInicio;
    }
    public void setlFechaInicio(LocalDateTime lFechaInicio) {
        this.lFechaInicio = lFechaInicio;
    }
    public LocalDateTime getlFechaSalida() {
        return lFechaSalida;
    }
    public void setlFechaSalida(LocalDateTime lFechaSalida) {
        this.lFechaSalida = lFechaSalida;
    }

    public vehiculo(String paramMatricula){
        this(paramMatricula,null,null);
    }

    public vehiculo(String sMatricula, LocalDateTime lFechaInicio, LocalDateTime lFechaSalida) {
        this.sMatricula = sMatricula;
        this.lFechaInicio = lFechaInicio;
        this.lFechaSalida = lFechaSalida;
    }
    @Override
    public String toString() {
        return "vehiculo [lFechaInicio=" + lFechaInicio + ", lFechaSalida=" + lFechaSalida + ", sMatricula="
                + sMatricula + "]";
    }

    

    

    
}
