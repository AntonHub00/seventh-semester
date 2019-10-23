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

- Partión dinámica: Se relaciona con la memoria continua.
- Partición fija: (espacios estrictos definidos se tiene esperar a desocupar espacio si
no hay espacio suficiente). Se relaciones con la memoria no continua

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

## Buffer

Espacio de memoria en el que se almacenan datos de manera temporal, para evitar
que el programa o recurso que los requiere se queda sin datos.

## Memoria caché

Buffer especial de memoria, que funciona de manera semejante a la memoria principal,
pero es de menor tamaño y de acceso más rápido.

- Cálculos anteriores
- Duplicado de memoria

## Translation Lookaside Buffer (TLB)

"Memoria caché especializada para guardar páginas de procesos".

El TLB guarda la páginas más solicitadas para que no se tengan que ir a buscar
hasta la RAM.

Memoria virtual -> TLB -> RAM

Memoria caché administrada por el MMU, que contiene partes de la tabla de paginación,
la cual relaciona las direcciones lógicas con las físicas.

Ejemplo:

Memoria real: 4GB.
Memoria virtual: 4GB.
Número de segmento: 16b.

2^{32} direcciones de Memoria de real.
2^{32} direcciones de Memoria de virtual.

32b - segmento(16b) = 16b de desplazamiento

0000:0000 Número de segmento: 2^{16Kb} segmentos (64KB).
FFFF:FFFF Número de desplazamiento: 2^{16Kb} espacio de segmentos (64KB).

Base: 32b, Límite 32b.


INSERART IMAGEN DEL EJERCICIO/EJEMPLO

EL offset es la cantidad.
El límite es la cantidad
La base es una dirección de memoria.

El offset debe ser menor al límite o se produce error.
El segmento al que se quiere acceder debe existir o se produce error.

## Paginación de memoria

Memoria real: 256 MB (256\*1024\*1024=268,435,456 bytes)
Memoria virtual: 4GB (4\*1024\*1024\*1024= 4,294,967,296 bytes)
Número de desplazamiento: 12 b (se usa para sacar páginas y/o marcos (restando))

2^{28} (bits) de memoria real (256MB = 2^{28})
2^{32} (bits) de memoria virtual (4GB = 2^{32})

Memoria real(28b-12b):

2^{16} (64Kb) marcos
2^{12} (4KB) dezplazamiento

Memoria virtual(32b-12b):

2^{20} (1MB) páginas
2^{12} (4KB) dezplazamiento

F = 4 bits

---

INSERTAR IMAGEN DE EJEMPLO

Proceso 1
Proceso 2

## Tarea

Memoria real: 16 MB (16\*1024\*1024=16,777,216 bytes)
Memoria virtual: 16 MB (16\*1024\*1024=16,777,216 bytes)
Número de segmento: 8 b (se usa para sacar páginas y/o marcos (restando))

2^{24} (bits) de memoria real (16MB = 2^{24})
2^{24} (bits) de memoria virtual (16MB = 2^{24})

24b - segmento(8b) = 16b de desplazamiento

0000:0000 Número de segmento: 2^{8b} segmentos (256b).
FFFF:FFFF Número de desplazamiento: 2^{16b} espacio de segmentos (64Kb).

Base: 24b 000000(FF), Límite 16b. 0000(FFFF)

segmento      base            Límite

000000 00  00000000 00000000 00000000
...
000000 FF  00000000 00000000 00000000

Examen:
Cocepto de admin de memoria
filosofía
Que es memoria real
tipos de memoria real
jerarquia de memoria
tipos de particiones de memoria
concepto de memoria virtul
paginacion y tabla de ginacion de memoria
algoritmos de reemplazo
concepto de segmentacion de memoria y offset
que es la MMU
concepto de buffer, memoria, cache y TLB