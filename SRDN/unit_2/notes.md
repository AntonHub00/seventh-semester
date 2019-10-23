# Subnetting

- Mask
- No mask
- c/subredes
- c/host
- VLSM

2$^$n

2$^$n -2

**Pasos**

Paso1: Identificar cuántos bits son de net y cuántos de host

Paso2: Sacar la red poniendo en 1 todos los bits de net sacados en el paso anterior

Paso3: No recuerdo

**Para subredes**

5 subredes

Ejemplo:

 2 ^ 3 = 8

 192.168.1.0/24

11111111 11111111 0.0.0.0 0.0.0.0 Red original

11111111 11111111 11111111 11100000 (255.255.)Red con bits de red (3)



---

118.0.0.0

2 ^ 7 = 128 subredes (7 bit de net)

11111111.11111111.00000000.00000000 Máscara de red original
11111111.11111111.11111110.00000000 Subnet (red mask: 255.255.254.0, host: 512)

118.0.0.0
118.0.2.0
118.0.4.0
118.0.6.0


## Tarea

Segmentar para 1500 subredes 200.33.0.0/16

Segementar para 1200 host 177.18.0.0/19

Segmentar para 2 host utilizables 10.10.10.0/16

Encontrar la subred 780 172.16.0.0

---

Dummy example:

118.1.2.128/8

Direccion original: 118.0.0.0

Clase A: 255.0.0.0 (por defecto)

Se necesitan 250 subredes:

2 ^ 8 = 256

máscara nueva: 11111111.11111111.0.0
subred: 118.1.0.0

118.1.0.0
118.1.0.32
118.1.0.250
118.1.1.26

---

VLSM

Ordenar de mayor a menor (cantidad de hosts), sinó no funciona.

## Tarea (subnetting)

Red: 10.0.0.0/16 \
Loopback para Router 2: 200.33.171.0/24

Hosts: 130, 120, 80, 60, 20, 2, 2, 2 \
Total de hosts: 416

### Red 1

Red "original": 10.0.0.0/16 \
Máscara de red: 255.255.0.0 \
Cantidad de host requeridos: 130 \

2 ^ n - 2 >= 130 -> n = 8

Cantidad de bits de host: 8 \
Cantidad de direcciones totales: 256 (254 utilizables)

Nueva máscara de red: 255.255.255.0 = 24
Nueva dirección de red: 10.0.0.0 /24

### Red 2

Red "original": 10.0.1.0/24 \
Máscara de red: 255.255.255.0 \
Cantidad de host requeridos: 120 \

2 ^ n - 2 >= 120 -> n = 7

Cantidad de bits de host: 7 \
Cantidad de direcciones totales: 128 (126 utilizables)

Nueva máscara de red: 255.255.255.128 = 25
Nueva dirección de red: 10.0.1.0 /25

### Red 3

Red "original": 10.0.1.128/25 \
Máscara de red: 255.255.255.128 \
Cantidad de host requeridos: 80 \

2 ^ n - 2 >= 80 -> n = 7

Cantidad de bits de host: 7 \
Cantidad de direcciones totales: 128 (126 utilizables)

Nueva máscara de red: 255.255.255.128 = 25
Nueva dirección de red: 10.0.1.128 /25

### Red 4

Red "original": 10.0.2.0/25 \
Máscara de red: 255.255.255.128 \
Cantidad de host requeridos: 60 \

2 ^ n - 2 >= 60 -> n = 6

Cantidad de bits de host: 6 \
Cantidad de direcciones totales: 64 (62 utilizables)

Nueva máscara de red: 255.255.255.192 = 26
Nueva dirección de red: 10.0.2.0 /26

### Red 5

Red "original": 10.0.2.64/26 \
Máscara de red: 255.255.255.192 \
Cantidad de host requeridos: 20 \

2 ^ n - 2 >= 20 -> n = 5

Cantidad de bits de host: 5 \
Cantidad de direcciones totales: 32 (30 utilizables)

Nueva máscara de red: 255.255.255.224 = 27
Nueva dirección de red: 10.0.2.64 /27

### Red 6

Red "original": 10.0.2.96/27 \
Máscara de red: 255.255.255.224 \
Cantidad de host requeridos: 2 \

2 ^ n - 2 >= 2 -> n = 2

Cantidad de bits de host: 2 \
Cantidad de direcciones totales: 4 (2 utilizables)

Nueva máscara de red: 255.255.255.252 = 30
Nueva dirección de red: 10.0.2.96 /30

### Red 7

Red "original": 10.0.2.100/28 \
Máscara de red: 255.255.255.240 \
Cantidad de host requeridos: 2 \

2 ^ n - 2 >= 2 -> n = 2

Cantidad de bits de host: 2 \
Cantidad de direcciones totales: 4 (2 utilizables)

