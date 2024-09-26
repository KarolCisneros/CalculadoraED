/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Calculadora;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tanus
 */
public class CalculadoraTest {
    
    public CalculadoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of precedencia method, of class Calculadora.
     */
    @Test
    public void testPrecedencia() {
        System.out.println("Pruebas del método precedencia");

        // Prueba para '+'
        char a = '+';
        int expResult = 1; // La precedencia esperada para '+' es 1
        int result = Calculadora.precedencia(a);
        assertEquals("Error en precedencia de +", expResult, result);

        // Prueba para '*'
        a = '*';
        expResult = 2; // La precedencia esperada para '*' es 2
        result = Calculadora.precedencia(a);
        assertEquals("Error en precedencia de *", expResult, result);

        // Prueba para '^'
        a = '^';
        expResult = 3; // La precedencia esperada para '^' es 3
        result = Calculadora.precedencia(a);
        assertEquals("Error en precedencia de ^", expResult, result);

        // Prueba para un carácter no reconocido
        a = ' ';
        expResult = -1; // Se espera que cualquier otro carácter devuelva -1
        result = Calculadora.precedencia(a);
        assertEquals("Error en precedencia de un carácter no reconocido", expResult, result);
    }

    /**
     * Test of aPostFijo method, of class Calculadora.
     */
    @Test
    public void testAPostFijoOperadoresBinarios() {
        // Prueba con suma
        assertEquals("3 5 + ", Calculadora.aPostFijo("3 + 5"));
        
        // Prueba con resta
        assertEquals("10 2 - ", Calculadora.aPostFijo("10 - 2"));

        // Prueba con multiplicación y precedencia
        assertEquals("2 3 5 * + ", Calculadora.aPostFijo("2 + 3 * 5"));

        // Prueba con suma, resta, y multiplicación
        assertEquals("3 5 * 4 + 2 - ", Calculadora.aPostFijo("3 * 5 + 4 - 2"));
        
        // Prueba con división
        assertEquals("8 4 / ", Calculadora.aPostFijo("8 / 4"));
    }

    /**
     * Prueba con operadores unarios (números negativos).
     */
    @Test
    public void testAPostFijoOperadoresUnarios() {
        // Prueba con un número negativo
        assertEquals("0 5 - 3 + ", Calculadora.aPostFijo("-5 + 3"));

        // Prueba con expresión más compleja y número negativo
        assertEquals("0 4 - 2 3 * + ", Calculadora.aPostFijo("-4 + 2 * 3"));

        // Prueba con un número negativo y paréntesis
        assertEquals("0 4 2 + - ", Calculadora.aPostFijo("- (4 + 2)"));

        // Prueba con paréntesis y número negativo dentro
        assertEquals("3 0 2 - + ", Calculadora.aPostFijo("3 + (-2)"));
    }

    /**
     * Prueba con paréntesis y precedencia.
     */
    @Test
    public void testAPostFijoParentesis() {
        // Prueba con paréntesis simples
        assertEquals("3 2 5 + * ", Calculadora.aPostFijo("3 * (2 + 5)"));

        // Prueba con paréntesis anidados
        assertEquals("4 2 3 + * 5 - ", Calculadora.aPostFijo("4 * (2 + 3) - 5"));

        // Prueba con varios paréntesis
        assertEquals("1 2 + 3 4 * + ", Calculadora.aPostFijo("(1 + 2) + (3 * 4)"));

        // Prueba con expresiones complejas
        assertEquals("3 4 2 * 1 5 - 2 3 ^ ^ / + ", Calculadora.aPostFijo("3 + 4 * 2 / (1 - 5) ^ 2 ^ 3"));
    }

    

    /**
     * Prueba con números decimales y variables.
     */
    @Test
    public void testAPostFijoDecimalesYLetras() {
        // Prueba con números decimales
        assertEquals("3.14 2.5 + ", Calculadora.aPostFijo("3.14 + 2.5"));

        // Prueba con una expresión que incluye variables
        assertEquals("A B C * + ", Calculadora.aPostFijo("A + B * C"));

        // Prueba con variables y decimales
        assertEquals("X 3.5 * Y + ", Calculadora.aPostFijo("X * 3.5 + Y"));

        // Prueba con decimales y paréntesis
        assertEquals("1.1 2.2 + 3.3 * ", Calculadora.aPostFijo("(1.1 + 2.2) * 3.3"));
    }

    /**
     *Prueba del método ProcesarPostfijo de la clase Calculadora
     */
    @Test
    public void testProcesarPostfijo() {
        // Prueba 1: Verifica la conversión de una expresión simple
        String expresion = "3 4 + 2 *";
        ArrayList<String> resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add("3");
        resultadoEsperado.add("4");
        resultadoEsperado.add("+");
        resultadoEsperado.add("2");
        resultadoEsperado.add("*");
        
        ArrayList<String> resultado = Calculadora.procesarPostfijo(expresion);
        
        assertEquals(resultadoEsperado, resultado);
    }
    
  
    
    @Test
    public void testProcesarPostfijoVacio() {
        // Prueba 2: Verifica el manejo de una cadena vacía
        String expresion = "";
        ArrayList<String> resultadoEsperado = new ArrayList<>();
        
        ArrayList<String> resultado = Calculadora.procesarPostfijo(expresion);
        
        assertEquals(resultadoEsperado, resultado);
    }

    /**
     * Prueba del método calcula de la clase calculadora
     */
   @Test
    public void testCalculaSuma() {
        // Prueba 1: Verifica la suma en notación postfija
        ArrayList<String> expresion = new ArrayList<>();
        expresion.add("3");
        expresion.add("4");
        expresion.add("+");
        
        double resultadoEsperado = 7.0;
        double resultado = Calculadora.Calcula(expresion);
        
        assertEquals(resultadoEsperado, resultado, 0);
    }

    @Test
    public void testCalculaMultiplicacion() {
        // Prueba 2: Verifica la multiplicación en notación postfija
        ArrayList<String> expresion = new ArrayList<>();
        expresion.add("3");
        expresion.add("4");
        expresion.add("2");
        expresion.add("*");
        expresion.add("+");
        
        double resultadoEsperado = 11.0;
        double resultado = Calculadora.Calcula(expresion);
        
        assertEquals(resultadoEsperado, resultado, 0);
    }
    
    @Test
    public void testCalculaDivision() {
        // Prueba 3: Verifica la división en notación postfija
        ArrayList<String> expresion = new ArrayList<>();
        expresion.add("10");
        expresion.add("5");
        expresion.add("/");
        
        double resultadoEsperado = 2.0;
        double resultado = Calculadora.Calcula(expresion);
        
        assertEquals(resultadoEsperado, resultado, 0);
    }
    
    @Test
    public void testCalculaPotencia() {
        // Prueba 4: Verifica la operación de potencia en notación postfija
        ArrayList<String> expresion = new ArrayList<>();
        expresion.add("2");
        expresion.add("3");
        expresion.add("^");
        
        double resultadoEsperado = 8.0;
        double resultado = Calculadora.Calcula(expresion);
        
        assertEquals(resultadoEsperado, resultado, 0);
    }
    
}
