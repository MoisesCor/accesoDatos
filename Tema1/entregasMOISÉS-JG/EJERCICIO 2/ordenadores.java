package entregasMJG.Ejercicio2;

public abstract class  ordenadores {
    protected String sRam;
    protected  String sCpu;
    protected double dPrecio;


    /*Getters and setters*/
    public String getsRam() {
        return sRam;
    }
    public void setsRam(String sRam) {
        this.sRam = sRam;
    }
    public String getsCpu() {
        return sCpu;
    }
    public void setsCpu(String sCpu) {
        this.sCpu = sCpu;
    }
    public double getdPrecio() {
        return dPrecio;
    }
    public void setdPrecio(double dPrecio) {
        this.dPrecio = dPrecio;
    }

    /*Contstruztor*/
    public ordenadores(String paramRam, String paramCpu, double paramPrecio) {
        this.sRam = paramRam;
        this.sCpu = paramCpu;
        this.dPrecio = paramPrecio;
    }

    public void getCaracterisiticas(){
        System.out.println("Tipo RAM "+this.sRam);
        System.out.println("Tipo de CPU "+this.sCpu);
        System.out.println("Precio "+this.dPrecio+"\n");
        
    }
    @Override
    public String toString() {
        return "ordenadores [dPrecio=" + dPrecio + ", sCpu=" + sCpu + ", sRam=" + sRam + "]";
    }

    

    




    
    
}
