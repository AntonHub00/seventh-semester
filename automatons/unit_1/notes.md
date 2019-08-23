#Compiladores

Compilador: El código se traduce a código objeto y ese archivo es ejecutable.

Intérprete: Traduce y ejecuta.

## Etapas de un compilador

Primero es la etapa de análisis y después la de síntesis.
Son 6 fases agrupadas en 2 etapas.

### Etapa de análisis

* Análisis léxico (que pertenezcan al lenguaje: palabras reservadas, operadores, etc.) (TOKENS)
* Análisis sintáctico (Estructura, orden) (Gramática libre de contexto)
* Análisis semántico (Sentido o significado) (Llamar a funcion si params,
usar variable no declarada, cast o tipos equivocados)

### Etapa de síntesis

* Generador de código intermedio
* Optimización de código
* Generador de código objeto

El manejo de errores está en las 6 fases de compilación.

### Tabla de símbolos

Toda la info referentes a los identificadores del programa.
La tabla de símbolos está involucrada en las 6 fases de la compilación.


Ejemplo:

int a = 5 + 3;


TOKEN: Todas las palabras válidas dentro de un lenguaje de programación

Requerimientos para hacer análisis léxico y sintáctico:

* Expresiones regulares
* Gramáticas libres de contexto

## Análisis léxico

Detectar que no hayan caracteres no válidos.
Se usan autómatas y regex.

Los compiladores no se paran cuando encuentran un error, lo reportan y sigue
analizando en busca de más errores.

Hace un barrido secuencial del código fuente

Todos los tokens que sean de tipo identificador van a la tabla de símbolos.

### Tipos de errores

* Símbolo no permitido
* Identificador mal construido o que excede cierta longitud permitida
* Constante numérica al construida o que excede cierto número de caracteres