Nueva máscara de red: 255.255.255.252 = 30
Nueva dirección de red: 10.0.2.100 /30

### Red 8

Red "original": 10.0.2.104/28 \
Máscara de red: 255.255.255.240 \
Cantidad de host requeridos: 2 \

2 ^ n - 2 >= 2 -> n = 2

Cantidad de bits de host: 2 \
Cantidad de direcciones totales: 4 (2 utilizables)

Nueva máscara de red: 255.255.255.252 = 30
Nueva dirección de red: 10.0.2.104 /30

### Tabla de direcciones

| Dirección de red | Rango de ips utilizables|   Broadcast   |          Máscara           |
|:----------------:|:-----------------------:|:-------------:|:--------------------------:|
|   10.0.0.0       |  10.0.0.1-10.0.0.254    |   10.0.0.255  |     24 (255.255.255.0)     | (130)
|   10.0.1.0       |  10.0.1.1-10.0.1.126    |   10.0.1.127  |     25 (255.255.255.128)   |  (120)
|   10.0.1.128     |  10.0.1.129-10.0.1.254  |   10.0.1.255  |     25 (255.255.255.128)   |  (80)
|   10.0.2.0       |  10.0.2.1-10.0.2.62     |   10.0.2.63   |     26 (255.255.255.192)   |  (60)
|   10.0.2.64      |  10.0.2.65-10.0.2.94    |   10.0.2.95   |     27 (255.255.255.224)   |  (20)
|   10.0.2.96      |  10.0.2.97-10.0.2.98    |   10.0.2.99   |     30 (255.255.255.252)   |  (2)
|   10.0.2.100     |  10.0.2.101-10.0.2.102  |   10.0.2.103  |     30 (255.255.255.252)   |  (2)
|   10.0.2.104     |  10.0.2.105-10.0.2.106  |   10.0.2.107  |     30 (255.255.255.252)   |  (2)

---

## Routing dinámico

Protocolos de gatewawy interior y exterior

backbone

Dentro de un backbone se uttilizar gateway interior.

Protocolor de gateway interior.

- Vector distancia P que facilitan o distribuyen rutas con lo vecinos.
- Estado de enlace: Cada router conoce toda la topología (completa).

Ventajas de routing dinámica:

- Detección de redes remotas automáticamente (el router propaga sus rutas)
- Mantener info actualizada
- Elige el mejor camino hacia las redes
- Busca mejor ruta nueva si actual falla

## RIP

V1 y V2

v1: Una topología debe tener la misma clase (router rip) (router ? para ver protocolos soportados).

No son compatibles (todos V1 o todos V2).

network 192.168.1.0 (donde la ip es la de la interfaz conectada).

R (RIP) en la tabla de enrutamiento.

show ip protocols (para ver los protocolos usados actualmente).

Se puede usar rutas dinámicas y estáticas al mismo tiempo.

v2: Se necesita auto summary para poder usar redes con diferentes máscaras.

Ruta estática sumarizada?

no auto-summary (para desactivarlo).

---

Interfaces pasivas: No les debe llegar actualización de los routers(no es necesario)

router rip

passive-interface g0/0

---

Propagación de ruta por defecto

RIP hace propagación automática. La ruta por defecto solo se necesita en el
router seleccionado (Solo se configura en 1 y se propaga a otros router).

default-information originate.

---

Ruta directamente conectada se pone L en la tabla de routing. (Se crean solas,
don't worry).

---

Entrada de ruta de red remota en la R1.

---

Rutas final: Rutas que se aprenden a través de un protocolo como RIP.

Ruta de nivel 1: Red, superre y predeterminado.

sería S* o R quien sabe que.

Ruta primaria de nivel 1: Son las rutas que contienen más direcciones.

Ruta primaria de nivel 2: Son las rutas que son contenidas en una dirección.

---

De V2 a V1 se autosumarizan las clases para que funcione.

## EIGRP

DUAL: paquetes.
RTP va vinculado con TCP y UDP.

PDM:

forma interna del EIGRP.

router eigrp AS-#
router eigrp #

Los ids en los routers puede ser manual o automática:

Manual:

eigrp router-id *dirección-ipv4*

Checar condicioes de asignación de id.

router eigrp 1
network 172.16.0.0
network 192.168.10.0
router eigrp neighbors (bueno para saber los routers vecinos)
passive-?
bandwith num (dentro de la interfaz, así se configura la velocidad de esa intefaz)

Máscara comodin: 255.255.255.255 - máscarade subred.

show ip eigrp neighbors

## Práctica

Dispositivo: R1
Problema identificado: PC1 no puede hacer ping con R2 ni R3
Solución propuesta: Revisar la tabla de routing para comprobar las rutas y checar
la dirección IP.
¿Funcionó?: