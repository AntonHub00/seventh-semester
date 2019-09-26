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
- Segunda oportunidad (Relo)
- Páginas de reloj (Reloj mejorando)
- NRU (Not Recently Used)
- LRU (Less Recetly Used)
- Aging (Envejecimiento)

Tarea: Investigar el algoritmo de reemplazo "página de reloj" (reloj mejorado)