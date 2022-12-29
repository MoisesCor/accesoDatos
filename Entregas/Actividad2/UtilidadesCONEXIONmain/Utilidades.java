package tema4.Entregas.Actividad2.UtilidadesCONEXIONmain;


import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import tema4.Entregas.Actividad2.Equipos.PoEquipo;
import tema4.Entregas.Actividad2.Equipos.PoEquipos;
import tema4.Entregas.Actividad2.Estadisticas.PoEstadistica;
import tema4.Entregas.Actividad2.Estadisticas.PoEstadisticas;
import tema4.Entregas.Actividad2.Jugadores.PoJugador;
import tema4.Entregas.Actividad2.Jugadores.PoJugadores;
import tema4.Entregas.Actividad2.Partidos.PoPartido;
import tema4.Entregas.Actividad2.Partidos.PoPartidos;

public class Utilidades {
   private static String ruta_fich="src\\main\\java\\tema4\\Entregas\\Actividad2\\";
    

   //CREAR OBJETOS EQUIPOS
    public static List<PoEquipo> cargarEquipos()throws JAXBException{

        JAXBContext contexto = JAXBContext.newInstance(PoEquipos.class);
        Unmarshaller um = contexto.createUnmarshaller();
        PoEquipos au = (PoEquipos) um.unmarshal(new File(ruta_fich+"Equipos\\equipos.xml"));
        List<PoEquipo> aux=(List<PoEquipo>) au.getEquipos();
         return aux;
        
        
    }

    //CREAR OBJETOS JUGADORES
    public static List<PoJugador> cargarJugadores()throws JAXBException{

        JAXBContext contexto = JAXBContext.newInstance(PoJugadores.class);
        Unmarshaller um = contexto.createUnmarshaller();
        PoJugadores au = (PoJugadores) um.unmarshal(new File(ruta_fich+"Jugadores\\jugadores.xml"));
        List<PoJugador> aux=(List<PoJugador>) au.getJugadores();
         return aux;
        
        
    }

      //CREAR OBJETOS PARTIDOS
      public static List<PoPartido> cargarPartidos()throws JAXBException{

        JAXBContext contexto = JAXBContext.newInstance(PoPartidos.class);
        Unmarshaller um = contexto.createUnmarshaller();
        PoPartidos au = (PoPartidos) um.unmarshal(new File(ruta_fich+"Partidos\\partidos.xml"));
        List<PoPartido> aux=(List<PoPartido>) au.getPartidos();
         return aux;
        
        
    }

    //CREAR OBJETOS ESTADISTICAS
      public static List<PoEstadistica> cargarEstadisticas()throws JAXBException{

        JAXBContext contexto = JAXBContext.newInstance(PoEstadisticas.class);
        Unmarshaller um = contexto.createUnmarshaller();
        PoEstadisticas au = (PoEstadisticas) um.unmarshal(new File(ruta_fich+"Estadisticas\\estadisticas.xml"));
        List<PoEstadistica> aux=(List<PoEstadistica>) au.getEstadisticas();
         return aux;
        
        
    }

    
}
