# Unidad 4 - Aministración de entrada/salida (I/O)

## Grupos

- Intefaz de usuario
- Almacenamiento
- Comunicaciones (ajenos a equipos de cómputo: modems, routers, dispositivos móbiles)

## Clasificacion

- Dispositivos de bloques (Como dispositivos de almacenamiento: manejan info
 y la divide en bloques para asignar direcciones específicas delos datos que queremos
 obtener: pantalla)
- Dispositivos de caracteres (teclado, mouse: se refleja casi de inmediato)

## Controlador de dispositivo

Programa informático que permite al sistema operativo interactuar con un periférico.

## Categorías

- Dispositivos multimedia
- Dispositivos de almacenamiento
- Dispositivos de red
- Teclado
- Display
- Mouse
- Impresoras
- Dispositivos multimedia

## Puertos de I/O

El controlador contiene una serie de registros llamados "puertos". Las operaciones
de I/O se realizan a través de la carga y lectura de dichos registros.

- Registro de estado
- Registro de ordenes
- Buffer

## Adaptadores

Dispositivos en el que se adopta un hardware o componente de software, que convierte
datos transmitidosde un formato a otro.

- Serie
- Paralelo
- Inalámbrico
- USB

## Interrupción

Es una señal recibida por el procesador de una computadora, para indicarle que debe
"interrumpir" el curso de ejecución actual y pasar a ejecutar código específico
para tratar esta situación.

Quiénes interrumpen:

- El usuario
- Los servicios del sistema
- Los dispositivos de E/S

## Rutina de Servicio de Interupción (ISR)

Es un bloque de código asociado con una condición de interrupción específica.

Lo que se ejecuta cuando hace una interrupción.

## Módulo de E/S (Interfaz E/S)

Conecta con el procesador a través de  un conjunto de líneas de datos, dirección
y control (un bus)

- Registro de datos
- Registro de estado (indicadores)
- Registro de control (reacionado con el R de estado; le dice como quiere que
maneje los datos???; qué va a hacer con los datos)

## Funciones de control

- **Preámbulo**: Describir la introducción de un mensaje o encabezado (El controlador
tiene ciertas funciones, pero el CPU debe llenar primero ciertos datos (preámbulo))
- Convertir el flujo de bits en serie en un bloque de bytes
- Efectuar cualquier correción de errores necesaria
- Copiar el bloque en la memoria principal
- Provoca una interrupción para otorgar control al CPU

## Técnicas de E/S

- **E/S Programanda**: El CPU emite una orden de E/S a un módulo de E/S y el proceso
espera a que termine la operación antes de seguir
- **E/S dirigida por interrupciones:** El CPU emite una orden de E/S, continúa
con las siguientes instruccioes y el módulo de E/S lo interrumpe cuando termina
su trabajo. (Petición como hilo)
- **Acceso directo a memoria (DMA)**: Permite a dispositios de diferentes
velocidades comunicarse sin someter al CPU a una carga masiva de interrupciones
(Más modernos: mini computadora).

## Evolución

- El CPU controla directamente los dispositivos de /ES
- Se añade un módulo de E/S, el CPU utiliza E/S programada
- Se añade un módulo de E/S, pero empleándose interrupciones
- El módulo de E/S recibe el control directo de la memoria
- Se mejora el módulo de E/S hasta llegar a ser un procesador separado
- El módulo de E/S posee su propia memoria local (computador independiente)

## Buffering

El CPU y el dispositivo de E/S permanecen ocupados.
Cuando el CPU esté libre para el siguiente grupo de datos, el dispositivo habrá
terminao de leerlos.

La CPU podrá empezar el proceso de os últimos datos leídos, mientras el dispositivo
inicia la lectura de los datos siguientes (spooling).

## Problemas más frecuentes

- Problemas de  uso compartido (no puede ocupar el dispositivo porque otro
proceso lo está utilizado)
- Problemas con buffers
- Problemas al momento de manejar archivos (dead lock)

## Tarea

Investigar 3 dispositivos de I/O, cuál es su propósito, qué generación o tipo de
mecanismo utiliza y la interfaz que untilizan (USB, serie, SATA, etc).

### Mouse

La función principal del ratón es transmitir los movimientos de nuestra mano
sobre una superficie plana hacia el ordenador.

Interfaz: USB, serie y PS/2

### Web cam

En la Webcam radica un concepto sencillo; tenga en funcionamiento continuo una
cámara de video, obtenga un programa para captar un imagen en un archivo cada
determinados segundos o minutos, y cargue el archivo de la imagen en un servidor
Web para desplegarla en una página Web.

Interfaz: USB

### Plóter

Un plóter es un dispositivo que conectado a una computadora puede dibujar sobre
papel cualquier tipo de gráfico mediante el trazado de líneas gracias a las
plumillas retraibles de las que dispone

HPGL es un conjunto de comandos en el ROM de plóters de pluma para reducir el
trabajo requerido por los programadores de las aplicaciones que ejecutan salida
en ploteo. HPGL usa dos cartas de nemotécnica como instrucciones para dibujar
líneas, círculos, texto y símbolos simples.

Interfaz: USB

## Estructura de datos

Es una forma de organizar un conjunto de datos elementales con el objetivo de
facilitar su manipulación.

Las peticiones se procesan de forma estructurada en las siguientes capas:

- Manejadores de interrupción
- Manejadores de dispositivos (drivers)
- Software de E/S independiente de los dispositvos
- Interfaz del sistemas operativo