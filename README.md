# CalculadoraED
Calculadora con operaciones de +,-,*,/,^ y con ().

1.0 Descripción



1.1 Objetivo. A través de una interfaz gráfica amigable, construímos una calculadora que permite hacer operaciones aritméticas básicas, tales como suma, resta, multiplicación, división y potencia, usando los dígitos del 0-9. 

La interfaz cuenta con botones para ingresar los números, signos que indican las operaciones (-, +, *, /, ^), un botón para borrar y reiniciar la expresión a operar, un botón para mostrar el resultado de la expresión ingresada y la posibilidad de poner paréntesis para intervenir en el orden jerárquico de las operaciones. 

1.2 Requisitos. Además de lo descrito en el objetivo, el principal requisito al elaborar el algoritmo que finalmente regresa el resultado matemático de la expresión ingresada, era que dicha expresión debía pasar por tres fases: la primera, detectar cualquier error en la sintaxis de la cadena ingresada y así asegurar su validez a la hora de ser operada; la segunda, pasar la cadena de texto a formato postfijo para ser leída con mayor facilidad en la siguiente etapa; y la tercera, leer el arreglo organizado en formato postfijo y aplicar las respectivas operaciones para finalmente mostrar el resultado de la expresión inicial gracias a la interfaz gráfica. Cabe mencionar que en la realización de las diferentes clases es esencial el uso de pilas como estructura de datos. 

Además, como requisito en el código entregado se deben presentar pruebas haciendo uso de JUnit de los métodos usados, así como documentar debidamente las diferentes clases y métodos. 

Finalmente, el proyecto debe ser realizado de forma colaborativa, formando equipos de máximo 5 integrantes. El grupo debe asegurarse de que el trabajo sea equitativo entre los integrantes. 

1.3 Restricciones del proyecto. Como algunas restricciones, el proyecto debe hacerse por medio de Apache Netbeans y con la ayuda de un repositorio de GitHub que permita visualizar los cambios en el código y trabajar de forma colaborativa en el proyecto.




2.0 Solución: UML 
2.1 Clase Sintaxis
Sintaxis


+balanceParentesis (String): boolean
+esSimbolo (String, int): boolean 
+esSimboloSinMenos (String, int): boolean
+sintaxis (String): boolean


2.2 Clase Calculadora
Calculadora


+ aPostFijo( String): String
+ procesarPostfijo( String): ArrayList<String> 
+ Calcula(: ArrayList<String>): double
+ precedencia( char): int



3.0 Algoritmos principales (Pseudocódigo) : 
3.1 Clase Sintaxis

Método sintaxis



Función sintaxis(cadena: String): booleano
    Inicializar res en verdadero
    Inicializar punto en falso
    
    Si el balanceo de paréntesis de la cadena es incorrecto:
        res = falso

    Si la cadena está vacía:
        res = falso

    Inicializar i = 0
    
    Mientras res sea verdadero y i sea menor que la longitud de la cadena:
        pos = carácter en la posición i de la cadena
        
        Si pos es un punto ('.'):
            Si ya hay un punto anterior en el número o es una posición inválida (inicio, fin o entre símbolos):
                res = falso
            Si el punto está entre paréntesis vacíos:
                res = falso
            Marcar punto como verdadero (indica que ya hay un punto en este número)

        Si pos es un operador ('*', '/', '^'):
            Si está al principio o al final de la cadena:
                res = falso
            Si antes o después hay otro operador incompatible:
                res = falso
            Reiniciar punto a falso

        Si pos es un signo ('-' o '+'):
            Si está al final de la cadena:
                res = falso
            Si después hay un operador incompatible:
                res = falso
            Reiniciar punto a falso

        Si pos es un paréntesis de apertura ('('):
            Si no está al principio y antes de él no hay un operador o un paréntesis de apertura:
                res = falso
            Si después hay un operador incompatible o un paréntesis de cierre:
                res = falso

        Si pos es un paréntesis de cierre (')'):
            Si no está al final y después de él no hay un operador o un paréntesis de cierre:
                res = falso
            Si antes de él hay un operador:
                res = falso

        Incrementar i

    Retornar res

Fin Función


3.2 Clase Calculadora: 
Método aPostFijo




