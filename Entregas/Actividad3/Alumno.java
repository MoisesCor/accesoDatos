package tema4.Entregas.Actividad3;

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
    private Double media; 

    @XmlElement(name = "curso")
    private String curso;

    public Alumno() {

    }

    

    public Alumno(String nombre, String fnac, Double media, String curso) {
        this.nombre = nombre;
        this.fnac = fnac;
        this.media = media;
        this.curso = curso;
    }



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

    public Double getNotaMedia() {
        return media;
    }

    public void setNotaMedia(Double media) {
        this.media = media;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }



    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", fnac=" + fnac + ", media=" + media + ", curso=" + curso + "]";
    }

    

}