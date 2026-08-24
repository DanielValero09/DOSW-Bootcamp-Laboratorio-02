# Reto 7 - El Rover Explorador de Marte

## Descripcion

Sistema de control para el rover Chibchombo. Permite ejecutar una cantidad variable de acciones sobre sus modulos, registrar el operador responsable, deshacer una accion individual y mostrar el historial completo.

## Patron de diseño

**Categoria:** Comportamiento

**Patron utilizado:** Command

**Justificacion:** Cada accion del rover debe ejecutarse, registrarse y poder deshacerse despues. Command encapsula cada solicitud como un objeto independiente, separando la interfaz de control del rover de los modulos que realmente realizan la accion. Esto permite guardar historial, aplicar `undo` por accion y agregar nuevos comandos sin modificar el invocador.

## Como se aplico

- `RoverCommand`: interfaz Command. Define `execute()`, `undo()` y los datos necesarios para el historial.
- `AbstractRoverCommand`: base comun para los comandos concretos. Guarda operador, modulo, accion y parametros.
- `MotorAdvanceCommand`, `MotorReverseCommand`, `ArmCollectCommand`, `ArmReleaseCommand`, `CameraRecordCommand`, `CameraStopCommand`, `DrillCommand`, `DrillRetractCommand`: ConcreteCommand. Cada clase encapsula una accion concreta y su operacion inversa.
- `Motor`, `RoboticArm`, `RoverCamera`, `Drill`: Receiver. Son los modulos reales del rover.
- `RoverControl`: Invoker. Ejecuta comandos, conserva el historial y marca acciones deshechas.
- `CommandRecord`: registro del historial con estado `undone`.
- `CommandFactory`: crea el comando correcto segun la entrada del usuario.
- `Reto7`: flujo de consola y metodo estatico `ejecutar()`.

## Streams usados

En `Reto7.printHistory()` se usa:

```java
IntStream.range(0, control.getHistory().size())
        .forEach(index -> printRecord(index + 1, control.getHistory().get(index)));
```

Este Stream recorre el historial para imprimirlo numerado y marcar las acciones deshechas.

## Evidencia de ejecucion

Entrada usada:

```text
5
Camila
1
1
12
Camila
3
1
30
Camila
4
1
15
Julian
2
1
Julian
1
2
4
3
```

Salida:

```text
Rover Chibchombo
Rover avanza 12 m [Camila]
Camara grabando 30 s [Camila]
Taladro perfora 15 cm [Camila]
Muestra recogida [Julian]
Rover retrocede 4 m [Julian]
Accion deshecha: Taladro se retrae.

--- Historial ---
#1 Motor Avanzar(12m) - Camila
#2 Camara Grabar(30s) - Camila
#3 [DESHECHO] Taladro Perforar(15cm) - Camila
#4 Brazo Recoger - Julian
#5 Motor Retroceder(4m) - Julian
```
