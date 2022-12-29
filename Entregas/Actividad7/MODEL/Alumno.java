package tema4.Entregas.Actividad7.MODEL;

import javax.xml.bind.annotation.*;



/*anotaciones */
@XmlRootElement(name = "alumno")
@XmlType(propOrder = { "nombre", "fnac", "media","curso" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Alumno {
    @XmlElement(name = "nombre")
    private String nombre;
    @XmlElement(name = "fnac")
    private String fnac;
    @XmlElement(name = "media")
    private double media;
    @XmlElement(name = "curso")
    private String curso;



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getFnac() {
        return fnac;
    }



    public void setFnac(String fnac) {
        this.fnac = fnac;
    }



    public double getMedia() {
        return media;
    }



    public void setMedia(double media) {
        this.media = media;
    }



    public String getCurso() {
        return curso;
    }



    public void setCurso(String curso) {
        this.curso = curso;
    }
    



    public Alumno(String nombre, String fnac, double media, String curso) {
        this.nombre = nombre;
        this.fnac = fnac;
        this.media = media;
        this.curso = curso;
    }



    public Alumno() {
    }



    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", fnac=" + fnac + ", media=" + media + ", curso=" + curso + "]";
    }

    
}
