package tema4.Entregas.Actividad1;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "alumnos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Alumnos {
    @XmlElement(name = "alumno")
    private List<Alumno> alumnos = null;

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

	@Override
	public String toString() {
		return "Alumnos [alumnos=" + alumnos + "]";
	}
	

}
