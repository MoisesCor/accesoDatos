package entregasMJG.Ejercicio4;

public class suceso3D extends punto3D {
    private double dTiempo;
    private String sSuceso;

    
    public suceso3D(int paramX, int paramY, int paramZ, double dTiempo, String sSuceso) {
        super(paramX, paramY, paramZ);
        this.dTiempo = dTiempo;
        this.sSuceso = sSuceso;
    }
    


    public double getdTiempo() {
        return dTiempo;
    }



    public void setdTiempo(double dTiempo) {
        this.dTiempo = dTiempo;
    }



    public String getsSuceso() {
        return sSuceso;
    }



    public void setsSuceso(String sSuceso) {
        this.sSuceso = sSuceso;
    }



    
    public boolean equals(suceso3D param1 ) {
        
         return this.iX == param1.getiX()&& this.iY==param1.getiY() && this.iZ==param1.getiZ() && this.dTiempo==param1.dTiempo?true:false;
    }

    
}
