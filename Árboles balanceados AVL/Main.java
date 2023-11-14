public class Main {
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();

        
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(15);
        arbol.insertar(5);
        arbol.insertar(15);
        arbol.insertar(25);
        arbol.insertar(35);
        arbol.insertar(55);
        arbol.insertar(57);


        arbol.imprimirArbol();

        
        arbol.buscar(20); 
        arbol.buscar(25);

       
        arbol.eliminar(30);
        arbol.eliminar(5);

        arbol.imprimirArbol();

        
    }
}
