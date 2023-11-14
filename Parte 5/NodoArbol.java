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
  


  /**
   * Metodo que nos permite agregar hijos a un determinado nodo
   * 
   * 
   * @param hijo
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

   /**
   * Retorna el primer hijo
   * 
   * @return
   */
  public NodoArbol<T> obtenerPrimerHijo() {
    return primerHijo;
  }

   /**
   * Retorna rl hermano del nodo elegido
   * 
   * @return
   */
  public NodoArbol<T> obtenerSiguienteHermano() {
    return siguienteHermano;
  }

   /**
   * Retorna el dato guardado en el nodo
   * 
   * @return
   */
  public T getDato() {
    return dato;
  }

 
    /**
   *  Nos retorna el valor boleano que identifica que nuestro arbol sea binario
   * 
   * @return
   */
  public boolean esBinario() {
    return esBinario;
  }

   /**
   * Cambia el booleano esBinario a true
   * 
   * @return
   */
  public void setEsBinario(boolean esBinario) {
    this.esBinario = esBinario;
  }
 /**
   * impresion en prefijo
   * 
   * @return
   */
  public void imprimirEnPrefijo() {
    System.out.print(dato + "\t");
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPrefijo();
      hijo = hijo.siguienteHermano;
    }
  }

 /**
   * impresion en Infijo
   * 
   * @return
   */
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

/**
   * impresion en Posfijo
   * 
   * @return
   */
  public void imprimirEnPosfijo() {
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPosfijo();
      hijo = hijo.siguienteHermano;
    }

    System.out.print(dato + "\t");
  }
}
