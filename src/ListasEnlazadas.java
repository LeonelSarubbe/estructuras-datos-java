// Proyecto académico: Estructuras de Datos en Java
// Autor: Leonel Sarubbe
// Tema: Lista enlazada simple

public class ListasEnlazadas {

    // Clase Nodo
    // Cada nodo guarda un dato y una referencia al siguiente nodo.
    static class Nodo {
        int dato;
        Nodo siguiente;

        // Constructor del nodo
        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // Clase que representa la lista enlazada
    static class Lista {
        Nodo inicio;

        // Constructor de la lista
        Lista() {
            inicio = null;
        }

        // Método para agregar un elemento al final
        void agregar(int dato) {

            Nodo nuevo = new Nodo(dato);

            // Si la lista está vacía, el nuevo nodo pasa a ser el primero.
            if (inicio == null) {
                inicio = nuevo;
                return;
            }

            // Recorremos la lista hasta llegar al último nodo.
            Nodo actual = inicio;

            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            // El nuevo nodo queda conectado al final.
            actual.siguiente = nuevo;
        }

        // Método para mostrar todos los elementos
        void mostrar() {

            Nodo actual = inicio;

            System.out.println("Elementos de la lista:");

            while (actual != null) {
                System.out.print(actual.dato + " -> ");
                actual = actual.siguiente;
            }

            System.out.println("null");
        }

        // Método para buscar un elemento
        boolean buscar(int dato) {

            Nodo actual = inicio;

            while (actual != null) {

                if (actual.dato == dato) {
                    return true;
                }

                actual = actual.siguiente;
            }

            return false;
        }
    }

    public static void main(String[] args) {

        // Creamos una lista enlazada.
        Lista lista = new Lista();

        // Agregamos algunos elementos.
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(40);

        // Mostramos la lista.
        lista.mostrar();

        // Realizamos una búsqueda.
        int valorBuscado = 30;

        if (lista.buscar(valorBuscado)) {
            System.out.println("El valor " + valorBuscado + " se encuentra en la lista.");
        } else {
            System.out.println("El valor " + valorBuscado + " no se encuentra en la lista.");
        }
    }
}
