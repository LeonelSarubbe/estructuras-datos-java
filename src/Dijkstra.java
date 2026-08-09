// Proyecto académico: Estructuras de Datos en Java
// Autor: Leonel Sarubbe
// Tema: Algoritmo de Dijkstra

public class Dijkstra {

    // Cantidad de vértices del grafo.
    private static final int VERTICES = 5;

    // Valor utilizado para representar que no existe conexión.
    private static final int INFINITO = 999999;

    // Método que busca el vértice que tiene
    // la menor distancia conocida.
    private static int buscarMenorDistancia(
            int[] distancias,
            boolean[] visitados) {

        int menor = INFINITO;
        int indiceMenor = -1;

        for (int i = 0; i < VERTICES; i++) {

            if (!visitados[i] && distancias[i] < menor) {

                menor = distancias[i];
                indiceMenor = i;
            }
        }

        return indiceMenor;
    }

    // Algoritmo de Dijkstra.
    public static void dijkstra(int[][] grafo, int origen) {

        // Arreglo que almacena la distancia mínima
        // desde el vértice de origen.
        int[] distancias = new int[VERTICES];

        // Arreglo que indica qué vértices ya fueron procesados.
        boolean[] visitados = new boolean[VERTICES];

        // Inicializamos todas las distancias con infinito.
        for (int i = 0; i < VERTICES; i++) {

            distancias[i] = INFINITO;
            visitados[i] = false;
        }

        // La distancia desde el origen hacia sí mismo es 0.
        distancias[origen] = 0;

        // Procesamos todos los vértices.
        for (int contador = 0; contador < VERTICES - 1; contador++) {

            // Buscamos el vértice no visitado
            // con menor distancia.
            int actual = buscarMenorDistancia(
                    distancias,
                    visitados
            );

            // Marcamos el vértice como visitado.
            visitados[actual] = true;

            // Revisamos los vértices vecinos.
            for (int vecino = 0; vecino < VERTICES; vecino++) {

                // Verificamos que exista una conexión
                // y que el vecino todavía no haya sido visitado.
                if (!visitados[vecino]
                        && grafo[actual][vecino] != INFINITO
                        && distancias[actual] != INFINITO
                        && distancias[actual]
                        + grafo[actual][vecino]
                        < distancias[vecino]) {

                    // Actualizamos la distancia mínima.
                    distancias[vecino] =
                            distancias[actual]
                            + grafo[actual][vecino];
                }
            }
        }

        // Mostramos los resultados.
        System.out.println(
                "Distancias mínimas desde el vértice "
                + origen + ":"
        );

        for (int i = 0; i < VERTICES; i++) {

            System.out.println(
                    "Hasta el vértice "
                    + i
                    + ": "
                    + distancias[i]
            );
        }
    }

    public static void main(String[] args) {

        // Creamos un grafo ponderado.
        //
        // Cada número representa el costo
        // de ir de un vértice a otro.
        int[][] grafo = {

            {0,    10,   3,    INFINITO, INFINITO},

            {10,   0,    1,    2,        INFINITO},

            {3,    1,    0,    8,        2},

            {INFINITO, 2, 8,  0,        7},

            {INFINITO, INFINITO, 2, 7, 0}
        };

        // Calculamos las distancias mínimas
        // comenzando desde el vértice 0.
        dijkstra(grafo, 0);
    }
}
