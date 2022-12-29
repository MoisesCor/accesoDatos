package tema4.Entregas.Actividad2.Jugadores;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "jugadores")
@XmlAccessorType(XmlAccessType.FIELD)
public class PoJugadores {
    @XmlElement(name = "jugador")
    private List<PoJugador> jugadores = null;

    public List<PoJugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<PoJugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public String toString() {
        return "PoJugadores [jugadores=" + jugadores + "]";
    }

    
    
}
