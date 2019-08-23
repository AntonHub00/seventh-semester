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
