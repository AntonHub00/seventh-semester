# Presentación de OSPF multiárea

## Entradas de la tabla de routing OSPF

Las rutas OSPF en una tabla de routing IPv4 se identifican con O, O IA y O E1/ O E2.

### O

LSA: (Link-State Advertisement (Anuncio de Estado de Enlace))

La O muestra una ruta que es intraárea. \
La O indica los LSA de router (tipo 1) y de red (tipo 2) y describen los
detalles dentro de una área.

### O IA

ABR: (Area Border Router (Router Fronterizo de Área)). Son los routers que
interconectan las áreas.

1. Un ABR recibe un LSA de router (tipo 1) en un área
2. El ABR envía un LSA de resumen (tipo 3) al área adyacente
3. Los LSA de resumen aparecen en la tabla de routing como IA (Inter Área)
4. Los LSA de resumen recibidas en un área también se reenvían a otras áreas

### O E1/E2

Las LSA externas aparecen marcadas como rutas externas tipo 1 o externas tipo 2. \
El tipo 2 (E2) es el valor predeterminado.

E1: Este se calcula añadiendo al coste externo el coste interno para alcanzar el destino. \
E2: Es el coste externo sin tener en cuenta el coste interno.

## Cálculo de router de OSPF

1. Todos los routers calculan las mejores rutas a los destinos que se encuentran
dentro de su área (intraárea) y agregan estas entradas a la tabla de routing.
2. Todos los routers calculan las mejores rutas hacia otras áreas en la interred.
3. Todos los routers (excepto los que están en forma de área aislada [stub])
calculan las mejores rutas hacia los destinos del sistema autónomo externo (tipo 5).

Al lograr convergencia, un router se comunica con cualquier red dentro o fuera del dominio de routing OSPF.
