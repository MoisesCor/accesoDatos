package tema4.Entregas.Actividad2.Equipos;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "equipos")
@XmlAccessorType(XmlAccessType.FIELD)
public class PoEquipos {
    @XmlElement(name = "equipo")
    private List<PoEquipo> equipos = null;

    public List<PoEquipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<PoEquipo> equipos) {
        this.equipos = equipos;
    }

    

    @Override
    public String toString() {
        return "PoEquipos [equipos=" + equipos + "]";
    }
    
    
}
