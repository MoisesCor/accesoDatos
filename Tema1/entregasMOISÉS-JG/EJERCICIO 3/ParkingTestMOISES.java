package entregasMJG.Ejercicio3;



public class ParkingTestMOISES {
    public static void main(String[] args) throws Exception {
       System.out.println("Inicio ParkingTest");
    try{
       vehiculo coche1 = new vehiculo("1234KJM");
       vehiculo coche2 = new vehiculo("5678ASD");
       vehiculo coche3 = new vehiculo("4589PPP");
       vehiculo coche4 = new vehiculo("4434KJH");
       vehiculo coche5 = new vehiculo("6666KKK");
       ParkingVehiculo parkingMetro= new ParkingVehiculo("Av la albufera 12");
       parkingMetro.aparcaCoche(coche1);
       parkingMetro.aparcaCoche(coche2);
       parkingMetro.aparcaCoche(coche3);
       parkingMetro.aparcaCoche(coche4);
       parkingMetro.aparcaCoche(coche5);

       //lapso de tiempo 2 min
       Thread.sleep(120*1000);
       parkingMetro.sacarCoche(coche1);
       parkingMetro.sacarCoche(coche2);
       parkingMetro.sacarCoche(coche3);
       parkingMetro.sacarCoche(coche4);
       parkingMetro.sacarCoche(coche5);
       double dFactura= parkingMetro.getFactura(coche1);
       System.out.println(coche1+";  Factura= "+dFactura);
    }catch(Exception e){
        e.printStackTrace();
    }

        
    }
}
