package TEMA2.main.clase.EjercicioDESAROLLO;

public abstract class Contactos {

    protected String sIdentificador;
    protected int iNumTelf;
   


    /* getter and setter */
    public String getsIdentificador() {
        return sIdentificador;
    }
    public void setsIdentificador(String sIdentificador) {
        this.sIdentificador = sIdentificador;
    }
    public int getiNumTelf() {
        return iNumTelf;
    }
    public void setiNumTelf(int iNumTelf) {
        this.iNumTelf = iNumTelf;
    }


    /* Constructor */
    public Contactos(String sIdentificador, int iNumTelf) {
        this.sIdentificador = sIdentificador;
        this.iNumTelf = iNumTelf;
    }

    /* metodo equals */
   
    @Override
    public String toString() {
        return "Contactos [sIdentificador=" + sIdentificador + ", iNumTelf=" + iNumTelf + "]";
    }
  
    @Override
    public boolean equals(Object obj) {
        Contactos auxem=(Contactos) obj;

        System.out.println(auxem.getsIdentificador());
        System.out.println(this.getsIdentificador()); 
        if(this.sIdentificador==(auxem.sIdentificador)){
            return true ;
        }
        return false;
        
    }

    

        
    }

