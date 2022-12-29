package tema4.Entregas.Actividad3;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Actividad3Test {
    private static String  RUTA= "src\\main\\java\\tema4\\Entregas\\Actividad3\\alumnosActividad3.xml";
    public static void main(String[] args) throws SQLException {
        Scanner leer = new Scanner(System.in);
        AlumnoBD conexion= new AlumnoBD();
        System.out.println("Curso a consultar:");
        String curso=leer.next();
        leer.close();
        //ConectamosBBDD
        conexion.conectar();
        //Método de esta propia clase que crea el xml, recogiendo los datos del método creado en clase AlumnoBD
        System.out.println("Xml creado: "+crearXMl(conexion.consultarAlumnos(curso)));
        ;
       
        //DesconectamosBBDD
        conexion.desconectar();
        
    }

    //Método usado para crear el xml desde la base de datos
    public static boolean crearXMl(List<Alumno> lis) {
        boolean ok=false;
        Alumnos alumnos = new Alumnos();
        alumnos.setAlumnos(lis);
        JAXBContext contexto;
        try {
            contexto = JAXBContext.newInstance(Alumnos.class);
             // objeto marshaller para escribir
            Marshaller mar = contexto.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Escribir al XML
             mar.marshal(alumnos, new File(RUTA));
            ok=true;

        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        return ok;
    
    }
}


