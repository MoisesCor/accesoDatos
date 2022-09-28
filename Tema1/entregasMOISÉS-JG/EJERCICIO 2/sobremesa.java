package entregasMJG.Ejercicio2;

public class sobremesa extends ordenadores {
    private String sModeloTorre;


    /*Getters and Setters */
    public String getsModeloTorre() {
        return sModeloTorre;
    }

    public void setsModeloTorre(String sModeloTorre) {
        this.sModeloTorre = sModeloTorre;
    }

    public sobremesa(String sRam, String sCpu, double dPrecio,String paramCodigo, String sModeloTorre) {
        super(sRam, sCpu, dPrecio, paramCodigo);
        this.sModeloTorre = sModeloTorre;
    }

    @Override
    public void getCaracterisiticas() {
        System.out.println("ORDENADOR SOBREMESA");
        System.out.println("Tipo de torre "+sModeloTorre);
        super.getCaracterisiticas();
    }

    @Override
    public String toString() {
        
        return super.toString()+" Sobremesa TORRE: "+this.sModeloTorre;
    }


    
    

    
}
