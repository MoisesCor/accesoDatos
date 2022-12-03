package tema4.Entregas.Actividad2.UtilidadesCONEXIONmain;

import java.util.List;

import javax.xml.bind.JAXBException;

import tema4.Entregas.Actividad2.Equipos.PoEquipo;
import tema4.Entregas.Actividad2.Estadisticas.PoEstadistica;
import tema4.Entregas.Actividad2.Jugadores.PoJugador;
import tema4.Entregas.Actividad2.Partidos.PoPartido;

public class prueba {

   public static void main(String[] args) throws JAXBException {
    

      List<PoPartido> partidos = Utilidades.cargarPartidos();
      System.out.println(partidos);

   }
    
}
