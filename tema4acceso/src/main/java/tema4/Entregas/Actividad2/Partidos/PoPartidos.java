package tema4.Entregas.Actividad2.Partidos;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "partidos")
@XmlAccessorType(XmlAccessType.FIELD)
public class PoPartidos {
    @XmlElement(name = "partido")
    private List<PoPartido> partidos = null;

    public List<PoPartido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<PoPartido> partidos) {
        this.partidos = partidos;
    }

    @Override
    public String toString() {
        return "PoPartidos [partidos=" + partidos + "]";
    }

    
    
    
}
