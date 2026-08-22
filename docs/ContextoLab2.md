# Guía para Codex — Laboratorio 2 Parte 2: Hackathon Express

## Objetivo general

Implementar el laboratorio **Hackathon Express 2026-2** de Desarrollo Orientado a Software aplicando:

- Principios SOLID.
- Patrones de diseño.
- Programación orientada a objetos.
- Polimorfismo.
- Encapsulamiento.
- Inmutabilidad.
- Java Streams.
- UML en el reto 8.

El proyecto debe organizar cada reto en su propia carpeta/paquete (`reto1/`, `reto2/`, etc.) dentro de la categoría correspondiente (`solid/`, `creacionales/`, `estructurales/`, `comportamiento/`, etc.).

Cada reto debe exponer un método estático `ejecutar()` o `run()` y `Application.java` únicamente debe invocar esos métodos de forma ordenada. No concentrar la lógica en `main`.

## Reglas generales que Codex debe respetar

1. Antes de modificar código, inspeccionar la estructura actual del repositorio y reutilizar convenciones, paquetes, versión de Java y configuración Maven/Gradle existentes.
2. No reemplazar ni borrar trabajo existente sin necesidad.
3. Mantener cada reto aislado y fácil de ejecutar.
4. Usar POO y evitar soluciones monolíticas.
5. Cuando el enunciado exige Streams, utilizarlos de forma real para los cálculos indicados.
6. No introducir librerías externas si el proyecto no las necesita.
7. Mantener nombres de clases y métodos claros.
8. Después de cada reto, compilar y ejecutar antes de continuar.
9. No inventar requisitos que no aparecen en el laboratorio.
10. Preparar cada reto para que ambos integrantes puedan realizar commits dentro de él.
11. Mantener o crear un `README.md` por reto con la documentación solicitada.
12. Guardar evidencia de ejecución para posteriormente incluir una captura de consola en el README.

---

# Reto 1 — La Boletería del Cine Astor

## Temas
SOLID, Streams y POO.

## Funcionalidad
Crear un sistema donde un espectador pueda agregar boletas y productos de confitería, aplicar el descuento correspondiente y generar una factura.

## Datos obligatorios
- Boleta 2D: $14.000
- Boleta 3D: $22.000
- Crispetas: $9.000
- Gaseosa: $4.500
- General: 0% de descuento
- Estudiante: 15%
- Tercera edad: 25%

## Requisitos
- Usar `map`, `filter`, `reduce` y/o `forEach` para procesar ítems y totales.
- Aplicar encapsulamiento con atributos privados y getters/setters.
- Precio de boletas y confitería inmutable después de su creación.
- Usar polimorfismo para los tipos de espectador/descuentos.
- Generar factura con ítems, subtotal, descuento y total.

## README
Explicar:
- Cada principio SOLID aplicado, indicando dónde y cómo.
- Cómo se usa polimorfismo.

---

# Reto 2 — El Sastre a la Medida

## Patrón recomendado
**Builder — Creacional.**

## Funcionalidad
Construir un traje pieza por pieza.

## Precios
- Lana italiana: $320.000
- Paño nacional: $150.000
- Saco cruzado: $250.000
- Saco recto: $200.000
- Pantalón slim: $180.000
- Pantalón clásico: $160.000
- Chaleco: $90.000
- Forro en seda: $70.000
- Bordado: $35.000

Tela, saco y pantalón son obligatorios. Los demás son opcionales.

## Requisitos
- Implementar Builder para construir el traje gradualmente.
- Permitir opciones obligatorias y opcionales.
- Usar Streams para calcular el total.
- Mostrar descripción, piezas y precio final.

## README
Documentar categoría, patrón, justificación y clases/roles.

---

# Reto 3 — La Fábrica de Instrumentos

## Patrones recomendados
Usar patrones creacionales adecuados para separar **familia** y **gama**. Antes de implementar, Codex debe justificar la elección en función de la estructura existente. Una solución posible puede combinar Factory Method / Abstract Factory, siempre que la implementación represente correctamente el problema.

## Familias y precios base

### Cuerda
- Guitarra: $800.000
- Violín: $1.600.000
- Bajo: $1.200.000

### Viento
- Saxofón: $2.500.000
- Flauta: $700.000
- Trompeta: $1.500.000

### Percusión
- Batería: $1.800.000
- Cajón: $350.000
- Timbal: $600.000

## Gamas
- Estudiante: factor 1.0, materiales básicos, 440 Hz.
- Profesional: factor 3.0, maderas selectas, 440 Hz.
- Vintage: factor 5.0, piezas de época, 442 Hz.

## Requisitos
- Crear instrumentos según familia y gama.
- Permitir X instrumentos.
- Precio = precio base × factor de gama.
- Usar Streams para total del pedido.
- Mostrar resumen individual y total.

## README
Documentar patrón utilizado y su aplicación.

---

# Reto 4 — La Balanza Trucada del Mercado

## Objetivo
Convertir cualquier unidad de peso soportada a cualquier otra.

## Unidades
- Gramo (`g`): 1 kg = 1000 g.
- Libra (`lb`): 1 kg = 2.2046 lb.
- Arroba (`@`): 1 kg = 0.08 @.
- Kilogramo (`kg`): unidad base.

## Requisitos
- Aceptar cualquier par de conversión.
- Procesar X pesajes.
- Mostrar valor original y convertido.
- Usar Streams para sumar pesajes y obtener el total equivalente en kg.

## Patrón
Seleccionar un patrón de diseño coherente con estrategias/adaptación de conversiones y justificarlo en README. No forzar un patrón que complique innecesariamente la solución.

