# Guía de examen de la primera unidad de Conmutación y Enrutamiento de Redes de Datos (examen teórico)

Autor: Antonio Emiko Ochoa Adame

## Disclaimer

La finalidad de este documento es servir como apoyo de estudio. El autor de la
versión original de este documento no se hace responsable del uso indebido del mismo.

## Introducción

### Conceptos de routing

**Switch ethernet**: Funciona en la capa 2 (enlace de datos). Se encarga de reenviar
tramas de ethernet entre dispositivos de una misma red.

**Router**: Conecta una red con otra. Se encarga de la entrega de paquetes a través
de distintas redes.

**¿Cómo sabe el router cuál es la mejor ruta para enviar un paquete?**: Usa la
tabla de routing.

**Gateway predeterminado**: Destino que enruta el tráfico desde la red local
hacia los dispositivos en las redes remotas. Cuando un host envía un paquete a
un dispositivo en una red IP diferente, el paquete se reenvía al gateway
predeterminado, ya que los dispositivos host no pueden comunicarse directamente
con los dispositivos que están fuera de la red local.

## Configuración inicial del router

### Funciones del router

#### Carecterísticas de una red

- Topología (disposición de los cables, los dispositivos de red y los sistemas
finales)
- Velocidad (bits por segundo (b/s))
- Costo (gasto de adquisición de componentes, instalación y el mantenimiento de
la red)
- Seguridad (nivel de protección de la red)
- Disponibilidad (probabilidad de que la red esté disponible para ser utilizada
cuando resulte necesario.)
- Escalabilidad (facilidad con la que la red puede admitir más usuarios y
requisitos de transmisión de datos)
- Confiabilidad (fiabilidad de los componentes que crean la red. Se mide como la
probabilidad de fallas o como el tiempo medio entre fallas (MTBF))

#### Los routers son computadoras

**Componentes de un disposivo con capacidad de red**:

- CPU
- Sistema operativo
- Memoria y almacenamiento

#### Los router interconectan redes

**¿Cómo funciona un router?**

Cuando un router recibe un paquete IP en una interfaz, determina qué interfaz
debe usar para reenviar el paquete hacia el destino.

Generalmente, cada red a la que se conecta un router requiere una interfaz
separada. Estas interfaces se usan para conectar una combinación de redes de
área local (LAN) y redes de área extensa (WAN).

Por lo general, las LAN son redes Ethernet que contienen dispositivos como
computadoras, impresoras y servidores. Las WAN se usan para conectar redes a
través de un área geográfica extensa.

La encapsulación de enlace de datos depende del tipo de interfaz en el router y
del tipo de medio al que se conecta.

#### Los routers eligen las mejores rutas

**Funciones principales de un router**:

- Determinar la mejor ruta para reenviar paquetes (usando la tabla de routing)
- Reenviar paquetes a su destino

**Tecnologías de enlace de datos a las que se puede conectar un router**:

- Ethernet
- PPP (Point to Point Protocol)
- Frame Relay
- DSL
- Tecnología de cable
- Tecnología inalámbrica (Bluetooth, 802.11, etc.)

**Nota**: Los routers usan rutas estáticas y protocolos de routing dinámico
para descubrir redes remotas y crear sus tablas de routing.

#### Mecanismos de reenvío de paquetes

Los router admiten 3 mecanismos de reenvío de paquetes:

- Switching de procesos: El más antiguo y menos eficiente.
- Switching rápido
- Cisco Express Forwarding (CEF)

**Switching de procesos**

Se hace este proceso con cada paquete, incluso si el destino es el mismo para
un flujo de paquetes.

Es lento y no se suele usar en redes modernas.
Funcionamiento de este mecanismo:

1. Paquete llega a interfaz
2. Se reenvía al plano de control
3. CPU hace coincidir la dirección de destino con una entrada de la tabla de routing
4. CPU determina la interfaz de salida
5. Reenvía el paquete.

**Switching rápido**

Usa una memoria caché de switching rápido para almacenar la información de
siguiente salto.

Funcionamiento de este mecanismo:

1. Paquete llega a interfaz
2. Se reenvía al plano de control
3. CPU busca coincidencia en caché de switching rápido
    1. Si no coincidencia, se aplica mecanismo de switching de procesos
4. Se reenvía a la interfaz de salida

La información de flujo del paquete también se almacena en la caché de switching
rápido. Si otro paquete con el mismo destino llega a una interfaz, se vuelve a
utilizar la información de siguiente salto de la caché sin intervención de la CPU.

**Cisco Express Forwarding**

El más reciente y utilizado del IOS de Cisco.

Características:

