### Documentación - Solución del ejercicio "Sastre a la medida"

*   **Categoría:** Creacional
*   **Patrón Utilizado:** Builder
*   **Justificación:** Se eligió el patrón Builder debido a la naturaleza compleja del objeto `Suit`, el cual requiere un ensamblaje paso a paso compuesto por partes obligatorias (tela, saco, pantalón) y opcionales (chaleco, forro, bordado). Esto previene el antipatrón del constructor telescópico y la sobrecarga combinatoria inherente a los patrones Factory. Adicionalmente, el patrón garantiza la inmutabilidad y el encapsulamiento: el Builder gestiona el estado transitorio y genera una instancia de `Suit` desprovista de métodos mutadores (setters), asegurando la integridad del producto final.

*   **Cómo lo apliqué:**
    *   **`Piece` (Clase Abstracta):** Modela la estructura base compartida (`kind` y `price`) para todos los componentes, habilitando el polimorfismo y el cálculo funcional del costo total mediante la API de Streams.
    *   **Clases Concretas (`Cloth`, `Coat`, `Pants`, `Vest`, `Lining`, `Embroidery`):** Heredan de `Piece`. Sus variantes y tarifas se inyectan a través del constructor, evitando una jerarquía de clases redundante para cada opción de material o diseño.
    *   **`ISuitBuilder` (Interfaz):** Declara los métodos de construcción mediante una interfaz fluida (*Fluent Interface*) y define el contrato para obtener el producto terminado (`build()`).
    *   **`SuitBuilder` (Concrete Builder):** Implementa `ISuitBuilder`, acumula las piezas solicitadas y ejecuta la validación de negocio en el método `build()`, lanzando excepciones si faltan componentes obligatorios antes de instanciar el traje.
    *   **`Suit` (Producto):** Entidad final inmutable que almacena la colección de objetos `Piece`, calcula el total utilizando `mapToInt().sum()` y encapsula el formato de salida visual en `toString()`.
    *   **`Tailor` (Director):** Recibe la abstracción `ISuitBuilder` por inyección de dependencias, gestiona las tarifas del catálogo mediante mapas y orquesta la secuencia de construcción según las elecciones del usuario.
    *   **`Client`:** Punto de entrada que interactúa con la consola para capturar los requerimientos del usuario y delegar la construcción al `Tailor`.