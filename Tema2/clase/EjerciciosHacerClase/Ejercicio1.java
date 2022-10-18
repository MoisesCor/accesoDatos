package TEMA2.main.clase.EjerciciosHacerClase;

import java.io.File;

public class Ejercicio1 {
    public static void main(String[] args) {
       
            // Sacar contenido directorio actual y su contenido
            File miDir = new File(".");
            String[] archivos = miDir.list();
            
            for (int i = 0; i < archivos.length; i++) {
                System.out.println(archivos[i]);
                File miDir2 = new File(archivos[i]);
                if (miDir2.isDirectory()) {
                    String[] hijos = miDir2.list();
                    for (String elem : hijos) {
                        System.out.println(elem);
                    }
                }
    
            }
        }
    }
    

