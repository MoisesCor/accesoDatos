package entregasMJG.Ejercicio4;

public class punto {
    protected int iX;
    protected int iY;


    public int getiX() {
        return iX;
    }
    public void setiX(int iX) {
        this.iX = iX;
    }
    public int getiY() {
        return iY;
    }
    public void setiY(int iY) {
        this.iY = iY;
    }

    public punto(int paramX, int paramY) {
        this.iX = paramX;
        this.iY = paramY;
    }

    public double distancia( punto param1) {

		int distancia= (this.iX -param1.iX) * (this.iX -param1.iX) +(this.iY-param1.iY) * (this.iY-param1.iY);
		double resultado = Math.sqrt(distancia);
		return resultado;
		
	}
    public boolean equals(punto param1){
       // this.equals(param1);
        return this.iX == param1.iX && this.iY==param1.iY?true:false;
    }

    
    
}
