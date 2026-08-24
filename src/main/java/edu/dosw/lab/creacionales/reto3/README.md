# Reto 3 - La Fabrica de Instrumentos

## Descripcion

Sistema de pedidos para Armonia Andina. Permite crear una cantidad variable de instrumentos seleccionando familia, modelo y gama. Cada instrumento calcula su precio como precio base del modelo multiplicado por el factor de la gama.

## Patron de diseño

**Categoria:** Creacional

**Patron utilizado:** Abstract Factory, apoyado por Factory Method en las fabricas concretas.

**Justificacion:** El problema tiene dos ejes de creacion: la familia define que modelos existen y su precio base, mientras que la gama define materiales, afinacion, estuche y factor de precio. Se usa Abstract Factory para separar la creacion por gama (`StudentInstrumentFactory`, `ProfessionalInstrumentFactory`, `VintageInstrumentFactory`) y mantener el cliente desacoplado de los detalles de construccion del instrumento.

## Como se aplico

- `InstrumentModel`: catalogo inmutable de modelos, familias y precios base.
- `InstrumentFamily`: enum con las familias Cuerda, Viento y Percusion.
- `InstrumentGrade`: enum con gama, factor, materiales y afinacion.
- `InstrumentFactory`: contrato de fabrica para crear instrumentos.
- `StudentInstrumentFactory`, `ProfessionalInstrumentFactory`, `VintageInstrumentFactory`: fabricas concretas que crean instrumentos con la configuracion propia de cada gama.
- `InstrumentFactoryProvider`: selecciona la fabrica adecuada segun la gama elegida.
- `Instrument`: producto final inmutable.
- `InstrumentOrder`: pedido que guarda los instrumentos y calcula el total con Streams.
- `Reto3`: flujo de consola y metodo estatico `ejecutar()`.

## Streams usados

En `InstrumentOrder.getTotal()` se usa:

```java
instruments.stream()
        .mapToLong(Instrument::getPrice)
        .sum();
```

En `Reto3.printSummary()` se usa `IntStream.range(...)` para imprimir el resumen numerado del pedido.

## Evidencia de ejecucion

```text
Bienvenido a Armonia Andina
Cuantos instrumentos desea pedir? 2

Instrumento 1:
Familias disponibles:
  1. Cuerda
  2. Viento
  3. Percusion
  Familia: 1
Modelos disponibles:
  1. Guitarra
  2. Violin
  3. Bajo
  Modelo: 2
Gamas disponibles:
  1. Estudiante
  2. Profesional
  3. Vintage
  Gama: 2

Instrumento 2:
Familias disponibles:
  1. Cuerda
  2. Viento
  3. Percusion
  Familia: 2
Modelos disponibles:
  1. Saxofon
  2. Flauta
  3. Trompeta
  Modelo: 1
Gamas disponibles:
  1. Estudiante
  2. Profesional
  3. Vintage
  Gama: 3

Instrumento 1: Violin Profesional
  Familia: Cuerda
  Materiales: maderas selectas
  Afinacion: 440 Hz
  Estuche: estuche rigido premium
  Precio: $4.800.000

Instrumento 2: Saxofon Vintage
  Familia: Viento
  Materiales: piezas de epoca
  Afinacion: 442 Hz
  Estuche: estuche de coleccion
  Precio: $12.500.000

Total a pagar: $17.300.000
Gracias por su pedido!
```
