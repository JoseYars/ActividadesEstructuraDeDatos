public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();

        pila.insertar(14);
        pila.insertar(27);
        pila.insertar(1);
        pila.insertar(15);
        pila.insertar(10);
        pila.insertar(90);
        pila.insertar(71);
        pila.insertar(37);
        pila.insertar(2);
        pila.insertar(48);

        System.out.println("Tamaño de la Pila: " + pila.getTamanio());

        System.out.println("Quitanto los 4 primeros elementos de la pila...");
        for (int i = 0; i < 4; i++) {
                pila.quitar();
        }

        System.out.println("Elemento en la cima de la Pila: " + pila.obtenerCima());

        System.out.println("vaciando pila...");
        pila.vaciar();

        System.out.println("La pila está vacía: " + pila.estaVacia());
        
    }
}
