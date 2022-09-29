package entregasMJG.Ejercicio4;

public class punto3D extends punto {
    protected int iZ;

    public int getiZ() {
        return iZ;
    }

    public void setiZ(int iZ) {
        this.iZ = iZ;
    }



    public punto3D(int paramX, int paramY, int paramZ) {
        super(paramX, paramY);
        this.iZ = paramZ;
    }

    public boolean equals(punto3D param1){
        return this.iX == param1.getiX() && this.iY==param1.getiY() && this.iZ==param1.getiZ()?true:false;
    }

  

    public double distancia(punto3D param1){
        int iDistancia=(param1.getiX() -this.iX)+ (param1.getiY() -this.iY) +(param1.getiZ() -this.iZ);
       double Rresultado=Math.sqrt(iDistancia);
        return Rresultado;

    }
}

    
    

