package TEMA2.Entregas.Ejercicio4;

import java.util.Scanner;
import java.util.TreeSet;

public class BancoTesMois {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion;
        TreeSet<ClientesBanco> lista1Test= ClientesBanco.ClientesBanco();
        do{
            System.out.println("1-Alta cliente"+ "\n"+
                               "2-Baja cliente"  + "\n"+
                               "3-Listar clientes"+ "\n"+
                               "4-Saldo medio clientes"+ "\n"+
                               "5-Salir");
            opcion=leer.nextInt();


            switch(opcion){
                case 1:
               lista1Test= ClientesBanco.introduceNuevaT();
                break;

                case 2:
             lista1Test= ClientesBanco.eliminarContacto(lista1Test);
                break;

                case 3:
                System.out.println(lista1Test);
                break;
                
                case 4:
                ClientesBanco.calcularMediaDinero();
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
