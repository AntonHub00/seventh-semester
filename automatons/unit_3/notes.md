# Análisis semántico (Unidad 3)

---

Ejemplo:

"El perro es verde"

- EL léxico es correcto
- La sintaxis es correcta
- La semántica es incorrecta (no existen perros verdes)

---

Entrada: árbol de análisis sintáctico del programa.

Utilizand el árbol y la info de la tabla de símbolos, añade un árbol de
*anotaciones semánticas*.

Dependiendo de lenguje (análisis semántico):

- Declaración de variables previo a su asignación o uso
- Asignación inicial de valores a variables
- Verificación de tipos
- Índices dentro del rango válido en arreglos

## Semántica dirigida por sintaxis

## Gramática de contexto

Se corre una rutina semántica a la vez que se corre en análisis sintáctico.

Propagación de atributos