- Arma una base de información de reenvío (FIB = Forwarding Information Base) y
una tabla de adyacencia
- Las entradas de la tabla no se activan por los paquetes como en el switching
rápido, sino que se activan por los cambios, como cuando se modifica un elemento
en la topología de la red.
- Cuando se converge una red, la FIB y las tablas de adyacencia contienen toda
la información que el router debe tener en cuenta al reenviar un paquete.
- La FIB contiene búsquedas inversas calculadas previamente, información de
siguiente salto para las rutas, incluida la información de interfaz y de capa 2

#### Tipos de memoria del router

**NVRAM**: Configuración de inicio.

**Memoria Flash**: Archivos de IOS y del sistema.

**ROM**: Instrucciones de diagnóstico y de arranque.

**RAM**: Configuración en ejecución.

### Conectar los dispositivos

#### Gateways predeterminados

**Dirección IP**: Identifica un host único en una red local.

**Máscara de subred**: Identifica con qué subred de la red se puede comunicar el host.

**Gateway predeterminado**: Identifica la dirección IP del router al que se debe
enviar un paquete cuando el destino no está en la misma subred de la red local.

El gateway predeterminado es el destino que enruta el tráfico desde la red local
hacia los dispositivos en las redes remotas.

Por lo general, el gateway predeterminado es la dirección de la interfaz en el
router que se conecta a la red local.

**IMPORTANTE!!!**: Los routers también se suelen configurar con su propio gateway
predeterminado. Este se conoce como “gateway de último recurso”.

#### Registro del direccionamiento de red

Documentación mínima de una red:

- Nombres de los dispositivos
- Intefaces usadas en el diseño
- Direcciones IP y máscaras de subred
- Direcciones de gateway predeterminado

Herramientas para hacer la documentación mínima de una red:

- **Diagrama de topología**: Referencia visual de conectividad física y
direccionamiento lógico
- **Tabla de direccionamiento**: Tabla que captura nombres de dispositivos,
interfaces, direcciones IPv4, máscaras de subred y direcciones de gateway
predeterminado.

#### Habilitación de IP en un host

Se puede asignar información de dirección IP a un host de dos formas:

- **Estática**: Se asigna la dirección IP, la máscara de subred y el gateway
predeterminado correctos al host de forma manual
- **Dinámica**: Un servidor proporciona la información de dirección IP mediante
el protocolo de configuración dinámica de host (DHCP).

Por lo general, las direcciones asignadas estáticamente se usan para identificar
recursos de red específicos, como servidores e impresoras de red.

En las empresas grandes, se implementan servidores DHCPv4 dedicados que
proporcionan servicios a muchas LAN.

#### LED de dispositivos

La mayoría de las interfaces de red tienen uno o dos indicadores LED de enlace
junto a la interfaz:

- LED verde indica una conexión correcta
- LED verde que parpadea indica actividad de red

LEDs en puerto de router cisco:

- GigabitEthernet/FastEthernet
    - S (Speed = Velocidad)
        - 1 parpadeo + pause = 10 Mb/s
        - 2 parpadeo + pause = 100 Mb/s
        - 3 parpadeo + pause = 1000 Mb/s
    - L (Link = Enlace)
        - Verde = Enlace activo
        - Apagado = Enlace inactivo
- Consola
    - EN
        - Verde = Puerto activo
        - Apagado = Puerto inactivo
- USB
    - EN
        - Verde = Puerto activo
        - Apagado = Puerto inactivo

#### Acceso a consola

En producción normalmente se hace conexión por SSH o HTTPS.

Acceso a consola solo es necesario para la configuración inicial de un dispositivo
o por si la conexión remota falla.

Requerimientos para conectar por consola:

- **Cable de consola**: Cable serial RJ-45 a DB-9 o cable serial USB
- **Software de emulación de terminal**: Tera Term, PuTTY, HyperTerminal

El cable se conecta entre el puerto serie del host y el puerto de consola en el
dispositivo.

La mayoría de las computadoras portátiles y de escritorio ya no cuentan con
puertos serie incorporados.

Si se tiene puerto serie en computadora se necesita:

- Cable de consola RJ-45 a DB-9
- Se conecta a router en puerto RJ-45
- Software de emulación de terminal

Si se tiene puerto USB tipo A en computadora se necesita:

- Adaptador de puerto serie compatible con USB a RS-232
- Controlador del adaptador (cuando aplique)
- Cable de consola RJ-45 a DB-9
- Se conectar a router en puerto RJ-45
- Software de emulación de terminal

ó

- Cable USB tipo A (computadora) a USB tipo B mini (router)
- Controlador del adaptador
- Se conecta a router en puerto USB B mini
- Software de emulación de terminal

