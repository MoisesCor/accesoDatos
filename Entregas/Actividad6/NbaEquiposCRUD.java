package tema4.Entregas.Actividad6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.bind.annotation.*;

/*anotaciones */
@XmlRootElement(name = "equipo")
@XmlType(propOrder = { "nombre", "ciudad", "conferencia","division" })
@XmlAccessorType(XmlAccessType.FIELD)
public class NbaEquiposCRUD {
    private static  int idAuxiliar=0;// CREAMOS KEY AUXILIAR DONDE GUARDAMOS EL VALOR ANTIGUO PARA PODER EFECTUAR CAMBIOS
    @XmlElement(name = "nombre")
    private String nombre;

    @XmlElement(name = "ciudad")
    private String ciudad;

    @XmlElement(name = "conferencia")
    private String conferencia;

    @XmlElement(name = "division")
    private String division;
    

    /*Getters and Setters */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getConferencia() {
        return conferencia;
    }

    public void setConferencia(String conferencia) {
        this.conferencia = conferencia;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    /*Constructores */
    public NbaEquiposCRUD(String nombre, String ciudad, String conferencia, String division) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.conferencia = conferencia;
        this.division = division;
    }

    public NbaEquiposCRUD() {
    }
    
    /*ToString */
    @Override
    public String toString() {
        return "PoEquipo [nombre=" + nombre + ", ciudad=" + ciudad + ", conferencia=" + conferencia + ", division="
                + division + "]";
    }

     /*Creación de las conexiones y todas las operaciones realizadas sobre BBDD: */
     static Connection conexion = null;
     static String url = "jdbc:mysql://localhost/nba3";
     static private Connection dameConexion() throws SQLException {
         return DriverManager.getConnection(url, "alumno", "0123456789");
     }
 
     static private void desconectar() {
         try {
             conexion.close();
         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
     }

     /*Crear equipo y devolver su KEY */
     public int create(){
        
        try {
            conexion=dameConexion();
            String sql = "insert into equipos(Nombre,Ciudad,Conferencia,Division) values(?,?,?,?)";
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, this.nombre);
            ps.setString(2, this.ciudad);
            ps.setString(3, this.conferencia);
            ps.setString(4, this.division);
            int a = ps.executeUpdate();
            ResultSet res;

            if (a != 0) {
                res = ps.getGeneratedKeys();
                if (res.next()) {
                    idAuxiliar = res.getInt(1);

                }
            }
          
            ps.close();
            desconectar();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return idAuxiliar;
        
     }

     /*Leer equipo por su KEY */
     public static NbaEquiposCRUD read(int id) {
        NbaEquiposCRUD aux = null;
        try {
            conexion = dameConexion();
            String consulta = "SELECT * FROM equipos where Id=?";
            PreparedStatement prepStatement = conexion.prepareStatement(consulta);
            prepStatement.setInt(1, id);
            ResultSet res = prepStatement.executeQuery();
            if (res != null) {
                while (res.next()) {
                    aux = new NbaEquiposCRUD(res.getString("Nombre"),
                    res.getString("Ciudad"),
                    res.getString("Conferencia"),
                    res.getString("Division"));
                }
            }
            prepStatement.close();
            res.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            desconectar();
        }
        return aux;
    }

    /*Actualización de datos */
    public void update() {
        try {
            conexion = dameConexion();
            String sql = "UPDATE equipos set Nombre=?,Ciudad=?,Conferencia=?,Division=? where Id=?";
            PreparedStatement prepStatement = conexion.prepareStatement(sql);
            prepStatement.setString(1, this.nombre);
            prepStatement.setString(2, this.ciudad);
            prepStatement.setString(3, this.conferencia);
            prepStatement.setString(4, this.division);
            prepStatement.setInt(5, idAuxiliar);
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            desconectar();
        }

    }

    public void delete() throws SQLException {
        try {
            conexion = dameConexion();
            String sql = "delete from equipos where Id=?";
            PreparedStatement prepStatement = conexion.prepareStatement(sql);
            prepStatement.setInt(1, this.idAuxiliar);
            prepStatement.executeUpdate();
            prepStatement.close();
        } catch (SQLException sql) {
            sql.printStackTrace();
        } finally {
            desconectar();
        }

    }



   

    
    

    
    
    

    
    
}


