# Documentación del Reto: Sala de Urgencias

- **Patrón de Diseño:** Comportamiento
- **Patrón Utilizado:** Chain of Responsibility
- **Justificación:** Se requería diseñar un sistema donde múltiples profesionales de la salud evalúan secuencialmente si pueden atender a un paciente según su nivel de gravedad y prioridad. El uso de sentencias condicionales anidadas en una clase central violaría el principio Open/Closed (OCP) y el Single Responsibility Principle (SRP). *Chain of Responsibility* permite desacoplar al emisor de la solicitud (la sala de urgencias) de sus receptores, permitiendo que cada profesional actúe como un eslabón autónomo que decide si procesa el requerimiento o lo delega al siguiente en la jerarquía, facilitando la escalabilidad del sistema sin modificar el código existente.
- **Cómo lo apliqué:**
    - `Handler` (Interfaz): Define el contrato base con los métodos `setNext()` para enlazar la cadena y `handle()` para procesar o delegar.
    - `BaseHandler` (Clase Abstracta): Implementa `Handler`. Centraliza la lógica de delegación al siguiente eslabón y maneja el caso de remisión a otra institución (cuando se alcanza el final de la cadena sin ser atendido), reduciendo la duplicación de código.
    - `Nurse`, `Doctor`, `Specialist` (Manejadores Concretos): Heredan de `BaseHandler`. Cada uno implementa su regla de negocio específica en el método `handle()`. Si cumplen las condiciones de nivel y prioridad, procesan al paciente; de lo contrario, invocan la delegación de la clase padre.
    - `TreatmentResult` (Record): Estructura inmutable que retorna el estado de la atención (si fue atendido, el nivel y la prioridad) a la clase principal para habilitar el procesamiento estadístico mediante Java Streams.