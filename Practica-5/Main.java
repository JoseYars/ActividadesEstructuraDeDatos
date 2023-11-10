public class Main {

    public static <T> void main(String[] args) {

        String raiz = "A";
        String B = "B";
        String C = "C";
        String D = "D";
        String E = "E";
        String F = "F";
        String G = "G";
        String H = "H";
        String I = "I";
        String J = "J";
        String K = "K";
        String L = "L";
        String M = "M";
        String N = "N";
        String O = "O";
        String P = "P";
        String Q = "Q";

        NodoArbol<String> B1 = new NodoArbol<String>(B);
        NodoArbol<String> C1 = new NodoArbol<String>(C);
        NodoArbol<String> D1 = new NodoArbol<String>(D);
        NodoArbol<String> E1 = new NodoArbol<String>(E);
        NodoArbol<String> F1 = new NodoArbol<String>(F);
        NodoArbol<String> G1 = new NodoArbol<String>(G);
        NodoArbol<String> H1 = new NodoArbol<String>(H);
        NodoArbol<String> I1 = new NodoArbol<String>(I);
        NodoArbol<String> J1 = new NodoArbol<String>(J);
        NodoArbol<String> K1 = new NodoArbol<String>(K);
        NodoArbol<String> L1 = new NodoArbol<String>(L);
        NodoArbol<String> M1 = new NodoArbol<String>(M);
        NodoArbol<String> N1 = new NodoArbol<String>(N);
        NodoArbol<String> O1 = new NodoArbol<String>(O);
        NodoArbol<String> P1 = new NodoArbol<String>(P);
        NodoArbol<String> Q1 = new NodoArbol<String>(Q);

        Arbol<String> arbol = new Arbol<String>(raiz, false);

        arbol.agregarNodoArbol(arbol.obtenerRaiz(), B1);
        arbol.agregarNodoArbol(arbol.obtenerRaiz(), C1);
        arbol.agregarNodoArbol(arbol.obtenerRaiz(), D1);

        arbol.agregarNodoArbol(B1, E1);
        arbol.agregarNodoArbol(B1, F1);
        arbol.agregarNodoArbol(F1, J1);
        arbol.agregarNodoArbol(F1, K1);
        arbol.agregarNodoArbol(F1, L1);

        arbol.agregarNodoArbol(D1, G1);
        arbol.agregarNodoArbol(D1, H1);
        arbol.agregarNodoArbol(D1, I1);

        arbol.agregarNodoArbol(G1, M1);
        arbol.agregarNodoArbol(M1, P1);
        arbol.agregarNodoArbol(M1, Q1);

        arbol.agregarNodoArbol(I1, N1);
        arbol.agregarNodoArbol(I1, O1);

        arbol.imprimirArbol(Recorrido.PREFIJO);

        arbol.imprimirArbol(Recorrido.INFIJO);

        arbol.imprimirArbol(Recorrido.POSFIJO);
    }

}
