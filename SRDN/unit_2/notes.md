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