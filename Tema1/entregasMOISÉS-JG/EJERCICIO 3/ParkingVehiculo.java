package entregasMJG.Ejercicio3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class  ParkingVehiculo implements Parking {

    public static final double dPrecioMin = 0.0425;
    public static final int iMaxPlazas =100;

    private String sDireccion;
    public  int iPlazasOcupadas;

    /* Constructore */
    // con un parámetro
    public ParkingVehiculo(String paramDireccion){
        this(paramDireccion,60);
    }
    
    // el general
    public ParkingVehiculo(String paramDireccion, int paramPlazasOcupadas) {
        this.sDireccion = paramDireccion;
        this.iPlazasOcupadas = paramPlazasOcupadas;
    }


    /*Getters and Setter */
    public String getsDireccion() {
        return sDireccion;
    }

    public void setsDireccion(String sDireccion) {
        this.sDireccion = sDireccion;
    }

    public int getiPlazasOcupadas() {
        return iPlazasOcupadas;
    }

    public void setiPlazasOcupadas(int iPlazasOcupadas) {
        this.iPlazasOcupadas = iPlazasOcupadas;
    }

    
    /* Métodos de la interface */
    @Override
    public void aparcaCoche(vehiculo coche) throws Exception {
        if(hayPlaza()){
            iPlazasOcupadas++;
            coche.setlFechaInicio(LocalDateTime.now());
        }else{
            throw new Exception(" ERROR PARKING COMPLETO");
        }
        
    }

    @Override
    public void sacarCoche(vehiculo coche) throws Exception {
        if(coche.getlFechaInicio()!=null){
            iPlazasOcupadas--;
            coche.setlFechaSalida(LocalDateTime.now());
        }else{
            throw new Exception(" ERROR VEHÍCULO NO ESTACIONADO EN ESTE PARKING");
        }
        
    }


    @Override
    public boolean hayPlaza() {
        if(iMaxPlazas>iPlazasOcupadas){
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public double getFactura(vehiculo coche) throws Exception {
        double total;
        if(coche.getlFechaSalida().isAfter(coche.getlFechaInicio()) && coche.getlFechaInicio()!=null && coche.getlFechaSalida()!=null){
             total=(ChronoUnit.MINUTES.between(coche.getlFechaInicio(), coche.getlFechaSalida()))*dPrecioMin;
             //coche.setlFechaInicio(null);
             //coche.setlFechaSalida(null);
        }else{
            throw new Exception(" ERROR FACTURA NO EMITUDA");
        }
        return total;
        
       // double dDias= coche.lFechaSalida.ge
        

       
        
        
    }

   

    

 
   
    
}
