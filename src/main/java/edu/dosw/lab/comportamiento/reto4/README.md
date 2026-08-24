### Documentación - Solución del ejercicio "La Balanza Trucada del Mercado"

*   **Categoría:** Comportamiento
*   **Patrón Utilizado:** Strategy
*   **Justificación:** El sistema requiere convertir múltiples unidades dinámicamente y debe ser fácil de escalar en el futuro. Strategy permite encapsular el algoritmo de conversión de cada unidad en su propia clase, eliminando la necesidad de condicionales anidados (como un bloque switch gigante) y cumpliendo estrictamente con el principio Open/Closed.

*   **Cómo lo apliqué:**
    *   IConversionStrategy: Interfaz común que define el puente bidireccional hacia la unidad base (Kilos).
    *   PoundStrategy (y análogas): Implementaciones concretas que contienen el factor matemático aislado.
    *   Weighting: Clase de tipo record para asegurar el encapsulamiento y la inmutabilidad de los pesajes.
    *   WeightConverter: Clase principal que orquesta la operación, delegando el cálculo a la estrategia correspondiente según la unidad seleccionada.
