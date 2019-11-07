# Commandos de configuración de VLANs

## Mostran VLANs y puertos

show vlan brief: Muestra las vlans disponibles y los puertos asignados a cada VLAN

#Creación de una VLAN

enable \
configure terminal \
vlan vlan_id \
name the_name \
end

Tanto el id de la VLAN como el nombre de la VLAN deben ser únicos.

# Asignar puertos a una VLAN creada

enable \
configure terminal \
interface interface_id (para entrar a la configuración de la interfaz) \
switchport mode access (para indicar que esa interfaz será de tipo access) \
switchport access vlan vlan_id (para asignar una vlan a este puerto que fue
configurado como access) \
end

# Eliminar asignación de VLAN

enable \
configure terminal \
interface interface_id (para entrar a la configuración de la interfaz) \
no switchport mode access (para indicar que esa interfaz ya no será de tipo access) \
end

# Eliminar VLAN

enable \
configure terminal \
no vlan vlan_id \
end

# Verificación de la información de una VLAN

show vlan brief: Para mostrar una línea para cada VLAN con el nombre, estado y
los puertos de la misma.

show vlan vlan_id: Para mostrar información sobre una sola VLAN por su id.

show vlan vlan_name: Para mostrar información sobre una sola VLAN por su nombre.

show vlan resume: Para mostrar el resumen de información de una VLAN.

show interfaces interface_id vlan vlan_id | switchport: Para mostrar el estado
de administración y operación de un puerto.

# Configuración de enlaces troncales IEEE 802.1Q (Nativa)

enable \
configure terminal \
interface interface_id \
switchport mode trunk (para configurar esa interfaz como trunk) \
switchport trunk native vlan vlan_id (para indicar una VLAN nativa para las
tramas sin etiqueta) \
switchport trunk allowed vlan vlan_list (i.e: 1,2,3,4 sin espacios) \
end

# Restablecimiento del enlace troncal al estado predeterminado

enable \
configure terminal \
interface interface_id \
no switchport trunk allowed vlan (establecer enlace troncal para permitir todas
las VLANs) \
no switchport trunk native vlan (Restablecer la VLAN nativa al valor predeterminado) \
end

# Verificación de la configuración de enlace troncal

show interfaces interface_id switchport: para mostrar la configuración de un
puerto del switch.

# Asignar una ip estática a una VLAN (switch de capa 2)

enable \
configure terminal \
interface vlan vlan_id \
no shutdown \
ip address ip mask \
end \
