# Unidad 1

## 1.-¿Qué es un SO?

Software principal o conjunto de programas de un sistema informático que gestiona
los recursos de hardware y provee servicios o los programas de aplicación.

## 4.-¿Cuál es la función del sistema operativo?

* Gestionar todos los recursos de hardware y software
* Gestión de procesos
* Gestión del sistema de archivos
* Entrada y salida de datos
* Gestión de memoria

Firmware = BIOS

## Características del SO

* Multitarea
* Núcleo o Kernel
* Interfaz
* Red o conexión
* Seguridad

1 participación

---

## Evolución histórica de SO

(En 1940)

* Uso de microinterruptores
* Lenguaje máquina

(En inicios de 1950)

* Aparece el primer SO (para la IBM 70 algo). Su prósito es que cuando una tarea
finalizara, empezara otra automáticamente.
* Monitor residente
* Almacenamiento temporal (se guadaban los procesos, para que el CPU se usara 100%)

(En 1960)

* Uso de transistor y sistema de lotes (hojas perforadas)
* Multiprogramación (interrupciones)
* Tiempo compartido de CPU (Multitarea)
* IBM 360. Primer computador comercial
* Primera mención de de "Firmware" por Ascher Opler

(En 1970)

* Los primeros sistemas operativos desarrollados
* Unix creado por AT&T y se vende a Novell
* Los SOs eran pesados, costosos y complejos
* Multics, BDOS (Basic Disk Operative System), CP/M (usó el primer Interl 8080)

(En 1980)

* Uso de circuitos con miles de transistores y el auge de los oredenadores
personales (PC)
* SunOS Unix Sun MicroSystems
* MS-DOS Microsoft
* MacOS Macintosh

(En 1990)

* GNU/Linux
* Solaris
* Windows NT, 95, 98

1 participación

## Tarea

ver "Her" (Done)

 * Tiene emociones
 * Inteligencia artificial
 * Velocidad de procesamiento
 * Personalizado
 * Multi-plataforma

## Clasificación de los OSs

### Administración de tareas

* Monotarea (MS-DOS, TSR "Terminate and Stay Resident")
* Multitarea:
    * Coordinada (Un proceso cedía el uso del procesador a otro proceso y por
    intervalos) (Se cuelga)
    * Preemtiva o apropiativa (El sitema operativo determina el tiempo de
    procesamiento por intervalos)(No se cuelga)
    * Real (Solo con 2 o más procesadores)(Cada proceso corre en un procesador)

### Administración  de usuariosj:w

* Mono usuario (oredenadores comunes)
* Multiusuario (Uso compartido y terminales bobas)(VMS, UNIX, Windows Server)
    Terminal boba: Solo una extensión de conexión para el procesamiento, pero
    no tiene CPU propio, depende del otro CPU.

### Manejo de recursos

* Algo debe ir aquí

### Organizacional o estructura

* Monolítico
* Microkernel
* Híbridos

***Kernel o núcleo***: Software que constituye la parte fundamental del OS. y se
define como la parte que se ejecuta en modo privilegiado.
Facilita a los dinstintos programas el acceso seguro al hardware y es el
encargado de gestionar recursos, a través de de servicios de llamadas al
sistema

#### Monolítico

* Macroprograma con miles de líneas de código.
* Macroprograma: Conjunto o colección de procedimientos enlazados entre sí con la
libertad de llamar a cualquier otro.
* En un macroprograma no existe encapsulamiento, por lo tanto, todos los recursos
están disponibles en todo el sistema y porque no se oculta la información.
* Estructura básica
* Todos los procedimientos se ejecutan en modo privilegiado
* MS-DOS UNIX

Característica principal del encapsulamiento: Ocultamiento de datos

Le procedimiento principal o programa inicial es el que manda a llamar a los
procedimientos o servicios. A la vez, lo procedimientos o servicios mandan a
llamar a los procedimientos de utilidad.

* Modo privilegiado (kernel mode)(Acceso a todas las instrucciones y sin validación;
es rápido)
* Modo usuario (user mode)(Acceso a intrucciones básicas; es más lento)

### Microkernel o micronúcleo

* Abstracción mínima y muy simple de servicio de llamada a sistema como la gestión
* de hilos (scheduling), almacenamiento de direcciones y comunicación entre procesos.

Tipos de procesos:

* Procesos de aplicación
* Comunicación de procesos

Tipos de procesos:

* Entrada/salida
* Gestión de memoria + (En modo privilegiado)
* Procesos de aplicación
* Scheduling + (En modo privilegiado)
* Gestión de archivos
* Procesos de servicio
* Comunicación de procesos + (En modo privilegiado)

El objetivo principal es la separación de los servicios básicos que se ejecutan
en modo privilegiado y el resto de servicios que se ejecuten en modo usuario.

### Híbrido

Es un micro núcleo que tiene algo de código "no escencial" en espacio e núcleo.

Igual que en micronúcleo pero ejecuta ciertos procesos en modo usuario porque
se ejecuta más rápido.

## Sistemas de capas

Capa 5: Interfaz de usuario
Capa 4: Programas de usuario
Capa 3: Gstión de dispositivos I/O
Capa 2: Gestión de procesos
Capa 1: Getión de memoria
Capa 0: Hardware

Cada capa solo pueda interactuar con sus capas adyacentes. Es por seguridad.

Todos los tipos de sistemas operativos tiene este sistema de capas.

## Sistema por módulos

* Parecido al de capas, pero cualquier módulo puede llamar a otro.

No está obligado a interactuar con capas.

## Sistemas cliente-servidor

* Separa funcionalmente el núcleo, los procesos de sistema y los proceoss de
aplicación en sistemas de servicio o cliente.
* Lo único que hace el núcleo es conttrolar la comunicación entre los clientes
y los servidores.
* Separación entre "mecanismos" u "política" para hacer que algunos de los
procesos críticos se ejecuten en modo privilegiado.

Unos procesos actúan como servidor de datos y otros procesos los consumen.

El kernel solo se encarga de la comunicación entre procesos.

Ejemplo: un programa inicia en modo usuario, llega a una parte crítica, esta se
ejecuta en modo privilegiado y después lo demás vuelve a ejecutarse en modo
usuario.

Ningún sistema es puro, siempre es una combinación de todos.
