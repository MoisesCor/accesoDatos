package tema4.Entregas.Actividad2.Equipos;


import javax.xml.bind.annotation.*;

/*anotaciones */
@XmlRootElement(name = "equipo")
@XmlType(propOrder = { "nombre", "ciudad", "conferencia","division" })
@XmlAccessorType(XmlAccessType.FIELD)
public class PoEquipo {
    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "ciudad")
    private String ciudad;

    @XmlElement(name = "conferencia")
    private String conferencia;

    @XmlElement(name = "division")
    private String division;

    /*Getters and Setters */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    /*Constructores */
    public PoEquipo(String nombre, String ciudad, String conferencia, String division) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.conferencia = conferencia;
        this.division = division;
    }

    public PoEquipo() {
    }
    
    /*ToString */
    @Override
    public String toString() {
        return "PoEquipo [nombre=" + nombre + ", ciudad=" + ciudad + ", conferencia=" + conferencia + ", division="
                + division + "]";
    }

    
    

    
    
    

    
    
}
