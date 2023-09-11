
public class Pila {
    private Nodo cima;
    private int tamanio;

    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    public void insertar(int elemento) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setDato(elemento);
        nuevoNodo.setNodo(cima);
        cima = nuevoNodo;
        tamanio++;
    }

    public int quitar() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        int elemento = cima.getDato();
        cima = cima.getNodo();
        tamanio--;
        return elemento;
    }

    public boolean estaVacia() {
        return tamanio == 0;
    }

    public void vaciar() {
        cima = null;
        tamanio = 0;
    }

    public int obtenerCima() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return cima.getDato();
    }

    public int getTamanio() {
        return tamanio;
    }
}