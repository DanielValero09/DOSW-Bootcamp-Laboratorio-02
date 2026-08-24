# Reto 5 - La Moto Personalizada

## Descripcion

Sistema para personalizar una moto Naked 250 en el Taller Turbo Andes. La moto base cuesta $9.800.000 y el usuario puede seleccionar mejoras de accesorios, pinturas y complementos.

## Patron de diseño

**Categoria:** Estructural

**Patron utilizado:** Decorator

**Justificacion:** La moto base no debe cambiar cada vez que aparece una mejora nueva. Decorator permite envolver la moto con objetos que agregan comportamiento y costo adicional sin modificar `Naked250`, cumpliendo el principio Open/Closed.

## Como se aplico

- `Motorcycle`: componente comun con descripcion, precio y mejoras aplicadas.
- `Naked250`: componente concreto con el modelo y precio base inmutable.
- `MotorcycleDecorator`: decorador abstracto que mantiene una referencia al componente decorado.
- `EnhancementDecorator`: decorador concreto que agrega una mejora, suma su precio y compone la descripcion final.
- `Enhancement`: record inmutable con opcion, categoria, nombre y precio de cada mejora.
- `EnhancementCatalog`: catalogo de mejoras disponibles. Para agregar una mejora nueva se registra aqui sin tocar la moto base.
- `MotorcycleOrder`: pedido que recibe la moto base y las mejoras seleccionadas.
- `Reto5`: flujo de consola y metodo estatico `ejecutar()`.

## Streams usados

En `MotorcycleOrder.getEnhancementsTotal()` se usa:

```java
selectedEnhancements.stream()
        .mapToLong(Enhancement::price)
        .sum();
```

En `Reto5.readSelectedEnhancements()` se usan Streams para convertir las opciones ingresadas por consola en mejoras del catalogo.

## Evidencia de ejecucion

Entrada usada: `1, 5, 9`

```text
Taller Turbo Andes
Moto base: Naked 250 ($9.800.000)
Elige tus mejoras:
   1. Escape deportivo             (+$1.400.000)
   2. Manillar deportivo           (+$480.000)
   3. Luces LED                    (+$350.000)
   4. Alforjas laterales           (+$600.000)
   5. Pintura mate negro           (+$900.000)
   6. Pintura metalizado tricapa   (+$1.600.000)
   7. Vinilo personalizado         (+$700.000)
   8. GPS integrado                (+$1.100.000)
   9. Baul trasero                 (+$550.000)
  10. Sistema de sonido            (+$820.000)
Mejoras elegidas: 1, 5, 9

--- Tu Moto ---
Naked 250
  + Escape deportivo
  + Pintura mate negro
  + Baul trasero
Descripcion: Naked 250 con escape deportivo, pintura mate negro y baul trasero
Precio base:  $9.800.000
Mejoras:      $2.850.000
Total:        $12.650.000
Buen viaje!
```
