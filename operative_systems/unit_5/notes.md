# Unidad 5: Protección y seguiridad

La protección es un mecanismos de control de acceso de los programas, procesos
o usuarios al sistema operativo o recursos. Los sitemas orientados a la
protección proveen maneras de distinguir entre usuario autorizado y no
autorizado.

## Objetivos

- Controlar el acceso a los recursos
- Protección frente a usuarios poco confiables

## Requisitos

- Confidencialidad
- Integridad
- Disponibilidad

## Principio de separación entre mecanismo y política

- Mecanismo: Con qué elementos se realiza la protección.
- Política: Conjunto de decisiones que se toman para especificar cómo se usan
esos elementos de protección.

## Clasificación

- Externa (física)
- Interna (operacional)

## Funciones

- Protección de los procesos del sistema contra los procesos de usuario
- Protección de los procesos de usuario contra los otros procesos de usuarios
- Protección de memoria
- Protección de dispositivos

## Funciones del SO

- Gestión de procesos(hilos o provilegios)
- Gestión de almacenamiento secundario (sistema de archivos)
- Gestión de E/S
- Administración de usuarios
- Interpretación de comandos
- Interfaz de usuario
- Inicialización de la máquina (boot)

## Entrega

- Equipos de 5 personas
- Al menos 2 funciones de SO
- Sistema ejecutándose
- Reporte descriptivo (manual de usuario)
- Jueves 5 de diciembre

## Mecanismo de protección y seguiridad de datos

*Copia de seguridad(backup)*: Es una copia d los datos originales que se realiza
con el fin de disponer de un medio para recuperarlos en caos de su pérdida.

*Matriz de acceso*: Es un elemento  básico a la hora de definiar una políticad de
seguridad ya que permite formalizar las distintas relaciones entre sujetos
activos y pasivos.

- Sujeto
- Objecto
- Derecho de acceso

*Firma digital*: Es un mecanismo criptográfico que permite al receptor de un
mensaje firmado identificar a la entidad originadora de dicho y confirmar que
el mensaje no ha sido alterado desde que fue enviado.

*Certificado digital*: Es un fichero informático firmado electrónicamente por un
prestador de servicios de certificación, que vincula unos datos de verificación
de firma a un firmante y confirma su identidad.

 - TLS (Transport Layer Security)
 - SSL (Secure Sockets Layer)

*Cifrado*: Es un procedimiento que utiliza un algoritmo de cifrado con cierta clave
para transformar el mensaje, de tal forma que se incomprensible, o al menos,
difícil de comprender a toda persona que no tenga la clave secreta.


- Cifrado César
- Transposición (Inversa, Columnar, China)
- Simétrica
- Asimétrica