Función aPostFijo(cadena aCalcular): cadena
    Crear una cadena de salida vacía (salida)
    Crear una pila de caracteres vacía (operadores)
    Definir variable evaluando como carácter
    Definir booleano unario como verdadero
    
    Para cada carácter i en aCalcular:
        evaluando = carácter en la posición i de aCalcular

        Si evaluando es un número, letra o punto decimal:
            Agregar evaluando a la salida
            Mientras el siguiente carácter sea también un número o punto:
                Agregar el siguiente carácter a la salida
            Agregar un espacio a la salida
            Marcar unario como falso

        Si evaluando es un paréntesis abierto:
            Apilar evaluando en operadores
            Marcar unario como verdadero

        Si evaluando es un operador:
            Mientras la pila no esté vacía y el operador en la cima de la pila tenga mayor o igual precedencia:
                Desapilar el operador y agregarlo a la salida
            Apilar el operador actual
            Marcar unario como verdadero

        Si evaluando es un operador unario (‘+’ o ‘-’):
            Si es unario, agregar "0 " a la salida y apilar el operador
            Si no es unario, realizar las operaciones normales de precedencia
            Marcar unario como verdadero

        Si evaluando es un paréntesis cerrado:
            Mientras la cima de la pila no sea un paréntesis abierto:
                Desapilar operadores y agregarlos a la salida
            Desapilar y descartar el paréntesis abierto
            Marcar unario como falso

    Mientras la pila no esté vacía:
        Desapilar los operadores restantes y agregarlos a la salida

    Retornar la salida en formato cadena

Fin Función



Método aPostFijo



Función Calcula(lista post): número
    Crear una pila vacía de números (num)
    Definir variables var1 y var2 como números
    Definir resultado como número
    
    Para cada elemento en la lista post:
        Si el elemento es un operador:
            Desapilar dos números de la pila (var1 y var2)
            Según el operador:
                Si es "+", resultado = var2 + var1
                Si es "-", resultado = var2 - var1
                Si es "*", resultado = var2 * var1
                Si es "/", resultado = var2 / var1
                Si es "^", resultado = var2 ^ var1
            Apilar el resultado en la pila

        Si el elemento es un número:
            Apilar el número en la pila

    Retornar el único número restante en la pila (resultado final)

Fin Función















4.0 Limitaciones y restricciones

Dentro de este apartado del reporte caben destacar las restricciones que se hicieron a la hora de detectar errores de sintaxis. Primeramente, se restringieron casos como:
El mal balance de paréntesis en una expresión: “(8+9)-(9”.
No poner dos o más signos (suma, resta, multiplicación, división o potencia) consecutivos excepto los casos donde el menos o el más van después de la suma, resta, multiplicación, división o potencia, y el caso de + y - puestos consecutivamente, es decir, se aceptan casos como: “5*-3” , “5+-3”, “6+-+6”, etc. (en el último caso, nuestro código resuelve que es 6-6). Estos se tratan como “unarios”. 
No poner multiplicaciones sin el símbolo de multiplicación (*), es decir, no se acepta “6(7+4)”, debe ser “6*(7+4)”.
Otras expresiones simplemente sin sentido matemático como puntos decimales mal usados, signos que están puestos al final de una expresión sin sentido matemático, etc. tales como: “3.5.6+7”, “5+6+”, “5+*3”.
De igual forma, en nuestro código es necesario que, al querer resolver una expresión como “5/-6/8”, al aparecer un signo “-”


5.0 Mejoras y conclusiones

Dentro de las mejoras que debemos implementar en el proyecto se encuentra que el usuario pueda realizar una división de la forma a/b/c/…/d (donde b,c,..,d pueden ser un número negativo) sin la necesidad del uso de paréntesis en algún término negativo.

Sin duda el desarrollo de esta calculadora ha sido un ejercicio enriquecedor de trabajo en equipo, donde cada miembro aportó sus conocimientos y habilidades para lograr un producto funcional y eficiente. El uso de pilas como estructura de datos ha sido fundamental para la implementación de operaciones como la evaluación de expresiones aritméticas y el manejo de paréntesis. Esta estructura nos ha permitido modelar de forma intuitiva el orden en el que se deben realizar las operaciones, siguiendo el principio LIFO (Último en entrar, primero en salir).

Por otro lado, la creación de una interfaz amigable ha sido clave para que la calculadora sea accesible a cualquier usuario. Al diseñar una interfaz intuitiva y visualmente atractiva, hemos facilitado la interacción con la calculadora y hemos mejorado la experiencia del usuario.

