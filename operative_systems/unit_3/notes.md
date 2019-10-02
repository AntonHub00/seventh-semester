# Unidad 3 - Administración de Memoria

El proceso de asignación de memoria a los programas que la solicitan. Se refiere
a los distintos métodos y operaciones que se encargan de obtener la máxima utilidad
de memoria.

**Filosofía**: La memoria principal es considerada como un arreglo lineal de localidades
de almacenamiento de un byte de tamaño. Cada localidad tiene asignada una
dirección que la identifica.

**Política**: Determina que zonas libres se deberían utilizar; esoto con el fin de
lograr un buen eprovechamiento de la memoria usando un algoritmo de decisión
eficiente:

- FIFO
- Round Robin
- Short Job First
- Short Remaining Time First
- Highest Response Ratio Next

**Memoria Real o Principal**: Donde se almacenan temporalmente los datos y
programas que el CPU está procesando. El ancho del bus determina la capacidad
que posee el microprocesador para el direccionamiento de memoria.

**Tipos**:

- Memoria de Solo Lectura (ROM): Rutina de arranque, Rutina de BIOS.
- Memoria de Lectura-Escritura (RWM): RAM

**Jerarquí**:

- Registros del CPU
- Caché
- RAM (Primaria)
- HDD u otros (Secundaria)

## Asignación de memoria

- Continua (Uno tras otro)
- No continua (Mitad de RAM en partición grande y la otra mitad espacios pequeños)

## Particiones

- Partición fija: (espacios estrictos definidos se tiene esperar a desocupar espacio si
no hay espacio suficiente). Se relaciones con la memoria no continua
- Partión dinámica: Se relaciona con la memoria continua.

## Memoria Virtual

Técnica de la gestión de memoria que se encarga de que el SO disponga de mayor
cantidad de memoria que esté diponible físicamente.

Espacio más grande (disco duro)

## Paginación de memoria

Dividen los programas en pequeños partes o **páginas**. Del mismo modo, la memoria
es dividida en trozos de mismo tamaño que las páginas llamadas **marcos de páginas**.

## Tabla de paginación

Son usados ara realizar la traducción de direcciones de memoria virtual (lógica)
memoria real (física).

## Algoritmos de reemplazo de páginas

- FIFO
- Segunda oportunidad (Reloj)
- Páginas de reloj (Reloj mejorando)
- NRU (Not Recently Used)
- LRU (Less Recetly Used)
- Aging (Envejecimiento)

Tarea: Investigar el algoritmo de reemplazo "página de reloj" (reloj mejorado)

Existe una variante de este algoritmo que sobre la misma idea presenta una mejora
en la implementación. Es el algoritmo del reloj, que lo que hace es tener una lista
circular, de forma que al llegar al último elemento de la lista, pasa automáticamente
al primero. Los elementos no se mueven al final de la cola cuando son accedidos,
simplemente se pone su bit de referencia a 1. Esto nos evita tener que hacer
movimientos de punteros en el caso de implementarlo con una lista enlazada. De
hecho, se puede implementar con un array perfectamente, ahorrando así memoria.

## Segmentación de memoria

Cada dirección lógica se expresará mediante dos valores:

Número de **segmento** y **desplazamiento** dentro del segmento (offset). Ayuda
a incrementar la modularidad de un programa.

**Offset**: Indica el número de posiciones en memoria sumados a una dirección
base para conseguir una dirección absoluta específica.

00A0:0A00

- Izquierda es semgento
- Derecha es desplazamiento (offset)

Trabajamos solo con offsets sin necesidad de escribir toda la dirección de
memoria.

Ejemplo:

(Code segment) CS 0010
(Data segment) DS 0080
(Stack segment) SS 0090
(Extra segment) ES 0100

00A0:0A00

El sp (stack pointer) y el pc (program counter) son offset de los segments
anteriores; el sp sería el offset del SS y pc sería el offset del CS.

## Unidad de gestión de memoria (MMU)

Dispositivo de hardware responsable del manejo de los accesos a la memoria por
parte del CPU.

- Traducción de direcciones lógicas (o virtuales) o físcias (o reales) (accede a memoria o carga la página a la que apunta)
- Protección de memoria
- Manejo de caché
- Bank switching (ir de una memoria a otra: los puertos donde se conectan las memorias RAM)