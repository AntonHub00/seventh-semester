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

DCE y DTE

¿Cómo saber quién es DTE y quién DCE?

en show running-config en las seriales dice clock rate. Las 2 posibles seriales
pueden ser DTE

El que tiene clock rate DCE
El DTE no tiene clock rate

## Tarea

200.33.4.0/30
