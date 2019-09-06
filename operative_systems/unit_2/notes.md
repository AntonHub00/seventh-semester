## Procesos

Proceso: Unidad de actividad que se caracteriza por la ejcución de una
secuencia de instrucciones (que contiene el micro), un estado actual, su
memoria de trabajo y un conjunto de recursos del sistema asociados.

Cada proceso tiee su contador de programa, registros y variables asilados de
otros procesos.

Un proceso se rige en pequeñas porciones conocidas como páginas (tabla de
paginación).

El SO se encarga del IPC (Inter-Process Comuncation).

### Crear un proceso

* Arranque del sistema
* Desde un proceso, por una lamda al sistema
* Petición deliverada del usuario
* Inicio trabajo por lotes

### Terminación de un proceso

* Salida normal
* Salida por error
* Error fatal
* Eliminado por otro proceso

### Estados

* En ejecución
* Listo/preparado (Está esperando un intervalo de tiempo para que pueda usar el
* procesador)
* Bloqueado


Listo/preparado: Está esperando un intervalo de tiempo para que pueda usar el
procesador

En ejecución: Está usando el procesador. En este estado el sistema operativo puede
decir interrumpir el proceso o el mismo proceso puede bloquearse a sí mismo.

Bloqueado:  El proceso se encuentra en este estdo si ha sido interrumpido por el
OS o por sí mismo por la espera de uno evento (I/O).El proceso se va a la cola
de lista de procesos.

Nota: Algunos autores muestran los estado "Nuevo" (proceso antes de "Listo") y
"Terminado" (No hay más ejecución ni espera del programa: "muere").

### Transiciones

* Nuevo a Listo


Nuevo a Listo: Cuando el proceso es admitido a la cola de procesos.

Listo a Ejecución: El scheduler despacha el proceso.

Ejecución a Listo: El OS interrumpe el proceso cuado termina su intervalo
de tiempo asinado.

Ejecución a Bloqueado: El proceso se bloquea cuando espera una E/S o algún evento.

Bloqueado a Listo: Termina operación de E/S o evento.

Ejecución a Terminado: Cuando el proceso termina.

### Gestor de excepciones

* Catastróficos (De detiene el OS/deja de funcionar)
* No recuperables (Atrapa excepción y la maneja (ejemplo: división entre cero))
* Recuperables (Se puede modificar el código y se recupera el proceso involucrado)

### Caraterísticas de los procesos

* Código, datos, memoria, dinámica (Heap) Pila (Stack)
* Procesos creados a partir de otros procesos (padre, hijo)
* El OS decide qué recursos comparte
* El OS decide qe pasa si el proceso Padre muere
* El OS genera un PCB (Process Control Block) de cada proceso nuevo (en la
etapa "Nuevo" a "Listo" se crea el PCB y en la de "Ejecución" a "Terminado"
muere el PCB)

.model (SMALL, TINY, LARGE)
.stack 10 (por defecto 1KB)
.data var1 DB, 10, 13, "Hola", "$" (variables)
Código va aquí
.code
Código va aquí
END

10: Retorno de carro
12: Salto de línea
$: Indicador de interrupción de terminación de impresión de datos

En los procesos comunes su código es inmutable.

#### PCB (Process Control Block)

ALgunos dependiendo del OS (del diseño) puede o no guardar algunas de las
siguentes cosas en su estructura:

* Identificador de proceso (PID)
* Estado del proceso
* Contador del programa (PC)
* Valores de registros del CPU
* Espacio de direcciones de memoria
* Prioridad
* Lista de recursos asignados
* Estadísticas del proceso
* Datos del propietario
* Permisos

#### Listas

* Lista de procesos del sistea (job queue)
* Cola de procesos listos (ready queue)
* Cola de espera de dispositivos (device queue)

>RQ -> CPU --->--------------->-->>--->--->_----------|
>|----<---<----(interrupción)-<--(ocurre interrupción)|
>|----<---<----(E/S resulve)-<--(device queue)-<-()|
> Missing info

#### Cambio de contexto (Cambio de un proceso por otro)

* Salvar el "estado" del proceso a su PCB (cambiar estado). Su "estado" en
este contexto se refiere al valor los registros, memoria, etc. Se guarda con el
tipo de estado (Bloqueado o Listo)
* Seleccionar otro proceso o parte de un algoritmo equitativo
* Cargar el "estado" del proceso a ejecutar desde su PCB
* Ejecutar el nuevo proceso (cambiar su estado a en ejecución) (cambiar su estado a en ejecución)

## Tarea

(Cualquier lenguaje de programación)

¿Cómo se crea un proceso?
¿Cómo se crea un hilo?

## Thread (hilo o proceso ligero): Unidad básica de uso e CPU

* Juego de registros, pila, PC y prioridad (asignado por el SO o Usuario)
* Comparten código, datos y recursos
* Un hilo puede pertenecer a una sola tarea (proceso pesado)

Proceso pesado (foto de tabla de código, datos y recursos).

### Implementación

* User Threads (hilos a nivel de usuario).
* Kernel Threads (Hilos a nivel de kernel). El scheduler ven todos los procesos
como independientes

IPC (Inter Process Comunication). Controla a los hilos a nivel de kernel.

### Ventaja

* Aprovechamiento de multiprocesador
* Comparten memoria y recursos
* Economía: Cambio de contexto más agíl
* Respuesta: Mejor tiempo de respuesta

### Desventaja

* Complejidad de programación
