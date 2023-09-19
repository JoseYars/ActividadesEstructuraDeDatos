package ListaSimple;

public class Main {

    public static void main (String args[]){
        System.out.println("Lista Simplemente Enlazada");

        ListaSimplementeEnlazada lista1 = new ListaSimplementeEnlazada();

        lista1.insertar(5);
        lista1.insertar(59);
        lista1.insertar(91);
        lista1.insertar(-17);
        lista1.insertar(73);
        lista1.insertar(34);
        lista1.insertar(40);

        System.out.println("se eliminaran los indices 2 y 3");

        lista1.eliminar(2);
        lista1.eliminar(3);

        System.out.println("Se imprimira el indice 3: " + lista1.obtener(3));

        

    } 
    
}
