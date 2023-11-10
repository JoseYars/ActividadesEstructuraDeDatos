public class NodoArbol<T> {
  private T dato;
  private boolean esBinario = false;
  private NodoArbol<T> primerHijo;
  private NodoArbol<T> siguienteHermano;

  // Constructro de los nodos, pide una variable genrica y construye el nodo
  public NodoArbol(T dato) {
    this.dato = dato;
    primerHijo = null;
    siguienteHermano = null;
  }

  /*
   * Agrega un nodo hijo
   * pide parametro Nodo
   * revisa que respete las reglas de binario
   * si se respetan las reglas agrega el nodo hijo
   */

  public void agregarHijo(NodoArbol<T> hijo) {
    if (primerHijo == null) {
      primerHijo = hijo;
    } else {
      NodoArbol<T> hermano = this.primerHijo;

      if (esBinario) {
        if (hermano.siguienteHermano != null) {
          System.err.println("El nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());
        } else {
          hermano.siguienteHermano = hijo;
        }
      } else {
        while (hermano.siguienteHermano != null) {
          hermano = hermano.siguienteHermano;
        }
        hermano.siguienteHermano = hijo;
      }
    }
  }

  // retorna el primer hijo de un nodo
  public NodoArbol<T> obtenerPrimerHijo() {
    return primerHijo;
  }

  // retorna el hermano del nodo el cual solicitamos
  public NodoArbol<T> obtenerSiguienteHermano() {
    return siguienteHermano;
  }

  // retorna el dato encontrado en el nodo
  public T getDato() {
    return dato;
  }

  // Nos retorna el valor boleano que identifica que nuestro arbol sea binario
  public boolean esBinario() {
    return esBinario;
  }

  // cambia el nodo boleano para hacerlo true
  public void setEsBinario(boolean esBinario) {
    this.esBinario = esBinario;
  }

  // impresion en prefijo
  public void imprimirEnPrefijo() {
    System.out.print(dato + "\t");
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPrefijo();
      hijo = hijo.siguienteHermano;
    }
  }

  // impresion en infijo
  public void imprimirEnInfijo() {
    NodoArbol<T> hijo = primerHijo;

    if (hijo != null) {
      hijo.imprimirEnInfijo();
    }

    System.out.print(dato + "\t");
    while (hijo != null) {
      hijo = hijo.siguienteHermano;
      if (hijo != null) {
        hijo.imprimirEnInfijo();
      }
    }
  }

  // impresion en posfijo
  public void imprimirEnPosfijo() {
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPosfijo();
      hijo = hijo.siguienteHermano;
    }

    System.out.print(dato + "\t");
  }
}
