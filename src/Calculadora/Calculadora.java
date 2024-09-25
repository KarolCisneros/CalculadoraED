/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculadora;

import java.util.Objects;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;

/**
 *
 * @author rojas
 */
public class Calculadora {
    private String aCalcular;

    public Calculadora(String aCalcular) {
        this.aCalcular = aCalcular;
    }
        
    public int precedencia(char a) {
        int res;

        res = switch (a) {
            case '-', '+' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };

        return res;
    }

    public String aPostFijo() {

        //String de salida en postfijo
        StringBuilder salida = new StringBuilder();
        //Pila de operadores
        PilaADT<Character> operadores = new PilaArreglo<>();
        //Se declara variable para mayor facilidad al evaular, en lugar de utilizar charAt(i) cada vez
        char evaluando;
        //Booleano para evaluar si es operador unario o binario
        boolean unario = true;

        for (int i = 0; i < aCalcular.length(); i++) {
            evaluando = aCalcular.charAt(i);

            //DEcimales o letras
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
                case '^':
                    while (!operadores.isEmpty() && precedencia(evaluando) <= precedencia(operadores.peek())) {
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
                        salida.append(evaluando);
                        //despues apaga la bandera porque no puede haber dos unarios juntos
                        unario = false;
                    } //si no lo es, hace lo normal, y prende la bandera en caso de que sea 1+ -1
                    //
                    else {
                        while (!operadores.isEmpty() && precedencia(evaluando) <= precedencia(operadores.peek())) {
                            salida.append(operadores.pop()).append(" ");
                        }
                        operadores.push(evaluando);
                    }
                    unario = true;
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

    public String getaCalcular() {
        return aCalcular;
    }

    public void setaCalcular(String aCalcular) {
        this.aCalcular = aCalcular;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Calculadora other = (Calculadora) obj;
        return Objects.equals(this.aCalcular, other.aCalcular);
    }

    public ArrayList<String> procesarPostfijo(String apostFijo) {
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

     
    
    public double Calcula (ArrayList <String> post){
        PilaADT<String> num = new PilaArreglo<>();
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

