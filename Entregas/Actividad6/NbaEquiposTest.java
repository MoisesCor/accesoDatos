package tema4.Entregas.Actividad6;

import java.sql.SQLException;

public class NbaEquiposTest {
    public static void main(String[] args) throws SQLException {
        NbaEquiposCRUD equipo= new NbaEquiposCRUD("Celtics", "Boston", "East", "Atlantic");

         //Creamos el equipo en la BBDD y traemos su id.
         int idGenerado = equipo.create();
         System.out.println("1-Create: idGenerado=" + idGenerado);

         /*Leemos el equipo creado filtrando por su KEY en este caso, para que sea como
          * la actividad 4 ( como se pide en el enunciado), se creo modifico la bbdd para añadirle
          un id increment
          */
          NbaEquiposCRUD equipo2=NbaEquiposCRUD.read(idGenerado);
          System.out.println("2-Read: Equipo leído: " + equipo2);

          /*Actualizamos algún dato de esa tabla, en este caso es el nombre
           * pero creo el update como si actualizase todos, ya que es genérico doy la opción de actualizar
           * cualquier dato, en este caso, he modificado la BBDD para incluirle un id autoincrement
           */
          equipo2.setNombre("nuevoNombre");

          equipo2.update();

          /*Creamos otro objeto equipo para leer los cambios, (igual que el anterior no haría falta) */
          NbaEquiposCRUD equipo3=NbaEquiposCRUD.read(idGenerado);
          System.out.println("3 y 4 update-read= Equipo leído tras cambio: " + equipo3);

          /*Borramos el equipo creado de la BBDD, y comprobamos si impride datos */
          equipo3.delete();
          NbaEquiposCRUD equipo4 = NbaEquiposCRUD.read(idGenerado);
            System.out.println("5y6 delete-read: Equipo leido: " + equipo4);

    }
}
