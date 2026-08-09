// Proyecto académico: Estructuras de Datos en Java
// Autor: Leonel Sarubbe
// Tema: Pilas y Colas

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class EstructurasBasicas {

    public static void main(String[] args) {

        // ==============================
        // EJEMPLO DE UNA PILA (STACK)
        // ==============================

        Stack<Integer> pila = new Stack<>();

        // Agregamos elementos a la pila.
        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println("PILA:");
        System.out.println(pila);

        // Eliminamos el elemento que está en la cima.
        int elementoPila = pila.pop();

        System.out.println("Elemento retirado de la pila: " + elementoPila);
        System.out.println("Pila después de retirar: " + pila);


        // ==============================
        // EJEMPLO DE UNA COLA (QUEUE)
        // ==============================

        Queue<Integer> cola = new LinkedList<>();

        // Agregamos elementos a la cola.
        cola.add(100);
        cola.add(200);
        cola.add(300);

        System.out.println();
        System.out.println("COLA:");
        System.out.println(cola);

        // Eliminamos el primer elemento que ingresó.
        int elementoCola = cola.poll();

        System.out.println("Elemento retirado de la cola: " + elementoCola);
        System.out.println("Cola después de retirar: " + cola);
    }
}
