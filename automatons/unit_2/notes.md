# Análisis sintáctico (Unidad 2)

En esta fase se necesita las gramáticas libres de contexto.

Una gramática libre de contexto (GlC) se componen de 4 cosas:

* Terminal Épsilon = \{a, b\}
* No terminal
* Axioma
* Reglas

LL(1): Derivación por la izquierda de un caracter a la vez: Derivación por la
izquierda de un caracter a la vez.

---

void Start():{
    (D())+<EOF>;
}

void D():{
    T() L()
}

void T():{
    <Boolean> | <Char>
}

void L():{
    <Id> | Lp()
}

void Lp():{
    (<Coma> <Id> Lp())*
}

---
