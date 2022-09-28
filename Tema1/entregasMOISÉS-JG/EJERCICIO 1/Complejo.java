package entregasMJG;

public class Complejo{
    /* Atributos */
    private double dPReal;
    private double dPImag;


    /* Constructor  */
    public Complejo(double dPReal, double dPImag) {
        this.dPReal = dPReal;
        this.dPImag = dPImag;
    }

    /* Metodos */
    public void asignar(double x, double y){
        //Asigna el valor de los atributos de objeto.
        this.dPReal = x;
        this.dPImag = y;

    }
    
    public void imprimir(){
        //Usado para imprimir la suma compleja con el formato, crea una cadena String
        System.out.printf("%.0f + %.0fi",dPReal , dPImag);
       
    }

    public Complejo sumar(Complejo c2) {
        //variables usadas para la suma
        double dSumaReal;
        double dSumaImag;

        //suma de los atributos correspondiente de ambos objetos
        dSumaReal = c2.dPReal + this.dPReal; 
        dSumaImag = c2.dPImag+ this.dPImag; 
        Complejo complejoResult = new Complejo(dSumaReal, dSumaImag);

        //Resultado con formáto por pantalla
        System.out.println("La parte REAL: ("+dPReal+","+c2.dPReal+") = "+dSumaReal);
        System.out.println("La parte IMAGINARIA: ("+dPImag+","+c2.dPImag+") = "+dSumaImag);
       // System.out.printf("(%.0f + %.0fi)",dSumaReal , dSumaImag); //Se usa para dar formato por pantalla muy útil
        
        return complejoResult;
    }
    /* Getters and Setters */
    public double getdPReal() {
        return dPReal;
    }

    public void setdPReal(double dPReal) {
        this.dPReal = dPReal;
    }

    public double getdPImag() {
        return dPImag;
    }

    public void setdPImag(double dPImag) {
        this.dPImag = dPImag;
    }

    @Override
    public String toString() {
        return "Complejo [dPImag=" + dPImag + ", dPReal=" + dPReal + "]";
    };
 

    }
 
 