![Puertos y cable requeridos](ports_and_cables.png)

#### Habilitación IP en switch

La IP en un switch se usa para la administración remota del mismo (SSH, TELNET,
HTTPS, etc.).

Los switches no tienen interfaz dedicada para asignarle una IP.

La IP en un switch se configura a través de la SVI (Switch Virtual Interface).

Ejemplo de configuración en switch (config):

interface vlan 1

ip address 192.168.1.2 255.255.255.0

no shutdown

exit

ip default-gateway *ip_de_router*

### Configuración básica del router

#### Configuración de parámetros básicos del router

- **Asignar un nombre al dispositivo**: Para distinguirlo de otros routers
- **Asegurar acceso de administración**: Asegura EXEC privilegiado, EXEC de usuario y acceso remoto
- **Configurar un aviso**: Para proporcionar notificaciones legales de acceso no autorizado

#### Configuración de una interfaz loopback IPv4

La interfaz loopback es una interfaz lógica interna del router. Esta no se
asigna a un puerto físico y, por lo tanto, nunca se puede conectar a otro
dispositivo. Se la considera una interfaz de software que se coloca
automáticamente en estado "up" (activo), siempre que el router esté en funcionamiento.

La interfaz loopback es útil para probar y administrar un dispositivo Cisco IOS,
ya que asegura que por lo menos una interfaz esté siempre disponible. Por ejemplo,
se puede usar con fines de prueba, como la prueba de procesos de routing interno,
mediante la emulación de redes detrás del router.

Comandos:

interface loopback 0

dirección ip dirección-ip máscara-subred

exit

### Verificación de conectividad redes directamente conectadas

- **show ip interface brief**: Muestra un resumen de todas las interfaces,
incluidos la dirección IPv4 de la interfaz y el estado operativo actual.
- **show ip route**: Muestra el contenido de la tabla de routing IPv4 que se
almacena en la RAM. En el IOS de Cisco 15, las interfaces activas deben aparecer
en la tabla de routing con dos entradas relacionadas identificadas con el código
“C” (conectada) o “L” (local). En versiones anteriores de IOS, solo aparece una
única entrada con el código “C”.
- **show running-config interface interface-id**: Muestra los comandos
configurados en la interfaz especificada.

Comandos para recopilar información más detallada sobre la interfaz:

- **show interfaces**: Muestra información sobre la interfaz y el conteo de flujo
de paquetes de todas las interfaces del dispositivo.
- **show ip interface**: Muestra la información relacionada con IPv4 de todas
las interfaces de un router.

## Decisiones de routing

### Switching de paquetes entre redes

####








---

## Algunos términos

__Gateway de último recurso (ruta predeterminada)__: Es la dirección ip de otro
router. Es simplemente la dirección IP que se utiliza para el routing de paquetes
dirigidos a las redes que no están explícitamente enumeradas enrciju la tabla de routing.

Las *rutas estáticas predeterminadas* se utilizan como gateway de último recurso
para reenviar tráfico de destino desconocido a una interfaz de siguiente salto
o de salida. La interfaz de siguiente salto o de salida es el destino al que se
envía el tráfico en una red una vez que se encuentra la coincidencia con el
tráfico en un router. El origen de la ruta es la ubicación donde se descubrió
una ruta.

Se usan 3 comandos para establecer el gateway deúltimo recurso (ruta predeterminada):

- ip default-gateway
- ip default-network
- ip route 0.0.0.0 0.0.0.0


**Distancia admnistrativa**: Término utilizado para describir el valor asignado
a la confiabilidad del origen de la ruta descubierta por un router.


**DHCP y definido estáticamente**: Método usados para asignar una dirección ip
a un host de una red.


**Gateway predeterminado**: Dirección ip utilizada para llegar redes remotas.


**Interfaz loopback**: Tipo de interfaz no asignada a un puerto físico, que siempre
está activa y que ocacionalmente se utiliza para realizar pruebas.


**Ruta directamente conectada**: La más verosímil o más confiable que un router
tiene.


**Ejemplos de protocolos de routing dinámico**:

- EIGRP
- OSPF (Open Shortest Path First)
- IS-IS
- RIP


**3 configuraciones que se deben hacer en un router nuevo**:

- Nombre
- Acceso de administración seguro
- Anuncio


**Distancia administrativa de 1**: Es distancia administrativa predeterminada en
un router.


**Crear ruta estática predeterminada**:

ip route 0.0.0.0 0.0.0.0 _siguiente salto/interfaz de salida_


**CEF (Cisco Express Fordwarding)**: Tipo de mecanismo de envío de paquetes que
crear un tabla FIB y de adyacencia.