package Calculadora;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author peino
 */
public class Sintaxis {
    
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
    
    public static boolean esSimboloSinMenos(String cadena, int pos){
        boolean res;
        char i;
        i=cadena.charAt(pos);
        if (i=='*'||i=='/'||i=='+'||i=='^')
            res=true;
        else
            res=false;
        return res;
    }
    
    
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
                if (punto!=false || i+1==cadena.length()&&esSimbolo(cadena, i-1) || i==0&&esSimbolo(cadena, i+1))
                    res=false;
                punto=true;
            }
            
            if (pos=='*'||pos=='/'||pos=='^'){
                if (i==0 || i==cadena.length()-1)
                    res=false;
                else
                    if (esSimbolo(cadena, i-1)||esSimboloSinMenos(cadena, i+1))
                        res=false;
                punto=false;
                
            }
            
            if (pos=='-'||pos=='+'){
                if (i==0 || i==cadena.length()-1)
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
                if (esSimbolo(cadena, i+1)||cadena.charAt(i+1)==')')
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
