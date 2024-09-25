package Calculadora;

/**
 * La interfaz {@code PilaADT} define las operaciones básicas de una pila genérica.
 * Una pila sigue el principio de LIFO (Último en entrar, primero en salir),
 * lo que significa que el último elemento añadido es el primero en ser retirado.
 *
 * @param <T> El tipo de datos que será almacenado en la pila.
 * 
 * @author peino
 */
public interface PilaADT<T> {
    
    /**
     * Inserta un elemento en la parte superior de la pila.
     * 
     * @param dato El elemento que se desea insertar en la pila.
     */
    public void push(T dato);

    /**
     * Retira y devuelve el elemento que está en la parte superior de la pila.
     * 
     * @return El elemento que estaba en la parte superior de la pila.
     * @throws RuntimeException si la pila está vacía.
     */
    public T pop();

    /**
     * Verifica si la pila está vacía.
     * 
     * @return {@code true} si la pila no contiene elementos, {@code false} en caso contrario.
     */
    public boolean isEmpty();

    /**
     * Devuelve el elemento en la parte superior de la pila sin retirarlo.
     * 
     * @return El elemento que está en la parte superior de la pila.
     * @throws RuntimeException si la pila está vacía.
     */
    public T peek();
}
