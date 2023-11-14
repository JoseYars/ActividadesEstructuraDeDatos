public class ArbolAVL {
        private NodoAVL raiz;
    
        public ArbolAVL() {
            this.raiz = null;
        }
    
        // Método para obtener la altura de un nodo
        private int obtenerAltura(NodoAVL nodo) {
            if (nodo == null) {
                return 0;
            }
            return nodo.altura;
        }
    
        // Método para obtener el factor de equilibrio de un nodo
        private int obtenerFactorEquilibrio(NodoAVL nodo) {
            if (nodo == null) {
                return 0;
            }
            return obtenerAltura(nodo.izquierdo) - obtenerAltura(nodo.derecho);
        }
    
        // Método para actualizar la altura de un nodo
        private void actualizarAltura(NodoAVL nodo) {
            if (nodo != null) {
                nodo.altura = Math.max(obtenerAltura(nodo.izquierdo), obtenerAltura(nodo.derecho)) + 1;
            }
        }
    
        // Método para realizar una rotación simple a la derecha
        private NodoAVL rotacionDerecha(NodoAVL y) {
            NodoAVL x = y.izquierdo;
            NodoAVL T2 = x.derecho;
    
            // Realizar rotación
            x.derecho = y;
            y.izquierdo = T2;
    
            // Actualizar alturas
            actualizarAltura(y);
            actualizarAltura(x);
    
            // Devolver nueva raíz
            return x;
        }
    
        // Método para realizar una rotación simple a la izquierda
        private NodoAVL rotacionIzquierda(NodoAVL x) {
            NodoAVL y = x.derecho;
            NodoAVL T2 = y.izquierdo;
    
            // Realizar rotación
            y.izquierdo = x;
            x.derecho = T2;
    
            // Actualizar alturas
            actualizarAltura(x);
            actualizarAltura(y);
    
            // Devolver nueva raíz
            return y;
        }
    
        // Método para insertar un valor en el árbol AVL
        public void insertar(int valor) {
            raiz = insertarRec(raiz, valor);
        }
    
        private NodoAVL insertarRec(NodoAVL nodo, int valor) {
            // Paso 1: Realizar la inserción normal de un árbol binario de búsqueda
            if (nodo == null) {
                return new NodoAVL(valor);
            }
    
            if (valor < nodo.valor) {
                nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
            } else if (valor > nodo.valor) {
                nodo.derecho = insertarRec(nodo.derecho, valor);
            } else {
                // Duplicados no permitidos
                return nodo;
            }
    
            // Paso 2: Actualizar la altura del nodo actual
            actualizarAltura(nodo);
    
            // Paso 3: Obtener el factor de equilibrio de este nodo para verificar si se ha desequilibrado
            int factorEquilibrio = obtenerFactorEquilibrio(nodo);
    
            // Paso 4: Realizar rotaciones si es necesario para restaurar el equilibrio
            // Rotación simple a la derecha
            if (factorEquilibrio > 1 && valor < nodo.izquierdo.valor) {
                return rotacionDerecha(nodo);
            }
    
            // Rotación simple a la izquierda
            if (factorEquilibrio < -1 && valor > nodo.derecho.valor) {
                return rotacionIzquierda(nodo);
            }
    
            // Rotación doble a la izquierda-derecha
            if (factorEquilibrio > 1 && valor > nodo.izquierdo.valor) {
                nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
                return rotacionDerecha(nodo);
            }
    
            // Rotación doble a la derecha-izquierda
            if (factorEquilibrio < -1 && valor < nodo.derecho.valor) {
                nodo.derecho = rotacionDerecha(nodo.derecho);
                return rotacionIzquierda(nodo);
            }
    
            // Sin necesidad de rotaciones, devolver el nodo sin cambios
            return nodo;
        }
    
        // Método para buscar un nodo por valor
        public void buscar(int valor) {
            if (buscarRec(raiz, valor)) {
                System.out.println("El nodo con valor " + valor + " se ha encontrado en el árbol AVL.");
            } else {
                System.out.println("No se encontró el nodo con valor " + valor + " en el árbol AVL.");
            }
        }
    
        private boolean buscarRec(NodoAVL nodo, int valor) {
            if (nodo == null) {
                return false;
            }
    
            if (valor < nodo.valor) {
                return buscarRec(nodo.izquierdo, valor);
            } else if (valor > nodo.valor) {
                return buscarRec(nodo.derecho, valor);
            } else {
                return true; // El valor se encuentra en el nodo actual
            }
        }
    
        // Método para eliminar un nodo por valor
        public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
        }


    /**
     * 
     * @param nodo
     * @param valor
     * @return
     */
    private NodoAVL eliminarRec(NodoAVL nodo, int valor) {
        // Paso 1: Realizar la eliminación normal de un árbol binario de búsqueda
        if (nodo == null) {
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRec(nodo.derecho, valor);
        } else {
            // Nodo encontrado, realizar la eliminación

            // Caso 1: Nodo con un solo hijo o sin hijos
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Caso 2: Nodo con dos hijos
            // Encontrar el sucesor in-order (el nodo más pequeño en el subárbol derecho)
            nodo.valor = encontrarMinimoValor(nodo.derecho);

            // Eliminar el sucesor in-order
            nodo.derecho = eliminarRec(nodo.derecho, nodo.valor);
        }

        // Paso 2: Actualizar la altura del nodo actual
        actualizarAltura(nodo);

        // Paso 3: Obtener el factor de equilibrio de este nodo para verificar si se ha desequilibrado
        int factorEquilibrio = obtenerFactorEquilibrio(nodo);

        // Paso 4: Realizar rotaciones si es necesario para restaurar el equilibrio

        // Rotación simple a la derecha
        if (factorEquilibrio > 1 && obtenerFactorEquilibrio(nodo.izquierdo) >= 0) {
            return rotacionDerecha(nodo);
        }

        // Rotación doble a la izquierda-derecha
        if (factorEquilibrio > 1 && obtenerFactorEquilibrio(nodo.izquierdo) < 0) {
            nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            return rotacionDerecha(nodo);
        }

        // Rotación simple a la izquierda
        if (factorEquilibrio < -1 && obtenerFactorEquilibrio(nodo.derecho) <= 0) {
            return rotacionIzquierda(nodo);
        }

        // Rotación doble a la derecha-izquierda
        if (factorEquilibrio < -1 && obtenerFactorEquilibrio(nodo.derecho) > 0) {
            nodo.derecho = rotacionDerecha(nodo.derecho);
            return rotacionIzquierda(nodo);
        }

        // Sin necesidad de rotaciones, devolver el nodo sin cambios
        return nodo;
    }

        // Método para encontrar el valor mínimo en un subárbol (sucesor in-order)

        /**
         * 
         * @param nodo
         * @return minimo valor
         */
        private int encontrarMinimoValor(NodoAVL nodo) {
            int minimoValor = nodo.valor;
            while (nodo.izquierdo != null) {
                minimoValor = nodo.izquierdo.valor;
                nodo = nodo.izquierdo;
            }
            return minimoValor;
        }

            
            public void imprimirArbol() {
                imprimirArbolRec(raiz, 0);
            }

            private void imprimirArbolRec(NodoAVL nodo, int nivel) {
                if (nodo != null) {
                    imprimirArbolRec(nodo.derecho, nivel + 1);

                    for (int i = 0; i < nivel; i++) {
                        System.out.print("\t");
                    }

                    System.out.println(nodo.valor);

                    imprimirArbolRec(nodo.izquierdo, nivel + 1);
                }
            }
            
    
    }

