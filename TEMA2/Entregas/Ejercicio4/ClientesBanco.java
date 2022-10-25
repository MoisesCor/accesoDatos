package TEMA2.Entregas.Ejercicio4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClientesBanco implements Comparable<ClientesBanco> {
    private String sDNI;
    private String sNombre;
    private LocalDate dFechaNacimiento;
    private double dSaldo;

    static Scanner leer = new Scanner(System.in);

    /* Getters and Setters */
    public String getsDNI() {
        return sDNI;
    }
    public void setsDNI(String sDNI) {
        this.sDNI = sDNI;
    }
    public String getsNombre() {
        return sNombre;
    }
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }
   
    public double getdSaldo() {
        return dSaldo;
    }
    public void setdSaldo(double dSaldo) {
        this.dSaldo = dSaldo;
    }
    public LocalDate getdFechaNacimiento() {
        return dFechaNacimiento;
    }
    public void setdFechaNacimiento(LocalDate dFechaNacimiento) {
        this.dFechaNacimiento = dFechaNacimiento;
    }

    public ClientesBanco(String sDNI, String sNombre, String dFechaNacimiento, String dSaldo) {
        /* Los datos se piden como string todos y en el contructor parseamos */
        this.sDNI = sDNI;
        this.sNombre = sNombre;
        this.dFechaNacimiento = LocalDate.parse(dFechaNacimiento,DateTimeFormatter.ofPattern("d/M/yyyy")) ;
        this.dSaldo = Double.parseDouble(dSaldo);
    }

    /* Método cargar clientes en lista */
    public static TreeSet<ClientesBanco> ClientesBanco(){
        TreeSet<ClientesBanco> lista1= new TreeSet<ClientesBanco>();
        
        try (BufferedReader bfIn = new BufferedReader(new FileReader("C:\\Moises\\ppp\\ejercicio4\\clientes.txt\\"))) {
            String sTexto= bfIn.readLine();
            while(sTexto!=null){
               sTexto= sTexto.replaceAll(",", "\\."); // para sustituir la coma del decimal por punto.
              String[] partes= sTexto.split(" ");
              lista1.add(new ClientesBanco(partes[0], partes[1], partes[2], partes[3]));
                sTexto= bfIn.readLine();
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista1;
    }

    /*Método creación nuevo usuario */
    public static TreeSet<ClientesBanco> introduceNuevaT(){
        Matcher mat = null;
		Pattern pat1 = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})");
        
        String datos,cadena="",fecha;
        Path path = Paths.get("C:\\Moises\\ppp\\ejercicio4\\clientes.txt\\");
        System.out.println("Introduce DNI cliente");
        datos=leer.next().replaceAll(" ", "");
        cadena+=datos+" ";

        System.out.println("Introduce nombre cliente");
        datos=leer.next().replaceAll(" ", "");
        cadena+=datos+" ";

        do{
        System.out.println("Introduce fecha nacimiento cliente FORMATO 01/09/1992");
        fecha=leer.next();
        mat= pat1.matcher(fecha);
        if(!mat.matches()){
            System.out.println("formato de fecha incorrecto");
        }else{
            datos=fecha.replaceAll(" ", "");
            cadena+=datos+" ";
        }
       
        }while(!mat.matches());

        System.out.println("Introduce saldo cliente");
        datos=leer.next().replaceAll("\\.", ",").replaceAll(" ", "");;
        cadena+=datos;

        try {
            Files.write(path, ("\r\n"+cadena).getBytes(), StandardOpenOption.APPEND);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ClientesBanco(); 

    }
    @Override
    public String toString() {
        /* reescrito para que salga la edad de los clientes, llamando al método calcular edad */
        return "DNI "+sDNI+" Nombre "+sNombre+" fecha nacimiento "+dFechaNacimiento+" saldo "+dSaldo+" EDAD CLIENTE "+calcularAños(dFechaNacimiento)+"\n";
    }
    public long calcularAños(LocalDate fecha){
        /* Método calcular edad */
        return ChronoUnit.YEARS.between(fecha, LocalDate.now());
    }
    
    public static void calcularMediaDinero(){
        /* método para calcular la medía*/
        TreeSet<ClientesBanco> listaAux= ClientesBanco();
        double media=0;
        for(ClientesBanco aux: listaAux){
            media= media+ aux.getdSaldo();
        }
        System.out.println(media/listaAux.size());
    }

    public static TreeSet<ClientesBanco> eliminarContacto(TreeSet<ClientesBanco> listaOrigen){
        /* Método que comprueba si en el fichero existe el dni
         * y escribe un fichero temporal con las lineas que no contengan ese dni
         * luego renombras el fichero creado al de origen
         * y llamas al método cargar clientes, para que sobreescriba la colección
         * existente con los datos modificados tras el borrado.
         * Para evitar errores quitamos espacios en blaco y ponemos todo a MAY
         */
        Boolean ok=false;
        System.out.println("Introduce DNI cliente que quieres borrar");
        String dni=leer.next().replaceAll(" ", "");
        try{
            File fileOrigen= new File("C:\\Moises\\ppp\\ejercicio4\\clientes.txt\\");
            File fileTemporal= new File(fileOrigen.getAbsolutePath()+".tmp");
            BufferedReader br = new BufferedReader(new FileReader(fileOrigen));
            PrintWriter pw = new PrintWriter(new FileWriter(fileTemporal));
            String line = null;

            while ((line = br.readLine()) != null) {
                
              if (!line.toUpperCase().contains(dni.toUpperCase())) {
                  System.out.println(line);
                     pw.println(line);
                     
                    //pw.flush(); para que se usa?
                 }else{
                    ok=true;
                 }
             }
                br.close();
                pw.close();
           //Borrar original y cambiar nombre al nuevo por el que tenía original
           fileOrigen.delete();
           fileTemporal.renameTo(fileOrigen);
           System.out.println("Eliminado= "+ok);
       
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            
        }
        return ClientesBanco();
    }

    @Override
    public int compareTo(ClientesBanco o) {
        /* Implementado y sobreescrito para poder
         * ordenar el tree con el parametro saldo 
         */
        if(this.dSaldo<o.dSaldo){
            return 1;
        }else {
            return -1;
        }
        
    }
    
}
