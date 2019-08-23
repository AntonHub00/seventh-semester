# DOM

Cada etiqueta HTML es un objeto que puede tener padres e hijos

EL DOM puede ser modificable (añadir, eliminar modificar elementos)

Existen 12 tipos de nodos (se utilizan principalmente 5).

Document (Nodo raíz)
Element (Etiquetas HTML que pueden ser padres e hijos)
Attr (Atributos)
Text (Texto)
Comment (Commentarios)

---

## Operaciones básicas en el DOM

### Obtener

getElementByTagName()
getElementById()
getElementByClassName()

Los 3 métodos anteriores son de "document"

### Cambiar

element.innerHTML = nuevo HTML
element.attribute = nuevo valor
element.style.property = nuevo estilo
element.setAttribute = nuevo atributo, nuevo valor

### Crear eliminar

document.createElement(element)
document.removeChild(element)
document.appendChild(element)
document.repaceChild(element)
