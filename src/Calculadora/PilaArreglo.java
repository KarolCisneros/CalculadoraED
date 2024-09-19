package Calculadora;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author peino
 */
public class PilaArreglo <T> implements PilaADT<T>{
    private T[] datos;
    private int tope;
    private final int MAX=20;
    
    public PilaArreglo(){
        datos= (T[])new Object[MAX];
        tope=-1; //PILA VACIA
    }
    public PilaArreglo(int max){
        datos= (T[])new Object[max];
    }
    
    public  int getTope(){
        return tope;
    }

   
    public void push(T dato) {
        if (tope+1==datos.length)  //verificar si estaba llena 
            expande();
        tope++;
        datos[tope]=dato;
            
    }
    
    private void expande(){
        T[] masGrande= (T[]) new Object[datos.length*2];
        for (int i=0; i<=tope; i++){
            masGrande[i]=datos[i];
        }
        datos=masGrande;
    }

    
   
    public T pop() {
        if (isEmpty())
            throw new RuntimeException ("La pila está vacía");
        T eliminado =datos[tope];
        datos[tope]=null;
        tope--;
        return eliminado;
    }

    
    public boolean isEmpty() {
        return tope==-1;
    }

  
    public T peek() {
        if (isEmpty())
            throw new RuntimeException ("La pila está vacía");
        return datos[tope];
    }
    
    public String toString(){
        StringBuilder sB=new StringBuilder();
        for (int i=0; i<=tope; i++){
            sB.append(datos[i]).append(""); //ahi se llama ya al tostriung de las clases de lo que sea el dato i
            
        }
        return sB.toString();
    }
}
