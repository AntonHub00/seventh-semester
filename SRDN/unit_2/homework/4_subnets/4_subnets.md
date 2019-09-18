# Tarea (Subnetting de 4 redes)

## 1500 subredes para 200.33.0.0/16

**Paso 1**:

IP original: 200.33.0.0 \
Máscara original: 16 = 255.255.0.0

**Paso 2**:

Subredes: $2^n \geqslant m$ \
Host: $(2^n)-2 \geqslant m$

Donde m es la cantidad de redes y hosts buscados, respectivamente. \
Donde n es el números de bits necesarios para encontrar m o mayor.

Suberedes necesarias: 1500

$2 ^{11} = 2048 \rightarrow \geqslant 1500$

n = 11 (el número más cercano a 1500)

**Paso 3**:

Red: 16 + 11 = 27 bits de red \
Máscara de subred: 255.255.255.224 = 11111111.11111111.<span style="color:red">11111111.111</span>00000 \
Primera subred: 200.33.0.0 \
Cantidad de direcciones por red: 32 \

**Paso** 4:

| Subred       | Rango de ip utilizables   | Dirección de broadcast |
|:------------:|:-------------------------:|:----------------------:|
| 200.33.0.0   | 200.33.0.1-200.33.0.30    | 200.33.0.31            |
| 200.33.0.32  | 200.33.0.33-200.33.0.62   | 200.33.0.63            |
| 200.33.0.64  | 200.33.0.65-200.33.0.94   | 200.33.0.95            |
| 200.33.0.96  | 200.33.0.97-200.33.0.126  | 200.33.0.127           |
| 200.33.0.128 | 200.33.0.129-200.33.0.158 | 200.33.0.159           |


## 1200 hosts para 177.18.0.0/19

**Paso 1**:

IP original: 177.18.0.0/19 \
Máscara original: 19 = 255.255.224.0

**Paso 2**:

Subredes: $2^n \geqslant m$ \
Host: $(2^n)-2 \geqslant m$

Donde m es la cantidad de redes y hosts buscados, respectivamente. \
Donde n es el números de bits necesarios para encontrar m o mayor.

Hosts necesarios: 1200

$2 ^{11} = 2048 - 2 \rightarrow \geqslant 1200$: 2046 direcciones utilizables

n = 11 (el número más cercano a 1200)

**Paso 3**:

Red: 32 - n = 21 bits de red \
Máscara de subred: 255.255.248.0 = 11111111.11111111.111<span style="color:red">11</span>000.000000000 \
Primera subred: 177.18.0.0 \
Cantidad de direcciones por red: 2048 \

**Paso** 4:

| Subred       | Rango de ip utilizables   | Dirección de broadcast |
|:------------:|:-------------------------:|:----------------------:|
| 177.18.0.0   | 177.18.0.1-177.18.7.254   | 177.18.7.255           |
| 177.18.8.0   | 177.18.8.1-177.18.15.254  | 177.18.15.255          |
| 177.18.16.0  | 177.18.16.1-177.18.23.254 | 177.18.23.255          |
| 177.18.24.0  | 177.18.24.1-177.18.31.254 | 177.18.31.255          |

## 2 hosts utilizables para 10.10.10.0/24

**Paso 1**:

IP original: 10.10.10.0/24 \
Máscara original: 24 = 255.255.255.0

**Paso 2**:

Subredes: $2^n \geqslant m$ \
Host: $(2^n)-2 \geqslant m$

Donde m es la cantidad de redes y hosts buscados, respectivamente. \
Donde n es el números de bits necesarios para encontrar m o mayor.

Hosts necesarios: 2

$(2 ^ 2) - 2 \rightarrow \geqslant 2$: 2 direcciones utilizables

n = 2 (el número más cercano a 2)

**Paso 3**:

Red: 32 - n = 30 bits de red \
Máscara de subred: 255.255.252.0 = 11111111.11111111.11111111.<span style="color:red">111111</span>00 \
Primera subred: 10.10.10.0 \
Cantidad de direcciones por red: 4 \

**Paso** 4:

| Subred       | Rango de ip utilizables   | Dirección de broadcast |
|:------------:|:-------------------------:|:----------------------:|
| 10.10.10.0   | 10.10.10.1-10.10.10.2     | 10.10.10.3             |
| 10.10.10.4   | 10.10.10.5-10.10.10.6     | 10.10.10.7             |
| 10.10.10.8   | 10.10.10.9-10.10.10.10     | 10.10.10.11            |
| 10.10.10.12  | 10.10.10.13-10.10.10.14    | 10.10.10.15            |
| 10.10.10.16  | 10.10.10.17-10.10.10.18    | 10.10.10.19            |

## Encontrar la subred 780 para 172.16.0.0/16

**Paso 1**:

IP original:  172.16.0.0/16 \
Máscara original: 16 = 255.255.0.0

**Paso 2**:

Subredes: $2^n \geqslant m$ \
Host: $(2^n)-2 \geqslant m$

Donde m es la cantidad de redes y hosts buscados, respectivamente. \
Donde n es el números de bits necesarios para encontrar m o mayor.

Redes necesarias: 780

$(2 ^{10}) = 1024  \rightarrow \geqslant 780$: 1022 direcciones utilizables

n = 10 (el número más cercano a 780)

**Paso 3**:

Red: 16 + 10 = 26 bits de red \
Máscara de subred: 255.255.192.0 = 11111111.11111111.11111111.<span style="color:red">11</span>000000 \
Primera subred: 172.16.0.0 \
Cantidad de direcciones por red: 64 \

**Paso** 4:

| Subred       | Rango de ip utilizables   | Dirección de broadcast |
|:------------:|:-------------------------:|:----------------------:|
| 172.16.0.0   | 172.16.0.1-172.16.0.62    | 172.16.3.63            |
| 172.16.0.64  | 172.16.0.65-172.16.0.126  | 172.16.3.127           |

Red #780: 172.16.195.0