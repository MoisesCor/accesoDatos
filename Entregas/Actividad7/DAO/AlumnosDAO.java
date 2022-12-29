package tema4.Entregas.Actividad7.DAO;

import java.sql.SQLException;

import tema4.Entregas.Actividad7.MODEL.Alumno;



public interface AlumnosDAO {
    //poner un objet y luego el instanOf
    public void create(Alumno alumno) throws SQLException;

    public void read(int id ) throws SQLException;

    public void update(Alumno alumno);

    public void delete(int id );




    
}
