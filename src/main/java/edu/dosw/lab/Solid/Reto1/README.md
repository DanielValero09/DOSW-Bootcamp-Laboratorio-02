# Reto 1 - La Boleteria del Cine Astor

## Descripcion

Sistema sencillo de boleteria para el Cine Astor. Permite escribir por consola el tipo de espectador y la cantidad deseada de cada producto de la cartelera. Al finalizar, aplica el descuento correspondiente y genera una factura con subtotal, descuento y total.

## Datos usados

El catalogo se mantiene fijo en un `Map<String, Producto>` dentro de `CatalogoCineAstor`, como indico el profesor:

| Producto | Precio |
| --- | ---: |
| Boleta 2D | $14.000 |
| Boleta 3D | $22.000 |
| Crispetas | $9.000 |
| Gaseosa | $4.500 |

Tipos de espectador:

| Tipo | Descuento |
| --- | ---: |
| General | 0% |
| Estudiante | 15% |
| Tercera edad | 25% |

## SOLID aplicado

**S - Single Responsibility Principle**

Cada clase tiene una responsabilidad concreta:

- `Producto`: representa nombre y precio de un producto.
- `ItemOrden`: representa un producto con cantidad.
- `Orden`: administra los items y calcula el subtotal.
- `Factura`: imprime la factura y calcula descuento/total.
- `Espectador` y sus subclases: definen el tipo de espectador y su descuento.
- `SelectorEspectador`: crea el tipo de espectador elegido sin llenar `Reto1` de condicionales.
- `CatalogoCineAstor`: mantiene la lista fija de productos y precios.
- `EntradaConsola`: valida entradas numericas por consola.
- `Reto1`: prepara el escenario de ejecucion del reto.

**O - Open/Closed Principle**

Para agregar un nuevo tipo de espectador no es necesario modificar `Factura`, `Orden` ni `Reto1`. Solo se crea una nueva subclase de `Espectador` que implemente su porcentaje de descuento y se registra en `SelectorEspectador`.

**L - Liskov Substitution Principle**

`General`, `Estudiante` y `TerceraEdad` pueden usarse en cualquier lugar donde se espere un `Espectador`, porque todas respetan el contrato de descuento.

**I - Interface Segregation Principle**

La interfaz `Descuento` solo exige operaciones relacionadas con descuento. No obliga a las clases a implementar metodos ajenos al problema.

**D - Dependency Inversion Principle**

`Factura` trabaja con la abstraccion `Espectador`, no con clases concretas como `Estudiante` o `TerceraEdad`. Esto permite cambiar el tipo de espectador sin modificar la factura.

## Polimorfismo

El polimorfismo se aplica con la clase abstracta `Espectador` y sus implementaciones `General`, `Estudiante` y `TerceraEdad`. La factura llama `calcularDescuento(subtotal)` sin preguntar con condicionales que tipo de espectador es; cada subclase define su propio porcentaje.

## Streams usados

En `Orden.calcularSubtotal()` se usan Streams con:

- `filter`: descarta items con cantidades no validas.
- `map`: convierte cada item en su total.
- `reduce`: suma los valores.

En `Factura.imprimir()` y `Reto1.ejecutar()` se usa `forEach` para recorrer items y productos del catalogo.

## Evidencia de ejecucion

```text
Bienvenido al Cine Astor!
Tipos de espectador disponibles:
  1. General
  2. Estudiante
  3. Tercera edad
Espectador: estudiante

Espectador: Estudiante
Cartelera y precios:
  Boleta 2D - $14.000
  Boleta 3D - $22.000
  Crispetas - $9.000
  Gaseosa - $4.500
Ingrese su orden:
  Boleta 2D: 0
  Boleta 3D: 2
Boleta 3D: 2 unidades agregadas a la orden.
  Crispetas: 1
Crispetas: 1 unidad agregada a la orden.
  Gaseosa: 2
Gaseosa: 2 unidades agregadas a la orden.

------ FACTURA DE TAQUILLA -----
Espectador: Estudiante
Items:
  Boleta 3D - $44.000
  Crispetas - $9.000
  Gaseosa - $9.000
Subtotal: $62.000
Descuento (15%): $9.300
Total a pagar: $52.700
--------------------------------
Disfrute la funcion!
```
