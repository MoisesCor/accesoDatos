package entregasMJG.Ejercicio3;

public interface Parking {

    /*Métods */

    // no se puede crear metodo boolean??
     public boolean hayPlaza();

     public void aparcaCoche(vehiculo coche) throws Exception;

     public void sacarCoche(vehiculo coche) throws Exception;

     public double getFactura(vehiculo coche) throws Exception;
    
}
