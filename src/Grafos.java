// Proyecto académico: Estructuras de Datos en Java
// Autor: Leonel Sarubbe
// Tema: Grafos y matriz de adyacencia

public class Grafos {

    // Cantidad de vértices del grafo.
    private int cantidadVertices;

    // Matriz de adyacencia.
    private int[][] matriz;

    // Constructor del grafo.
    public Grafos(int cantidadVertices) {

        this.cantidadVertices = cantidadVertices;

        matriz = new int[cantidadVertices][cantidadVertices];
    }

    // Método para agregar una conexión entre dos vértices.
    public void agregarArista(int origen, int destino) {

        matriz[origen][destino] = 1;

        // En este ejemplo el grafo es no dirigido,
        // por eso también agregamos la conexión inversa.
        matriz[destino][origen] = 1;
    }

    // Método para mostrar la matriz de adyacencia.
    public void mostrarMatriz() {

        System.out.println("Matriz de adyacencia:");

        for (int i = 0; i < cantidadVertices; i++) {

            for (int j = 0; j < cantidadVertices; j++) {

                System.out.print(matriz[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Método para verificar si existe una conexión.
    public boolean existeConexion(int origen, int destino) {

        return matriz[origen][destino] == 1;
    }

    public static void main(String[] args) {

        // Creamos un grafo con 5 vértices.
        Grafos grafo = new Grafos(5);

        // Agregamos diferentes conexiones.
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 4);
        grafo.agregarArista(3, 4);

        // Mostramos la matriz.
        grafo.mostrarMatriz();

        // Consultamos si existe una conexión.
        int origen = 0;
        int destino = 2;

        if (grafo.existeConexion(origen, destino)) {

            System.out.println(
                "\nExiste una conexión entre " +
                origen + " y " + destino
            );

        } else {

            System.out.println(
                "\nNo existe una conexión entre " +
                origen + " y " + destino
            );
        }
    }
}
