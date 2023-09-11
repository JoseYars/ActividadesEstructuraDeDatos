public class Nodo {
    private int dato;
    private Nodo Nodo;

    public Nodo() {
        this.dato = 0;
        this.Nodo = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getNodo() {
        return Nodo;
    }

    public void setNodo(Nodo Nodo) {
        this.Nodo = Nodo;
    }
}