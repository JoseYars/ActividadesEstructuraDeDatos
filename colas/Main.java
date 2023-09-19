public class Main {
    
public static void main (String [] args){
    
    System.out.println("Cola simple");
ColaSimple cola = new ColaSimple();
cola.insertar(1);
cola.insertar(2);
cola.insertar(3);
cola.insertar(4);
cola.insertar(5);
System.out.printf("Longitud: %d\n", cola.getLongitud());
System.out.printf("Frente: %d\n", cola.getFrente().getDato());
cola.eliminar();
System.out.printf("Longitud: %d\n", cola.getLongitud());
System.out.printf("Frente: %d\n", cola.getFrente().getDato());


ColaCircular colaC = new ColaCircular();
System.out.println("Cola ciruclar");
colaC.insertar(2);
colaC.insertar(4);
colaC.insertar(6);
colaC.insertar(8);
colaC.insertar(10);
System.out.printf("Longitud: %d\n", colaC.getLongitud());
System.out.printf("Frente: %d\n", colaC.getFrente().getDato());
System.out.printf("Atras: %d\n", colaC.getAtras().getDato());
System.out.println("SE ELIMINO UN TERMINO");
colaC.eliminar();
System.out.printf("Longitud: %d\n", colaC.getLongitud());
System.out.printf("Frente: %d\n", colaC.getFrente().getDato());
System.out.printf("Atras: %d\n", colaC.getAtras().getDato());
colaC.vaciar();

try {
    Nodo frente = colaC.getFrente();
    System.out.printf("Frente: %d\n", frente.getDato());
} catch (NullPointerException e) {
    System.out.println("Frente: La cola está vacía.");
}

try {
    Nodo atras = colaC.getAtras();
    System.out.printf("Atras: %d\n", atras.getDato());
} catch (NullPointerException e) {
    System.out.println("Atras: La cola está vacía.");
}

}

}
