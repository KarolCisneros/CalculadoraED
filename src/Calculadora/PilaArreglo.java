package Calculadora;

/**
 * La clase {@code PilaArreglo} implementa una pila (LIFO) genérica usando un arreglo.
 * Proporciona métodos para ingresar, sacar, y verificar el estado de la pila.
 * Si la capacidad de la pila se agota, el arreglo se expande dinámica e indefinidamente
 * 
 * @param <T> El tipo de datos que será almacenado en la pila; genérica. 
 * 
 * @author peino
 */
public class PilaArreglo <T> implements PilaADT<T> {
    private T[] datos;   // Arreglo que almacena los elementos de la pila.
    private int tope;    // Índice del elemento en la parte superior de la pila.
    private final int MAX = 20;  // Capacidad inicial de la pila.

    /**
     * Crea una pila con la capacidad máxima por defecto.
     * Inicializa el arreglo de datos con un tamaño de {@code MAX}.
     * Inicializa el tope en -1 indicando que la pila está vacía.
     */
    public PilaArreglo() {
        datos = (T[]) new Object[MAX];
        tope = -1;  // PILA VACÍA
    }

    /**
     * Crea una pila con una capacidad arbitaria para propóstios de prueba.
     * 
     * @param max La capacidad máxima de la pila.
     */
    public PilaArreglo(int max) {
        datos = (T[]) new Object[max];
        tope = -1;
    }

    /**
     * Devuelve el índice del elemento que está en la parte superior de la pila.
     * 
     * @return El índice del elemento en la parte superior de la pila.
     */
    public int getTope() {
        return tope;
    }

    /**
     * Inserta un nuevo elemento en la parte superior de la pila.
     * Si la pila está llena, expande su capacidad antes de agregar el nuevo elemento.
     * 
     * @param dato El elemento a insertar en la pila.
     */
    @Override
    public void push(T dato) {
        if (tope + 1 == datos.length) {  // Verificar si la pila está llena
            expande();
        }
        tope++;
        datos[tope] = dato;
    }

    /**
     * Expande la capacidad de la pila duplicando el tamaño del arreglo.
     * Este método se invoca automáticamente si la pila está llena.
     */
    private void expande() {
        T[] masGrande = (T[]) new Object[datos.length * 2];
        for (int i = 0; i <= tope; i++) {
            masGrande[i] = datos[i];
        }
        datos = masGrande;
    }

    /**
     * Elimina y devuelve el elemento que está en la parte superior de la pila.
     * 
     * @return El elemento que estaba en la parte superior de la pila.
     * @throws RuntimeException Si la pila está vacía.
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        T eliminado = datos[tope];
        datos[tope] = null;
        tope--;
        return eliminado;
    }

    /**
     * Verifica si la pila está vacía, pregunta si el tope se encuentra en -1. 
     * 
     * @return {@code true} si la pila está vacía, {@code false} en caso contrario.
     */
    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    /**
     * Muestra el último elemento almacenado en la pila, pero sin retirarlo.
     * 
     * @return El elemento que está en la parte superior de la pila.
     * @throws RuntimeException Si la pila está vacía.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("La pila está vacía");
        }
        return datos[tope];
    }

    /**
     * Devuelve un String con todos los elementos de la pila, desde el fondo hasta el tope.
     * 
     * @return Una cadena con los elementos de la pila desde el fondo hasta la cima.
     */
    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i <= tope; i++) {
            sB.append(datos[i]).append("");  // Llama al toString de los elementos almacenados
        }
        return sB.toString();
    }
}
