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
- Dispositivos audio
- Teclado
- Display
- Mouse
- Impresoras

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

La CPU podrá empezar el proceso de los últimos datos leídos, mientras el dispositivo
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

####

Previous class here

####

## Preámbulo

- Tipo deoperación: lectura o escritura
- Periférico involucrado en la operación
- Dirección de memoria desd la que se va a leer o escribir directamente el
controlador
- Número de bytes a transferir

## Tipo de operación

- Lectura
- Escritura
- Control
- Bifurcación

## Proceso a seguir

1. Programación de las operaciones de E/S
2. El controlador contesta aceptando la petición E/S
3. El controlador le ordena al dispositivo que lea una cierta cantidad de datos
a su memoria interna
4. El controlador los copia a la posición de memoria que tiene en sus registros
5. Los pasos 3 y 4 se repiten hasta que no quedan más datos por leer
6. Cuando el registro contador está en 0, el controlador interrumpe el CPU

## Tipos de transferencias

- Por ráfagas: el DMA toma el control del bus y no lo suelta hasta terminar la
transferencia
- Por robo de ciclo: el DMA toma el bus durante un ciclo enviando una palabra
cada vez
- Transparente: Se aprovechan los ciclos en que el procesador no usa el bus

##Tarea

La película está excelente a pesar de no terner tanto recursos para efectos
especiales. Presenta una realidad donde usan a una persona "medio muerta" como
medio para implantar una memoria de una persona que ya ha muerto siempre y cuando
se compatible biológica y cuánticamente (algo así). Los viajes al pasado solo
afectan la línea temporal donde se encuentra, por lo tanto solo afecta el futuro
de esa línea más no del presente, es decir, no se afecta el pasado de la línea
temporal desde donde fue enviado al pasado.

Menciones tecnológicas:

- Se usaba el celular para activar la bomba
- Se comunicaba con el soldado "muerto" a través de una interfaz en computadora
donde a las personas que se comunicaban les aparecían en forma de mensaje y ellos
transmitían datos a través de una camara y un micrófono.
- Se hablan sobre líneas de tiempo a partir de física cuántica
- En esa realidad, al alterar el pasado solo se puede alterar la línea del tiempo
de esa realidad, pero no el presente desde donde fue mandado al pasado; al
estilo de End Game

## Sistemas de archivos

Es el componente del sistema operativo encargado de administrar y facilitar el
uso de las memeorias periféricas, ya sean secundarias o terciarias. La mayoría
de los sistemas operativos manejan su propio sistema de archivos.

### Principales funciones

- Asignación de espacio a los archivos
- Administración de espacio libre
- Acceso a los datos resguardados

### Exposición

- SOs de Windows
- SOs de Mac
- SOs de Linux
- SOs dedicados a servidores
- SOs móviles

#### Contenido

- Concepto
- Origen
- Evolución
- Sistemas de archivos
- ¿Porqué este SO?
- Datos relevantes

#### Calificar

Personal:

- Formalidad
- Fluidez
- Seguridad
- Dominio del tema

Presentación:

- Calidad del contenido
- Poco de texto
- Aspectos visuales
- Creatividad

45 a 50 minutos

## Archivo virtual

Es un archivo de uso temporal que es utilizado por los procesos del sistema
durante  su ejecución. Se crean durante la ejecución del sistema, los utiliza
para almacenamiento, intercambio y organización y comunmente se eliminan al
terminar la ejecución del sistema.

## Archivo real

Es un objeto que contiene programas, datos o cualquier otro elemento. Se muestra
de manera real, en la información del espacio que ocupa en el disco, en otras
palabras, su tamaño en bytes.

## Sistema de Archivos Virtual

Es una capa de abstracción encima de un sistema de archivos más concreto. Su
propósito es permitir el acceso a diversos tipos de sistemas e archivos de manera
uniforme.

## Componentes

Lo conforman todas aquellas rutinas encargadas de administrar los aspectos
relacionados al sistema de archivos.

- Métodos de acceso
- Administración de archivos
- Administración de almacenamiento secundario
- Mecanismos de integridad

## Organización

- Origen conocido como "Raíz"
- "Directorio Raíz" apunta a los "Directorios de trabajo"
- "Directorio único" contiene entradas para los archivos del usuario
- Cada entrada apunta al lugar del disco dnde está almacenado el archivo

## Organización lógica y física

El sistema de archivos está relacionado especialmente con la administración del
espacio de almacenamiento secudnario, fundamentalmente el espacio en disco. La
representación lógica en la interfaz del S.O difiere a la ubicación física de los
archivos o directorios en memoria.

### Organización lógica

La mayoría de las computadoras organizan los archivos en jeraquías llamadas
carpetas, directorios o catálogos. Cada carpeta puede contener un número arbitrario
de archivos y otras carpetas. Construyéndose una estructura en árbol en la que
una "carpeta raíz" contiene cualquier número de niveles de otras carpetas y archivos.

- Pilas
- Archivos secuenciales
- Archivos secuenciales indexados
- Archivos indexados

### Organización física

Los datos son arreglados por su adyacencia física, son de tamañ físico o variable
y puede organizarse de varias formas para construir un archivos físico.

- Cinta magnética
- Disco magnético

## Clúster (sistema de archivos)

Es un conjunto de sectores contiguos que componen la unidad más pequeña de
alacenamiento de un disco. Los archivos se almacenan en uno o varios clústeres,
dependiendo de su tamaño de unidad de asignación. Sin embargo, si el tamaño de
archivo es menor que el tamaño de un clúster, este lo ocupa completo.

A partir de 2007 la Asociación Internacional de Unidades, Equipo y Materiales
de Disco (IDEMA) recomienda un tamaño de bloque de 4KB, desaconsejando 521 bytes
que se habían usualmente empleado.
Esto permite aprovechar mejor los discos modernos y también aumentar la velocidad
de acceso y reducir los errores.

## Manejo de espacio libre en memoria secundaria

- Vector de bits
- Lista ligada
- Por agrupación

## Manejo de espacio de archivos

- Contiguos
- Asignación Ligada o Encadenada
- Asignación indexada