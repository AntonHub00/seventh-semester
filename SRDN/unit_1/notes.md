# Unidad 1

## Característicasde una red (Son 7)

* Topología
* Velocidad
* Costo
* Seguridad
* Disponibilidad
* Escalabilidad
* Confiabilidad

## ¿Porqué elegir el routing?

EL router es responsable del routing del tráfico entre redes.

Deciden el mejor camino para el envío de la información.

## Los router son computadores

* Tiene CPU
* Tiene SO
* Tiene memoria y almacenamiento (RAM, ROM, FLASH, etc)

Algunas partes importantes de los routers:

* Puertos auxiliares
* Interfaces LAN
* Puerto RJ-45 para consola
* Enlaces LAN

En la NRAM se encuentra el archivo de configuración.
La FLASH contiene el IOS y otros archivos. (CUIDADO)

## Los routers eligen las mejores rutas

El router estático:  Que un router se aprenda las rutas que llevana las redes.

EL router dinámica: A través de un protocolo elege la mejor ruta automáticamente.

## Gateway predeterminados

Dirección IP: Identificar único de un dispositivo en una red.

Máscara de subred: Identifica a la subred de la red del host.

Gateway: Identifica al router que el destino de un paquete no está dentro de
a red.

El Gateway siempre será el mismo dentro de una red.


## Documentar la asignación de direcciones de red

Aspectos que debe incluir la documentación:

* Nombre de los dispositivos
* Interfaces (parte virtual del puerto de un dispositivo)
* Direcciones IP y máscaras de subred
* Gateways predeterminados

## Habilitar IP en un host

Se requiere:

* IP
* Máscara de red
* Gateway

O

* DHCP

## Identificadores led de los dispositivos

En GE (Gigabit Ethernet):

* 1 parpadeo + pause = 10 Mb/s
* 2 parpadeo + pause = 100 Mb/s
* 3 parpadeo + pause = 1000 Mb/s

## Acceso a consola

Puertos en la computadora:

* Puerto serial
* Puerto USB tipo A

## Habilitar IP en un switch

Una interfaz es un puerto ("en donde se pueda conectar algo")

## Verificar una interfaz de loopback IPv4

Se pueden simular más redes a través del loopback (interfaces loopback)

---

## Deciciones de routing?

## Funcioón de switching

El router solo reconocen las capas 1, 2 y 3

## Enviar un paquete

Las direcciones MAC las utiliza el protocolo ARP

Todo se manera con tablas de enrutamiento (routing tables)

## La mejor ruta

* Métrica: Valor para medir la distancia hasta una red determinada
La mejor ruta a una red es la que tiene la métrica más baja.

* Protocolo mejorado de routing de gateway interior (EIGRP): Ancho de banda, demora,
carga, confiabilidad.

## Equilibrio de carga

## Distancia administrativa

## Práctica

1841 Es recomendado (router básico)

Faz ethernet es LAN
rs232 y al puerto de la consola del router

Los b/s depende del router o switch a configurar.

Rutas directamentes conectadas

Show ip route muestra las tabla de direcciones

Se puede tener más puertos a través de loopback o tener más puertos físicamente.

Down en protocol significa cable físicamente desconectado

Down en status significa que no está activada la configuración

copy running-config (la config actual) en startup config

startup-config no pasa nada al borrarlo (pero es mejor no hacerlo)

Poner módulo hweek-2t para poder conectar 2 routers porque se ocupan puertos
seriales.

Rayitos rojos son los seriales

DCE (Data Comunication Equipment) y DTE (Data Terminal Equipment)

¿Cómo saber quién es DTE y quién DCE?

en show running-config en las seriales dice clock rate. Las 2 posibles seriales
pueden ser DTE.

Solo el DCE tiene clock rate.

El DTE no tiene clock rate.

## Configuración de básica de un router

Nota: exit (sale del modo actual: root, configuración global, configuración de línea,
configuración de interfaz, etc.)

enable (Entre en modo root)

configure terminal (Entra a modo de configuración global)

hostname R1 (asgina el nombre "R1" al router que se está configurando)

enable secret class (Se configura "class" como la contraseña secreta)

line console 0 (Entra al modo de configuración de línea, en este caso, para la
configuración de la línea de consola)

password cisco (Configura la cisco como contraseña para la línea de consola)

login (Pide a los usuarios que inicien sesión)

exit (para salir de modo de configuración de línea de consola)

line vty 0 4 (entra en moto de línea de teletype para configurar las líneas de la
0 a la 4)

password cisco (Configura la cisco como contraseña para la línea de teletype)

login (Pide a los usuarios que inicien sesión)

exit (para salir de modo de configuración de línea de teletype)

service password-encryption (para cifrar las contraseñas previamente configuradas)

banner motd #¡Acceso autorizado únicamente!# (Se configura el aviso legal y se usa
el símbolo "#" como delimitador del mensaje)

no ip domain-lookup (Previene que el router trate de resolver comandos incorrectos
enviando un consulta de DNS, es decir, desabilita tener que esperar cuando se
poner un comando incorrecto en modo usuario)

