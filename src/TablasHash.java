// Proyecto académico: Estructuras de Datos en Java
// Autor: Leonel Sarubbe
// Tema: Tabla Hash

public class TablasHash {

    // Clase que representa un elemento almacenado en la tabla.
    static class Elemento {
        int clave;
        String valor;

        // Constructor del elemento.
        Elemento(int clave, String valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    // Tamaño de la tabla.
    private static final int TAMANO = 10;

    // Arreglo que representa la tabla hash.
    private Elemento[] tabla;

    // Constructor de la tabla.
    public TablasHash() {
        tabla = new Elemento[TAMANO];
    }

    // Función hash.
    // Convierte una clave en una posición de la tabla.
    private int funcionHash(int clave) {
        return Math.abs(clave) % TAMANO;
    }

    // Método para insertar un elemento.
    public void insertar(int clave, String valor) {

        int posicion = funcionHash(clave);

        // Guardamos el elemento en la posición obtenida.
        tabla[posicion] = new Elemento(clave, valor);

        System.out.println(
            "Elemento insertado: clave " + clave +
            " en posición " + posicion
        );
    }

    // Método para buscar un elemento.
    public String buscar(int clave) {

        int posicion = funcionHash(clave);

        Elemento elemento = tabla[posicion];

        // Verificamos que exista un elemento
        // y que la clave sea la que buscamos.
        if (elemento != null && elemento.clave == clave) {
            return elemento.valor;
        }

        return null;
    }

    // Método para mostrar la tabla.
    public void mostrar() {

        System.out.println("\nContenido de la tabla:");

        for (int i = 0; i < TAMANO; i++) {

            if (tabla[i] != null) {

                System.out.println(
                    "Posición " + i +
                    ": clave = " + tabla[i].clave +
                    ", valor = " + tabla[i].valor
                );

            } else {

                System.out.println(
                    "Posición " + i + ": vacía"
                );
            }
        }
    }

    public static void main(String[] args) {

        // Creamos una tabla hash.
        TablasHash tabla = new TablasHash();

        // Insertamos diferentes elementos.
        tabla.insertar(10, "Juan");
        tabla.insertar(21, "Pedro");
        tabla.insertar(32, "Maria");
        tabla.insertar(43, "Lucia");

        // Mostramos el contenido.
        tabla.mostrar();

        // Realizamos una búsqueda.
        int claveBuscada = 21;

        String resultado = tabla.buscar(claveBuscada);

        if (resultado != null) {

            System.out.println(
                "\nLa clave " + claveBuscada +
                " corresponde al valor: " + resultado
            );

        } else {

            System.out.println(
                "\nLa clave " + claveBuscada +
                " no fue encontrada."
            );
        }
    }
}
