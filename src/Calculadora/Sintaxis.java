package Calculadora;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Esta clase permite detectar errores de sintaxis a la hora de ingresar una posible operación
 * @author Karol Cisneros
 * 
 */
public class Sintaxis {
    /**
     * Este metodo permite detectar si los paréntesis en una expresión están correctamente balanceados
     * @param cadena El texto del que se quiere comprobar que sus paréntesis estén balanceados
     * @return Regresa un boolean mostrando si es correcto o no el balance de paréntesis
     */
    
    public static boolean balanceParentesis(String cadena){
        PilaArreglo<Character>  pila;
        pila=new PilaArreglo();
        boolean res;
        res=true;
        int i=0;
        while(i<cadena.length()){
            if (cadena.charAt(i)=='(')
                pila.push('(');
            else
                if (cadena.charAt(i)==')'){
                    if (pila.isEmpty())
                        res=false;
                    else
                        pila.pop();
                }
            i++;
        }
        
        if (pila.isEmpty()&&res==true)
            res=true;
        else
            if(!pila.isEmpty())
                res=false;
        return res;
            
    }

    /**
     * Este método detecta si el char en una determinada posición de la cadena es un símbolo
     * @param cadena La cadena de texto que se quiere analizar
     * @param pos La posición de un elemento Character de la cadena
     * @return Regresa un boolean, detectando si el char en la posición pos es un simbolo (+, -, *,/,^ )
     */
    public static boolean esSimbolo(String cadena, int pos){
        boolean res;
        char i;
        i=cadena.charAt(pos);
        if (i=='*'||i=='/'||i=='+'||i=='-'||i=='^')
            res=true;
        else
            res=false;
        return res;
    }
    
    /**
     * Este método detecta si el char en una determinada posición de la cadena es un símbolo (excepto - y +)
     * @param cadena La cadena de texto que se quiere analizar
     * @param pos La posición de un elemento Character de la cadena
     * @return Regresa un boolean, detectando si el char en la posición pos es un simbolo excepto - (+, *,/,^ )
     */
    public static boolean esSimboloSinMenosMas(String cadena, int pos){
        boolean res;
        char i;
        i=cadena.charAt(pos);
        if (i=='*'||i=='/'||i=='^')
            res=true;
        else
            res=false;
        return res;
    }

    /**
     * Este método estático, con ayuda de los otros, detecta finalmente si la cadena contiene o no un error de sintaxis
     * @param cadena La cadena de texto que se quiere analizar
     * @return Regresa un boolean, detectando si el la cadena contiene algún error de sintaxis
     */
    
    public static boolean sintaxis(String cadena){
        boolean res, punto;
        res=true;
        punto=false;
        if (balanceParentesis(cadena)==false)
            res=false;
        if (cadena=="")
            res=false;
        int i=0;
        char pos;
        while (res!= false && i<cadena.length()){
            pos=cadena.charAt(i);
           
            if (pos=='.'){
                if (punto!=false || i+1==cadena.length()&&esSimbolo(cadena, i-1) || i==0&&esSimbolo(cadena, i+1)|| esSimbolo(cadena, i+1)&&esSimbolo(cadena, i-1))
                    res=false;
                if (i!=0 && i+1!=cadena.length() && cadena.charAt(i-1)=='('&&cadena.charAt(i+1)==')')
                    res=false;
               
                punto=true;
            }
            
            if (pos=='*'||pos=='/'||pos=='^'){
                if (i==0 || i==cadena.length()-1)
                    res=false;
                else
                    if (esSimbolo(cadena, i-1)||esSimboloSinMenosMas(cadena, i+1))
                        res=false;
                punto=false;
                
            }
            
            if (pos=='-'||pos=='+'){
                if (i==cadena.length()-1)
                    res=false;
                else
                    if (esSimbolo(cadena, i+1))
                        res=false;
                punto=false;
            }
            if (pos=='('){
                if (i!=0)
                    if (!esSimbolo(cadena, i-1)&&cadena.charAt(i-1)!='(')
                        res=false;    
                if (esSimboloSinMenosMas(cadena, i+1)||cadena.charAt(i+1)==')')
                    res=false;
            }
            
            if (pos==')'){
                if (i!=cadena.length()-1)
                    if (!esSimbolo(cadena, i+1)&&cadena.charAt(i+1)!=')')
                        res=false;
                if (esSimbolo(cadena, i-1))
                    res=false;
            }
                
       
            i++;

        }
        return res;
        
    }
}
