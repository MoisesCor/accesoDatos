package tema4.Entregas.Actividad7.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import tema4.Entregas.Actividad7.MODEL.Alumno;
import tema4.Entregas.Actividad7.UTIL.DatabaseConnection;



public class AlumnoDAOImplementation implements AlumnosDAO {
    private static  int idAuxiliar=0;// CREAMOS KEY AUXILIAR DONDE GUARDAMOS EL VALOR ANTIGUO PARA PODER EFECTUAR CAMBIOS
    

    @Override
    public void create(Alumno alumno) throws SQLException {
        String sInsert = "INSERT INTO alumnos (nombre,fnac,media,curso) values (?,?,?,?)";
        Connection conexion= DatabaseConnection.getInstance();
      
        PreparedStatement prepStatement = conexion.prepareStatement(sInsert,Statement.RETURN_GENERATED_KEYS);
        prepStatement.setString(1, alumno.getNombre());
                prepStatement.setString(2, alumno.getFnac());
                prepStatement.setDouble(3, alumno.getMedia());
                prepStatement.setString(4, alumno.getCurso());
                prepStatement.executeUpdate();
                ResultSet res;
                res = prepStatement.getGeneratedKeys();
                if (res.next()) {
                    idAuxiliar = res.getInt(1);

                }
                DatabaseConnection.desconectar();
            }

                


        
    

    @Override
    /*Método genérico donde todas las opciones de leer pedidas se han implementado
     * según la opcion elegida por el usuario el valor de la sentencia será correspondiente
     * para ello he usado un if else, para darle valor
     */
    public void read(int id) throws SQLException {
        
            String clase="alumnos";

           
            String sentencia="";
            if(id==2){
                
             sentencia="SELECT * FROM alumnos";
             

            }else if(id==3){
               clase= seleccionClase();
                sentencia="SELECT * FROM alumnos where curso=?";

            }else if(id==4){
                clase= seleccionClase();
                sentencia="SELECT AVG(media) FROM alumnos WHERE curso=?";
                
            }else{
                clase= seleccionClase();
                sentencia="SELECT * FROM alumnos WHERE curso=? AND media<5";

            }

         
             
            Connection conexion= DatabaseConnection.getInstance();
            ResultSet res = null;
            System.out.println("Ejecutando: " + sentencia);
            	PreparedStatement prepStatement = conexion.prepareStatement(sentencia);
                /*If donde compruebo si la sentencia incluye parametros, o es la global
                 * en este caso si no es la global necesitamos la clase para pasarla por el where
                 * entonces añadimos el parametro a la sentencia 
                 */
                if(id!=2){
                    prepStatement.setString(1, clase);
                }
                
            	res = prepStatement.executeQuery();

                if (res != null) {
                    
                    while (res.next()) {
                        /*if que depende de que opción sea mostrara un syso u otro */
                        if(id==4){
                            System.out.println(res.getDouble(1));
                        }else{
                            System.out.println(res.getString("nombre")+" "+ res.getString("fnac")
                            +" "+res.getInt("media")+" "+res.getString("curso"));
                        }
                       
                    }
                }
                prepStatement.close();
                res.close();
                DatabaseConnection.desconectar();
        
            
        
    }
    /*Método actualizar */
    @Override
    public void update(Alumno alumno) {
        
        try {
            Connection conexion= DatabaseConnection.getInstance();
            String sql= "UPDATE alumnos set nombre=?,fnac=?,media=?,curso=? Where num=?";
            PreparedStatement prepStatement;
            prepStatement = conexion.prepareStatement(sql);
            prepStatement.setString(1, alumno.getNombre());
            prepStatement.setString(2, alumno.getFnac());
            prepStatement.setDouble(3, alumno.getMedia());
            prepStatement.setString(4, alumno.getCurso());
            prepStatement.setInt(5, idAuxiliar);
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DatabaseConnection.desconectar();
        }
        
        
    }
    /*Método borrar */
    @Override
    public void delete(int id) {
        try {
            Connection conexion= DatabaseConnection.getInstance();
            String sql = "delete from alumnos where num=?";
            PreparedStatement prepStatement = conexion.prepareStatement(sql);
            prepStatement.setInt(1, idAuxiliar);
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            DatabaseConnection.desconectar();
        }
        
    }
    // Método creado para elegir la clase por teclado
    public String seleccionClase(){
        Scanner leer = new Scanner(System.in);
        String clas;
        System.out.println("Selecciona clase");
        return clas=leer.next();
    }

    /*Método creado para devolver la id del último generado, ya que mi clase alumno
     * no contiene la id como atributo y para practicar lo usado en clase de traer las keys la he mantenido asi
     */
    public static int retornarID(){
        return idAuxiliar;

    }




    
    
}
