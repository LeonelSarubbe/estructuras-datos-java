// Proyecto académico: Estructuras de Datos en Java
// Autor: Leonel Sarubbe
// Tema: Árbol Binario de Búsqueda

public class ArbolBinario {

    // Clase Nodo
    // Cada nodo contiene un valor y dos referencias:
    // una hacia el hijo izquierdo y otra hacia el hijo derecho.
    static class Nodo {
        int dato;
        Nodo izquierdo;
        Nodo derecho;

        // Constructor del nodo
        Nodo(int dato) {
            this.dato = dato;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    // Clase que representa el árbol
    static class Arbol {

        Nodo raiz;

        // Constructor del árbol
        Arbol() {
            raiz = null;
        }

        // Método para insertar un valor
        void insertar(int dato) {

            raiz = insertarRecursivo(raiz, dato);
        }

        // Método recursivo para realizar la inserción
        Nodo insertarRecursivo(Nodo nodo, int dato) {

            // Si encontramos un espacio vacío,
            // creamos un nuevo nodo.
            if (nodo == null) {
                return new Nodo(dato);
            }

            // Si el dato es menor, lo colocamos a la izquierda.
            if (dato < nodo.dato) {
                nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);
            }

            // Si el dato es mayor, lo colocamos a la derecha.
            else if (dato > nodo.dato) {
                nodo.derecho = insertarRecursivo(nodo.derecho, dato);
            }

            return nodo;
        }

        // Recorrido inorden
        // Permite mostrar los valores ordenados.
        void inorden(Nodo nodo) {

            if (nodo != null) {

                inorden(nodo.izquierdo);

                System.out.print(nodo.dato + " ");

                inorden(nodo.derecho);
            }
        }

        // Método para buscar un valor
        boolean buscar(int dato) {

            return buscarRecursivo(raiz, dato);
        }

        // Búsqueda recursiva
        boolean buscarRecursivo(Nodo nodo, int dato) {

            // Si llegamos a un espacio vacío,
            // significa que el dato no está.
            if (nodo == null) {
                return false;
            }

            // Encontramos el dato.
            if (nodo.dato == dato) {
                return true;
            }

            // Si el dato es menor, buscamos a la izquierda.
            if (dato < nodo.dato) {
                return buscarRecursivo(nodo.izquierdo, dato);
            }

            // Si es mayor, buscamos a la derecha.
            return buscarRecursivo(nodo.derecho, dato);
        }
    }

    public static void main(String[] args) {

        // Creamos un árbol binario de búsqueda.
        Arbol arbol = new Arbol();

        // Insertamos diferentes valores.
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);

        // Mostramos el recorrido inorden.
        System.out.println("Recorrido inorden:");

        arbol.inorden(arbol.raiz);

        System.out.println();

        // Buscamos un valor.
        int valorBuscado = 60;

        if (arbol.buscar(valorBuscado)) {
            System.out.println(
                "El valor " + valorBuscado + " se encuentra en el árbol."
            );
        } else {
            System.out.println(
                "El valor " + valorBuscado + " no se encuentra en el árbol."
            );
        }
    }
}
