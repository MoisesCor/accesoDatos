package tema4.Entregas.Actividad2.Partidos;

import javax.xml.bind.annotation.*;

/*anotaciones */
@XmlRootElement(name = "partido")
@XmlType(propOrder = { "equipoLocal", "equipoVisitante", "puntosLocal","puntosVisitante","temporada" })
@XmlAccessorType(XmlAccessType.FIELD)
public class PoPartido {
    @XmlElement(name = "equipoLocal")
    private String equipoLocal;
    @XmlElement(name = "equipoVisitante")
    private String equipoVisitante;
    @XmlElement(name = "puntosLocal")
    private Integer puntosLocal;
    @XmlElement(name = "puntosVisitante")
    private Integer puntosVisitante;
    @XmlElement(name = "temporada")
    private String temporada;

     /*Getters ands Setters */
    public String getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }
    public String getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }
    public Integer getPuntosLocal() {
        return puntosLocal;
    }
    public void setPuntosLocal(Integer puntosLocal) {
        this.puntosLocal = puntosLocal;
    }
    public Integer getPuntosVisitante() {
        return puntosVisitante;
    }
    public void setPuntosVisitante(Integer puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }
    public String getTemporada() {
        return temporada;
    }
    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
    public PoPartido(String equipoLocal, String equipoVisitante, Integer puntosLocal, Integer puntosVisitante,
            String temporada) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.temporada = temporada;
    }
    public PoPartido() {
    }
    @Override
    public String toString() {
        return "PoPartido [equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + ", puntosLocal="
                + puntosLocal + ", puntosVisitante=" + puntosVisitante + ", temporada=" + temporada + "]";
    }
    
   
    
    
}
