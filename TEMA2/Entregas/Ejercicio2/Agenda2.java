package TEMA2.Entregas.Ejercicio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class Agenda2   {
    HashMap<String, Integer> agenda;

    public Agenda2(HashMap<String, Integer> agenda) {
        this.agenda = agenda;
    }

    
    public Agenda2(){
        HashMap<String, Integer> agendaaux = new HashMap<String,Integer>();
        try (BufferedReader bfIn = new BufferedReader(new FileReader("C:\\Moises\\ppp\\ejercicio2\\agenda.txt\\"))) {
            String sTexto= bfIn.readLine();
            while(sTexto!=null){
                String[] partes= sTexto.split("\\s+");
                agendaaux.put(partes[0], Integer.parseInt(partes[1]));
                sTexto=bfIn.readLine();
            }
            this.agenda=agendaaux;
                

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean crearNuevoContacto(String nombre, int num){
        File file = new File("C:\\Moises\\ppp\\ejercicio2\\agenda.txt\\");

        try (FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(writer);) {
        
            if(!this.agenda.containsKey(nombre) && this.agenda.size()<20){
                this.agenda.put(nombre, num);
                bw.append("\r\n");
                bw.write(nombre+" "+num);

                
            }else{
                System.out.println("Contacto ya existe");
                return false;
            }
            bw.close();
            
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
       
    }

    //Buscador de agenda.
    public void buscarContacto(String patron){
       
        for(String nombre: agenda.keySet()){
            if(nombre.startsWith(patron)){
                System.out.println(nombre+" "+agenda.get(nombre));
                
            }
        }
    }

    public void listarAgenda(){
        TreeMap<String, Integer> map1 = new TreeMap<>();
        map1.putAll(this.agenda);
        for(String nombre: map1.keySet()){
            System.out.println(nombre+" "+map1.get(nombre));
        }
    }

    public boolean borrarContacto(String nombre){
        return true;
    }


    @Override
    public String toString() {
        return "Agenda2 [agenda=" + agenda + "]";
    }


 


   

    
}
