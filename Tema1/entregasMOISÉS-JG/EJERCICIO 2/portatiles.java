package entregasMJG.Ejercicio2;

public class portatiles extends ordenadores {
    private double dPeso;

    /*Getters and Setters */
    public double getdPeso() {
        return dPeso;
    }

    public void setdPeso(double dPeso) {
        this.dPeso = dPeso;
    }
    public portatiles(String paramRam, String paramCpu, double paramPrecio, double paramPeso) {
        super(paramRam, paramCpu, paramPrecio);
        this.dPeso=paramPeso;
        //TODO Auto-generated constructor stub
    }
  

    @Override
    public void getCaracterisiticas() {
        System.out.println("ORDENADOR PORTATIL");
        System.out.println("Peso "+getdPeso()+"kg");
        super.getCaracterisiticas();
    }

    @Override
    public String toString() {
        
        return super.toString()+" PORTATIL PESO "+this.dPeso;
    }

    
    
}