---

# Reto 5 — La Moto Personalizada

## Patrón recomendado
**Decorator — Estructural.**

## Moto del ejemplo
- Naked 250: $9.800.000

## Mejoras
- Escape deportivo: +$1.400.000
- Manillar deportivo: +$480.000
- Luces LED: +$350.000
- Alforjas laterales: +$600.000
- Mate negro: +$900.000
- Metalizado tricapa: +$1.600.000
- Vinilo personalizado: +$700.000
- GPS integrado: +$1.100.000
- Baúl trasero: +$550.000
- Sistema de sonido: +$820.000

## Requisitos
- Elegir X mejoras.
- Poder agregar nuevas mejoras sin modificar la moto base.
- Respetar Open/Closed Principle.
- Mostrar descripción completa y precio.
- Usar Streams cuando existan varias motos o mejoras para el total general.

## README
Documentar Decorator, categoría, justificación y roles.

---

# Reto 6 — Sala de Urgencias

## Patrón recomendado
**Chain of Responsibility — Comportamiento.**

## Cadena
1. Enfermero: Leve / prioridad Baja (1)
2. Médico General: Moderado / prioridad Media (2)
3. Especialista: Grave / prioridad Alta (3)

También puede llegar un nivel no atendible, como Crítico.

## Requisitos
- Procesar X pacientes.
- Paciente: síntoma, nivel y prioridad.
- Cada profesional intenta atender y, si no corresponde, remite al siguiente.
- Si nadie puede atenderlo, remitir a otra institución.
- Streams para estadísticas por nivel, remitidos y promedio de prioridad.

## README
Documentar Chain of Responsibility y roles de la cadena.

---

# Reto 7 — El Rover Explorador de Marte

## Patrón recomendado
**Command — Comportamiento.**

## Módulos
- Motor: avanzar / retroceder, parámetro metros.
- Brazo: recoger / soltar.
- Cámara: grabar / detener, parámetro segundos (0–120).
- Taladro: perforar / retraer, parámetro profundidad en cm.

## Requisitos
- Ejecutar X acciones.
- Registrar operador de cada acción.
- Mantener historial completo.
- Permitir `undo` de cualquier acción individual.
- Marcar acciones deshechas en historial.
- Mostrar resumen final con acción y operador.

## README
Documentar Command y el rol de Command, ConcreteCommand, Receiver e Invoker según la solución implementada.

---

# Reto 8 — La Academia de Fútbol de los UML

## Temas
SOLID, patrones y UML.

## Entidades principales

### Jugador
Atributos:
- nombre
- edad
- dorsal
- posición
- pie hábil
- peso
- altura
- estado físico
- categoría

Métodos:
- `patear()`
- `entrenar()`

Debe existir herencia/polimorfismo:
- Arquero
- Defensa
- Delantero

### Entrenador
Atributos:
- nombre
- edad
- especialidad
- jugadores asignados

Métodos:
- `dirigir(jugador)`
- `evaluar(jugador)`
- `planearSesion(jugador)`

### Hincha
Atributos:
- nombre
- edad
- jugadores favoritos
- camisetas

Métodos:
- `animar(jugador)`
- `pedirAutografo(entrenador)`
- `publicarFoto(jugador)`

## Relaciones UML
- Herencia: Jugador → Arquero, Defensa, Delantero.
- Entrenador ↔ Jugador: un entrenador puede tener N jugadores.
- Hincha relacionado con Jugador y Entrenador.
- Atributos privados y getters/setters.
- Métodos relevantes visibles en UML.

## Atributos dinámicos
Agregar mediante un patrón de diseño:
- posición secundaria
- país de origen
- historial de lesiones
- valor de mercado

## Entregables
- Implementación correspondiente.
- Explicación SOLID en README.
- Patrón de diseño y justificación.
- Diagrama UML completo.
- Exportar UML como PDF o PNG en `docs/uml/`.

---

# Estructura de ejecución

La clase principal debe mantenerse limpia, aproximadamente:

```java
public class Application {
    public static void main(String[] args) {
        Reto1BoleteriaAstor.ejecutar();
        Reto2SastreMedida.ejecutar();
        // ...
    }
}
```

La lógica real debe estar dentro de cada reto, no en `main`.

---

# Checklist obligatorio de entrega

Para **todos los retos**:
- Código implementado en la rama del equipo.
- Compilación correcta.
- Ejecución comprobada.
- Captura de consola en README.
- Ambos integrantes deben tener commits dentro de cada reto.

Para **retos 2–7**:
- Categoría del patrón.
- Nombre exacto.
- Justificación.
- Explicación de clases involucradas y sus roles.

Para **retos 1 y 8**:
- Explicar SOLID indicando principio, ubicación y forma de aplicación.

Para **reto 8**:
- UML exportado como PDF o PNG en `docs/uml/`.

---

# Flujo que Codex debe seguir al trabajar

Cuando se le pida implementar un reto:

1. Inspeccionar primero el proyecto actual.
2. Identificar paquete, convenciones y configuración.
3. Proponer brevemente las clases necesarias y el patrón.
4. Implementar únicamente el reto solicitado.
5. Integrarlo con `Application.java` sin ensuciar `main`.
6. Compilar.
7. Corregir errores de compilación.
8. Ejecutar el reto.
9. Comparar la salida con el ejemplo del enunciado.
10. Crear/actualizar el README del reto.
11. Informar qué archivos fueron creados/modificados.
12. Indicar qué debe comprobar manualmente el estudiante.
13. No hacer commits automáticamente salvo que el usuario lo solicite explícitamente.
