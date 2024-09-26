/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Calculadora;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 * En esta clase se hacen pruebas sobre los métodos de la clase sintaxis
 * @author Karol Cisneros, Equipo1
 */
public class SintaxisTest {
    
    public SintaxisTest() {
    }
    /**
     * Test of balanceParentesis method, of class Sintaxis.
     */
    @Test
    public void testBalanceParentesis() {
        String cadena = "(((()))";
        assertFalse(Sintaxis.balanceParentesis(cadena)); // 
        
        String cadena2="34+(9+(8*(7-3*(8+4))))";
        assertTrue(Sintaxis.balanceParentesis(cadena2));
        
        String cadena3="3+4)-(9-6";
        assertFalse(Sintaxis.balanceParentesis(cadena3));
    }

    /**
     * Test of esSimbolo method, of class Sintaxis.
     */
    @Test
    public void testEsSimbolo() {
        String cadena = "3+3.5.4+78";
        assertTrue(Sintaxis.esSimbolo(cadena, 1));
    }

    /**
     * Test of esSimboloSinMenosMas method, of class Sintaxis.
     */
    @Test
    public void testEsSimboloSinMenosMas() {
        String cadena = "3+3.5.4+78";
        assertFalse(Sintaxis.esSimboloSinMenosMas(cadena, 1));
    }

    /**
     * Test of sintaxis method, of class Sintaxis.
     */
    @Test
    public void testSintaxis() {
        String cadena1=".5-5.9*(-3+5.)+78*(6+9)";
        assertTrue(Sintaxis.sintaxis(cadena1));
        String cadena2="+2+6*-(7-8)";
        assertTrue(Sintaxis.sintaxis(cadena2));
        String cadena = "3+3.5.4+78";
        assertFalse(Sintaxis.sintaxis(cadena));
        String cadena4="4+(.9)+5";
        assertTrue(Sintaxis.sintaxis(cadena4));
        String cadena5;
        cadena5="5/+5";
        assertTrue(Sintaxis.sintaxis(cadena5));
        String cadena6;
        cadena6="(7+6)-(+5-78)*-(90/3)^6*(-9+9)+-9";
        assertTrue(Sintaxis.sintaxis(cadena6));
        String cadena3="4+.+5";
        assertFalse(Sintaxis.sintaxis(cadena3));
    }
    
}
