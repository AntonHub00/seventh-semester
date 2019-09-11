# Unidad2

## CSS Grid

**¿Qués es CSS Grid?**

Ventajas:

- Acomodo en dos dimensiones
- Estructura flexible

### Antecedentes

Formas de lograrlo:

- Tablas "\<table\>"
- Float y margins
- Flexbox (tags no necesarios)
- CSS Grid

### ¿Se puede usar en producción?

Sí

caniuse.com (para ver si una tecnología funciona en un navegador específico)

### Templates

```css
display: grid;
```

se añade en el contenedor.

```css
grid-template-columns: 80px 200px auto 30px;
```

```css
justify-content: space-evenly;
justify-content: space-arround;
justify-content: space-between;
justify-content: center;
justify-content: start;
```
"justify-content" se añade en el contenedor

### Unidades de columnas y filas

- Para columnas -> c1, frx
- Para filas -> fr1, frx
- auto

Donde x es un número entero positivo.

### Alineación vertical

```css
align-content: center;
align-content: end;
align-content: start;
align-content: space-arround;
align-content: space-between;
```