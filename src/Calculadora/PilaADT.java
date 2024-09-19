package Calculadora;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author peino
 */
public interface PilaADT <T>{ //le ando dociendo que va a ser un generico
    public void push(T dato);
    public T pop();
    public boolean isEmpty();
    public T peek();
}
