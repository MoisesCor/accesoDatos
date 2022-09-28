package entregasMJG;

public class ComplejoTest {
    public static void main(String[] args) {
        //Declaración objetos de clase
        Complejo c1= new Complejo(0,0);
        Complejo c2= new Complejo(0, 0);

        //Llamada al método que se encarga de dar valor a los atributos
        c1.asignar(3, 9);
        c2.asignar(10, 5);

        // Llamada al método que se encarga de dar formáto y lo imprime
        System.out.print("Contenido del complejo 1: ");
        c1.imprimir();
        System.out.println();
        System.out.print("Contenido del complejo 2: ");
        c2.imprimir();
        System.out.println();

        System.out.println("Suma compleja:");
        System.out.print("(");
        c1.imprimir();
        System.out.print(") + (");
        c2.imprimir();
        System.out.print(") = ");
        System.out.println();
        
        //Llamada al método de objeto, que se encarga de la suma por partes
        c1.sumar(c2);
        
    }
    
}
