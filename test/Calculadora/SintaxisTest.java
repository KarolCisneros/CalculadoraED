/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Calculadora;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rojas
 */
public class SintaxisTest {
    
    public SintaxisTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of balanceParentesis method, of class Sintaxis.
     */
    @Test
    public void testBalanceParentesis() {
        System.out.println("balanceParentesis");
        String cadena = "";
        boolean expResult = false;
        boolean result = Sintaxis.balanceParentesis(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esSimbolo method, of class Sintaxis.
     */
    @Test
    public void testEsSimbolo() {
        System.out.println("esSimbolo");
        String cadena = "";
        int pos = 0;
        boolean expResult = false;
        boolean result = Sintaxis.esSimbolo(cadena, pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esSimboloSinMenosMas method, of class Sintaxis.
     */
    @Test
    public void testEsSimboloSinMenosMas() {
        System.out.println("esSimboloSinMenosMas");
        String cadena = "";
        int pos = 0;
        boolean expResult = false;
        boolean result = Sintaxis.esSimboloSinMenosMas(cadena, pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sintaxis method, of class Sintaxis.
     */
    @Test
    public void testSintaxis() {
        System.out.println("sintaxis");
        String cadena = "";
        boolean expResult = false;
        boolean result = Sintaxis.sintaxis(cadena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
