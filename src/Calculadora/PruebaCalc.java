/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Calculadora;

/**
 *Breve prueba para la lógica de {@code aPostFijo}
 * @author rojas
 */
public class PruebaCalc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String a = "-2+4-(5+2)";
        Calculadora calc = new Calculadora(a);
        System.out.println(calc.aPostFijo());
    }
    
}
