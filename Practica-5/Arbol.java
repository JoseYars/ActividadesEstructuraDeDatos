public class Arbol<T> {
  private NodoArbol<T> raiz;
  private boolean esBinario = false;

  /**
   * constructor del arbol
   * 
   * @param dato
   * @param esBinario
   */
  public Arbol(T dato, boolean esBinario) {
    raiz = new NodoArbol<T>(dato);
    raiz.setEsBinario(esBinario);
    this.esBinario = esBinario;
  }

  /**
   * Retorna la raiz del arbol
   * 
   * @return
   */
  public NodoArbol<T> obtenerRaiz() {
    return raiz;
  }

  /**
   * nos dice si el arbol es binario
   * 
   * @return
   */
  public boolean esBinario() {
    return esBinario;
  }

  /**
   * agrega nodos al arbol respetando que sea binario
   * 
   * @param nodoRaiz
   * @param nodoAgregado
   */
  public void agregarNodoArbol(NodoArbol<T> nodoRaiz, NodoArbol<T> nodoAgregado) {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);
    }

    nodoRaiz.agregarHijo(nodoAgregado);
  }

  /**
   * imprime por medio de nuestros Enums los recorridos
   * prefijo
   * posfijo
   * infijo
   * 
   * @param recorrido
   */

  public void imprimirArbol(Recorrido recorrido) {
    switch (recorrido.ordinal()) {
      case 0:
        System.out.println("Prefijo: ");
        raiz.imprimirEnPrefijo();
        break;

      case 1:
        System.out.println("\nInfijo: ");
        raiz.imprimirEnInfijo();
        break;

      case 2:
        System.out.println("\nPosfijo: ");
        raiz.imprimirEnPosfijo();
        break;

      default:
        break;
    }
  }
}