exit (para salir de modo de configuración global)

copy running-config startup-config (Copia la configuración actual que se encuentra
en la RAM hacia la NVRAM la cual contiene la configuración de arranque, es decir,
este comando nos permite guardar la configuración acutal por si el router se apaga,
así no se pierde dicha configuración y esta es cargada al encender el router)

## Configuración de una interfaz de un router

(En modo de configuración global)

interface nombre_interfaz  puerto_de_interfaz (Entra al modo de configuración de
la interfaz). Ejemplo: interface fastethernet 0/0

description texto_de_max_240_caracteres (Ayuda a identificar de manera fácil la
interfaz). Ejemplo: description Enlance a LAN 1

ip address direccion_ip mascara_de_red (Configura la dirección ip de la interfaz
y su máscara de red): Ejemplo: ip address 192.168.11.1 255.255.255.0

no shutdown (Enciende/habilita de manera "lógica" la interfaz)

exit (para salir de modo de configuración de interfaz)

## Configuración de una interfaz serial un router

(En modo de configuración global)

interface serial puerto_de_interfaz (Entra al modo de configuración de la
interfaz serial). Ejemplo: inteface serial 0/0/0

description texto_de_max_240_caracteres (Ayuda a identificar de manera fácil la
interfaz). Ejemplo: description Enlance a router R2

ip address direccion_ip mascara_de_red (Configura la dirección ip de la interfaz
y su máscara de red): Ejemplo: ip address 200.165.200.225 255.255.255.25252

clock rate numero_de_clock_rate (Configuración de velocidad de envío de datos
en b/s, es decir, bits por segundo). Ejemplo:  clock rate 128000

Nota: El clock rate solo se puede configurar en el DCE (Data Comunication
Equipment).

no shutdown (Enciende/habilita de manera "lógica" la interfaz)

exit (para salir de modo de configuración de interfaz)

Nota: El mensaje que muestra al configurar la interfaz serial muestra "down",
esto es porque aún no se ha configurado el otro router. cuando el otro router
sea configurado, el estado cambiará a "UP".

## Tarea

200.33.4.0/30

---

1.1.3.1 (config de router)

Para que no espere con comando erróneo:

"no ip domain-lookup" ("transfer preferred none"?????)


Tabla de enrutamiento:
Guarda las rutas que puede conocer

La C significa directamente conectada.

## Tarea (Lunes 2 de septiembre)

* Interconectar dispositivos
* Configurar interfaces con redes diferentes
* Configuración básica de router
* Desactivación de la ruta por defecto
* El router "2" debe tener una ruta estática por defecto a router "5" (entre el
y 5 no van conectados)

Red a utilizar decidida por mí: 192.168.1.0/24

Clase: C

Máscara de subnet: 255.255.255.0 (por defecto)

Cantidad de bits de subnet: 0

Número de redes: 1 (No subnetting)

Número de direcciones por red: 256

Números de direcciones utilizables por red: 254

| Dirección de red | Primera ip utilizable | Última ip utilizable |   Broadcast   |      Tipo de red      |
|:----------------:|:---------------------:|:--------------------:|:-------------:|:---------------------:|
|   192.168.1.0    |       192.168.1.1     |    192.168.1.254     | 192.168.1.255 |      Primera red      |
|   192.168.2.0    |       192.168.2.1     |    192.168.2.254     | 192.168.2.255 | Primera red de enlace |
|   192.168.3.0    |       192.168.3.1     |    192.168.3.254     | 192.168.3.255 |      Segunda red      |
|   192.168.4.0    |       192.168.4.1     |    192.168.4.254     | 192.168.4.255 | Segunda red de enlace |
|   192.168.5.0    |       192.168.5.1     |    192.168.5.254     | 192.168.5.255 |      Tercera red      |

Registro de direccionamiento de red (documentación)

| Dispositivo | Interfaz |   Dirección IP   | Máscara de subred | Gateway predeterminado |
|:------------:|:--------:|:---------------:|:-----------------:|:----------------------:|
|      R1      |   Fa0/0  |   192.168.1.1   |   255.255.255.0   |          N/D           |


## Examen (Lunes 9 de septiembre)

Teórico


## Examen (Jueves 5 de septiembre)

Práctico


## Implementación del routing estático

En general, hay 2 tipos de ruteos:

* Manual
* Dinámica

### Ruta completamente especificada

Interfaz de salida (del router ) y dirección del siguente salto.

Problemas comunes por las que puede no haber comunicación:

* Firewall
* Clock rates
* Máscaras
* Que la ip de pc no coincida
* Que falten rutas de aprender para los routers.

### Prática (Miércoles 4 de Septiembre)

Equipo: May, Julia, Ángel, Josué y Antonio

Material: 7 directos y 4 cruzados

### Ruta estática predeterminada

La ruta estática predeterminada sirve (a mi entender) para cuando el router a
configurar solo tiene un único puerto de salida. Este al no encontrar una dirección
para mandarlo, lo manda por el único puerto de salida que tiene y le delega el
envío de paquete al router que sigue.
