package tema4.Entregas.Actividad2.Estadisticas;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "estadisticas")
@XmlAccessorType(XmlAccessType.FIELD)
public class PoEstadisticas {
    @XmlElement(name = "estadistica")
    private List<PoEstadistica> estadisticas = null;

    public List<PoEstadistica> getEstadisticas() {
        return estadisticas;
    }

    public void setEstadisticas(List<PoEstadistica> estadisticas) {
        this.estadisticas = estadisticas;
    }

    @Override
    public String toString() {
        return "PoEstadisticas [estadisticas=" + estadisticas + "]";
    }

    
    
}
