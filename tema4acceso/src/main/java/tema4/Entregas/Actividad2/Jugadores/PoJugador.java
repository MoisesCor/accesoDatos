package tema4.Entregas.Actividad2.Jugadores;

import javax.xml.bind.annotation.*;

/*anotaciones */
@XmlRootElement(name = "jugador")
@XmlType(propOrder = { "nombre", "procedencia", "altura","peso","posicion","nombreEquipo" })
@XmlAccessorType(XmlAccessType.FIELD)
public class PoJugador {
    @XmlElement(name = "nombre")
    private String nombre;
    @XmlElement(name = "procedencia")
    private String procedencia;
    @XmlElement(name = "altura")
    private String altura;
    @XmlElement(name = "peso")
    private Integer peso;
    @XmlElement(name = "posicion")
    private String posicion;
    @XmlElement(name = "nombreEquipo")
    private String nombreEquipo;

    /*Getters and Setters */
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public PoJugador(String nombre, String procedencia, String altura, Integer peso, String posicion,
            String nombreEquipo) {
        this.nombre = nombre;
        this.procedencia = procedencia;
        this.altura = altura;
        this.peso = peso;
        this.posicion = posicion;
        this.nombreEquipo = nombreEquipo;
    }

    public PoJugador() {
    }

    @Override
    public String toString() {
        return "PoJugador [nombre=" + nombre + ", procedencia=" + procedencia + ", altura=" + altura + ", peso=" + peso
                + ", posicion=" + posicion + ", nombreEquipo=" + nombreEquipo + "]";
    }

    

    
    
    
}
