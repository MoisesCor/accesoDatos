package tema4.Entregas.Actividad2.Estadisticas;

import javax.xml.bind.annotation.*;

/*anotaciones */
@XmlRootElement(name = "estadistica")
@XmlType(propOrder = { "temporada", "jugador", "puntosPORpartido","asistenciasPORpartido","taponesPORpartido","rebotesPORpartido" })
@XmlAccessorType(XmlAccessType.FIELD)
public class PoEstadistica {
    @XmlElement(name = "temporada")
    private String temporada;

    @XmlElement(name="jugador")
    private Integer jugador;

    @XmlElement(name="puntosPORpartido")
    private Double puntosPORpartido;

    @XmlElement(name="asistenciasPORpartido")
    private Double asistenciasPORpartido;

    @XmlElement(name="taponesPORpartido")
    private Double taponesPORpartido;

    @XmlElement(name="rebotesPORpartido")
    private Double rebotesPORpartido;


/*Getter and Setters */
    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public Integer getJugador() {
        return jugador;
    }

    public void setJugador(Integer jugador) {
        this.jugador = jugador;
    }

    public Double getPuntosPORpartido() {
        return puntosPORpartido;
    }

    public void setPuntosPORpartido(Double puntosPORpartido) {
        this.puntosPORpartido = puntosPORpartido;
    }

    public Double getAsistenciasPORpartido() {
        return asistenciasPORpartido;
    }

    public void setAsistenciasPORpartido(Double asistenciasPORpartido) {
        this.asistenciasPORpartido = asistenciasPORpartido;
    }

    public Double getTaponesPORpartido() {
        return taponesPORpartido;
    }

    public void setTaponesPORpartido(Double taponesPORpartido) {
        this.taponesPORpartido = taponesPORpartido;
    }

    public Double getRebotesPORpartido() {
        return rebotesPORpartido;
    }

    public void setRebotesPORpartido(Double rebotesPORpartido) {
        this.rebotesPORpartido = rebotesPORpartido;
    }

    /*Constructores */
    public PoEstadistica(String temporada, Integer jugador, Double puntosPORpartido, Double asistenciasPORpartido,
            Double taponesPORpartido, Double rebotesPORpartido) {
        this.temporada = temporada;
        this.jugador = jugador;
        this.puntosPORpartido = puntosPORpartido;
        this.asistenciasPORpartido = asistenciasPORpartido;
        this.taponesPORpartido = taponesPORpartido;
        this.rebotesPORpartido = rebotesPORpartido;
    }

    public PoEstadistica() {
    }

    @Override
    public String toString() {
        return "PoEstadistica [temporada=" + temporada + ", jugador=" + jugador + ", puntosPORpartido="
                + puntosPORpartido + ", asistenciasPORpartido=" + asistenciasPORpartido + ", taponesPORpartido="
                + taponesPORpartido + ", rebotesPORpartido=" + rebotesPORpartido + "]";
    }

    

    

    
    
}
