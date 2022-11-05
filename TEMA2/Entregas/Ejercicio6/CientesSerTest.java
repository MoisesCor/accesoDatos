package TEMA2.Entregas.Ejercicio6;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class CientesSerTest {
    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        int opcion;
        TreeSet<ClientesSer> lista1Test= UtilidadesCLIENTES_SER.datosPredeterminados();
        do{
            System.out.println("1-Alta cliente"+ "\n"+
                               "2-Baja cliente"  + "\n"+
                               "3-Listar clientes"+ "\n"+
                               "4-Saldo medio clientes"+ "\n"+
                               "5-Salir");
            opcion=leer.nextInt();


            switch(opcion){
                case 1:
               lista1Test= UtilidadesCLIENTES_SER.introduceNuevoCliente(lista1Test);
                break;

                case 2:
                lista1Test= UtilidadesCLIENTES_SER.eliminarCLiente(lista1Test);
                break;

                case 3:
                System.out.println(lista1Test);
                break;
                
                case 4:
                UtilidadesCLIENTES_SER.calcularMediaDinero();
                break;

                case 5:
                System.out.println("ADIOS");
                break;

                default:
                break;
            }

        }while(opcion!=5);
    }
}

    
