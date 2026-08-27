# La Academia de Fútbol de los UML - Documentación Arquitectónica

- **Patrón de Diseño:** Estructural
- **Patrón Utilizado:** Decorator
- **Justificación:** Se requería agregar atributos dinámicos a los jugadores (posición secundaria, país de origen, historial de lesiones, valor de mercado) sin alterar la clase base `Player`. El uso del patrón Decorator permite añadir estas propiedades envolviendo el objeto original en tiempo de ejecución. Esto garantiza el cumplimiento del Principio de Abierto/Cerrado (OCP), evitando una explosión combinatoria de subclases (por ejemplo, evitar crear `ForwardConValorDeMercadoYLesiones`), y facilita extender el sistema en el futuro.
- **Cómo lo apliqué:**
    - `Player` actúa como el Componente base (abstracto).
    - `GoalKeeper`, `Defender` y `Forward` son los Componentes Concretos.
    - `PlayerDecorator` es la clase abstracta envoltorio que hereda de `Player` y delega las operaciones base (`kick()`, `train()`) a la instancia encapsulada.
    - `MarketValueDecorator` (y futuros decoradores) heredan de `PlayerDecorator`, añadiendo estado específico (como `marketValue`) y sus respectivos métodos de acceso. Las clases externas como `Coach` interactúan con los decoradores gracias al Principio de Sustitución de Liskov (LSP).

### Principios SOLID Aplicados

- **Single Responsibility Principle (SRP):** Cada clase maneja una única responsabilidad. Coach encapsula la lógica de dirección técnica, Fan administra las interacciones de la hinchada, y la jerarquía de Player se encarga de mantener el estado y los comportamientos intrínsecos de los futbolistas.
- **Open/Closed Principle (OCP):** Aplicado directamente gracias al patrón Decorator. La interfaz o clase base Player está cerrada para modificaciones, pero abierta para su extensión. Se pueden incorporar los atributos dinámicos exigidos (historial de lesiones, país de origen, etc.) agregando nuevas clases decoradoras sin alterar el código original.
- **Liskov Substitution Principle (LSP):** Garantizado a través de la herencia de posiciones y el polimorfismo. Clases cliente como Coach o Fan que reciben un parámetro del tipo Player funcionan sin inconvenientes ni condicionales especiales sin importar si se les inyecta un GoalKeeper, un Forward, o un jugador envuelto en un MarketValueDecorator.