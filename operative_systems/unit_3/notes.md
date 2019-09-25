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