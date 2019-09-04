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
