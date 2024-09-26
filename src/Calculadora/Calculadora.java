/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculadora;

import java.util.Objects;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;

/**
 * La clase Calculadora proporciona métodos para convertir una expresión infija a postfija,
 * procesar la notación postfija y calcular el resultado de una expresión aritmética en notación postfija.
 * 
 * Incluye las siguientes funcionalidades: 
 <ul>
 *   <li>Evaluación de precedencia</li>
 *   <li>Manejo de operadores unarios y binarios</li>
 *   <li>Realización de operaciones básicas de suma, resta, multiplicación, división y exponenciación</li>
 * </ul>
 
 * 
 * @author GPO 1
 */
public class Calculadora {
    

    /**
     * Determina la precedencia de los operadores para conversión a PostFijo.
     * 
     * @param a char: El operador aritmético a evaluar ('+', '-', '*', '/', '^').
     * @return Un entero que representa la precedencia del operador. Retorna:
     *         <ul>
     *           <li>1 si el operador es '+' o '-'</li>
     *           <li>2 si el operador es '*' o '/'</li>
     *           <li>3 si el operador es '^'</li>
     *           <li>-1 si no es un operador conocido</li>
     *         </ul>
     */
        
    public static int precedencia(char a) {
        int res;

        res = switch (a) {
            case '-', '+' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };

        return res;
    }


    /**
     * Convierte una expresión infija a notación postfija para poder ser operada.
     * 
     * @param aCalcular : aCalcular La expresión aritmética en formato infijo.
     * @return Una cadena que representa la expresión en notación postfija.
     */
    public static String aPostFijo(String aCalcular) {

        //String de salida en postfijo
        StringBuilder salida = new StringBuilder();
        //Pila de operadores
        PilaADT<Character> operadores = new PilaArreglo();
        //Se declara variable para mayor facilidad al evaular, en lugar de utilizar charAt(i) cada vez
        char evaluando;
        //Booleano para evaluar si es operador unario o binario
        boolean unario = true;

        for (int i = 0; i < aCalcular.length(); i++) {
            evaluando = aCalcular.charAt(i);

            //Número, decimales o letras
            if(Character.isDigit(evaluando) || evaluando=='.' || Character.isLetter(evaluando)) {
            	salida.append(evaluando);
            	//Ver si el siguiente espacio sigue siendo el número
            	while (i+1 < aCalcular.length() && (Character.isDigit(aCalcular.charAt(i+1)) || aCalcular.charAt(i+1) == '.' )) {
            		i++;
            		salida.append(aCalcular.charAt(i));
            	}
            	//Agregar espacio
            	salida.append(" ");
            	unario = false;
            } else {
            
            switch (evaluando) {
                //Si abre, agrega
                case '(':
                    operadores.push(evaluando);
                    unario = true;
                    break;

                //Si encuentra operador, evalua precedencia; si es menor a la evaluada
                //entonces saca la de menor precedencia y mete la siguiente
                case '/':
                case '*':
              while (!operadores.isEmpty() && precedencia(evaluando) <= precedencia(operadores.peek())) {
                        salida.append(operadores.pop()).append(" ");
                    }
                    operadores.push(evaluando);
                    unario = true;
                    break;
                case '^':
                    while (!operadores.isEmpty() && precedencia(evaluando) < precedencia(operadores.peek())) {
                        salida.append(operadores.pop()).append(" ");
                    }
                    operadores.push(evaluando);
                    unario = true;
                    break;
                //aqui esta la posibilidad de encontrar unarios, por eso se separa
                case '+':
                case '-':
                    //aqui evalua si puede ser unario; si si lo es, lo agrega a la salida y no lo trata como operador
                    //Adicionalmente, se agrega espacio para facilidad de lectura
                    if (unario) {
                    	
                    	salida.append("0 ");
                    	operadores.push(evaluando);
                    	} else {
                    		//Operador binario
                    		while(!operadores.isEmpty() && precedencia(evaluando) <= precedencia(operadores.peek())) {
                    			salida.append(operadores.pop()).append(" ");
                    		}
                    		operadores.push(evaluando);
                       
                    }
                   //si no lo es, hace lo normal, y prende la bandera en caso de que sea 1+ -1
                    unario=true;
                    break;

//               
                case ')':
                    while (!operadores.isEmpty() && operadores.peek() != '(') {
                        salida.append(operadores.pop()).append(" ");
                    }
                    if(!operadores.isEmpty()) {
                    	operadores.pop(); //Elimina el paréntesis que abre
                    }
                    unario = false;
                    break;

                default:
                    break;
            	}
            }
        }

        while (!operadores.isEmpty()) {
            salida.append(operadores.pop()).append(" ");
        }

        return salida.toString();

    }


     /**
     * Convierte una cadena de notación postfija a una lista de sus componentes (números y operadores).
     * 
     * @param apostFijo Una cadena que contiene la expresión en notación postfija.
     * @return Una lista de componentes (números y operadores) que componen la expresión postfija (ArrayList)
     */
    public static ArrayList<String> procesarPostfijo(String apostFijo) {
        ArrayList<String> postfijo = new ArrayList<>();
        int i = 0;
        StringBuilder r = new StringBuilder();
        String f;

        while (i < apostFijo.length()) {
            while (i < apostFijo.length() && apostFijo.charAt(i) != ' ') {  
                r.append(apostFijo.charAt(i));
                i++;
            }

            f = r.toString();
            postfijo.add(f);
            i++;
            r = new StringBuilder();
        }

        return postfijo;
    }

     
/**
     * Calcula el valor de una expresión en notación postfija.
     * 
     * @param post Una lista que contiene la expresión aritmética en notación postfija.
     * @return El valor de la expresión.
     */
    
 public static double Calcula (ArrayList <String> post){
     PilaADT<String> num = new PilaArreglo <>();
     double resultado;
     int i = 0;
     double var1, var2;
     while (i < post.size()){
         switch (post.get(i)){
             case "+" -> {
                 var1 = parseDouble(num.pop());
                 var2 = parseDouble(num.pop());
                 resultado = var1 + var2;
                 num.push(Double.toString(resultado));
             }
             case "-" -> {
                 var1 = parseDouble(num.pop());
                 var2 = parseDouble(num.pop());
                 resultado= var2 - var1;
                 num.push(Double.toString(resultado));
             }
             case "*" -> {
                 var1 = parseDouble(num.pop());
                 var2 = parseDouble(num.pop());
                 resultado = var1 * var2;
                 num.push(Double.toString(resultado));
             }
             case "/" -> {
                 var1 = parseDouble(num.pop());
                 var2 = parseDouble(num.pop());
                 resultado = var2 / var1;
                 num.push(Double.toString(resultado));
             }
             case "^" -> {
                 var1 = parseDouble(num.pop());
                 var2 = parseDouble(num.pop());
                 resultado=Math.pow(var2,var1);
                 num.push(Double.toString(resultado));     
             }
             default -> num.push(post.get(i));    
         }
         i++;
     }
     return parseDouble(num.pop());
 }
 
}
