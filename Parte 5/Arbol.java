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
   * Verifica si el árbol está vacío.
   *
   * @return true si el árbol está vacío, false de lo contrario.
   */
  public boolean estaVacio() {
    return raiz == null;
  }

  /**
   * Obtiene la altura del árbol.
   *
   * @return La altura del árbol.
   */
  public int obtenerAltura() {
    return obtenerAltura(raiz);
  }

  private int obtenerAltura(NodoArbol<T> nodo) {
    if (nodo == null) {
      return 0;
    } else {
      int altura = 0;
      NodoArbol<T> hijo = nodo.obtenerPrimerHijo();
      while (hijo != null) {
        int alturaHijo = obtenerAltura(hijo);
        altura = Math.max(altura, alturaHijo);
        hijo = hijo.obtenerSiguienteHermano();
      }
      return 1 + altura;
    }
  }

    /**
   * Imprime el subárbol desde un nodo específico en una sola línea.
   *
   * @param nodo El nodo desde el cual se imprimirá el subárbol.
   */
  public void imprimirSubArbol(NodoArbol<T> nodo) {
    if (nodo != null) {
      System.out.print("Subárbol desde " + nodo.getDato() + ": ");
      imprimirSubArbolRecursivo(nodo);
      System.out.println(); // Agrega un salto de línea al final
    } else {
      System.out.println("El nodo proporcionado es nulo.");
    }
  }

  private void imprimirSubArbolRecursivo(NodoArbol<T> nodo) {
    if (nodo != null) {
      System.out.print(nodo.getDato() + " ");
      NodoArbol<T> hijo = nodo.obtenerPrimerHijo();
      while (hijo != null) {
        imprimirSubArbolRecursivo(hijo);
        hijo = hijo.obtenerSiguienteHermano();
      }
    }
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