package TEMA2.main.clase.EjemplosCLase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerIOfINALLY {
    /**
     * @param args
     */
    public static void main(String[] args) {
        final String RUT_FIN="C:\\Users\\Moisés\\Desktop\\DAM 2\\Acceso a datos\\TEMA2";
        String sTexto="";
        BufferedReader bfIn=null;
        try  {
            FileReader frIn = new FileReader(RUT_FIN+"prueba.txt");
            bfIn=new BufferedReader(frIn);
            sTexto=bfIn.readLine();
            while(sTexto!=null){
                System.out.println(sTexto);
                sTexto=bfIn.readLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            
        }
    }
}