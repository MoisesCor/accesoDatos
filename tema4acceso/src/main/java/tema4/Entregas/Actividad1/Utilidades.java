package tema4.Entregas.Actividad1;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class Utilidades {
    static String ruta_fich="src\\main\\java\\tema4\\Entregas\\Actividad1\\";

    public static List<Alumno> crearObjetos() throws JAXBException{

        JAXBContext contexto = JAXBContext.newInstance(Alumnos.class);
            Unmarshaller um = contexto.createUnmarshaller();
            Alumnos au = (Alumnos) um.unmarshal(new File(ruta_fich + "alumnos.xml"));
            List<Alumno> aux=(List<Alumno>) au.getAlumnos();
        return aux;

    }
}
