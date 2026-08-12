# Laboratorio 02 – Preguntas iniciales

## 1. ¿Qué ventaja ofrece el polimorfismo en el diseño de clases frente al uso de múltiples condicionales para determinar el comportamiento de un objeto?

El polimorfismo permite que distintos objetos respondan de manera diferente a una misma operación. Esto evita el uso excesivo de condicionales, facilita la ampliación del sistema y hace que el código sea más organizado y fácil de mantener.

## 2. ¿Por qué una clase inmutable puede mejorar la seguridad en un sistema?

Una clase inmutable no permite cambiar el estado de sus objetos después de crearlos. Esto evita modificaciones accidentales o no autorizadas, reduce los efectos secundarios y hace que la información sea más segura y predecible.

## 3. ¿Qué problema podría aparecer en un sistema si los atributos de las clases se mantienen públicos en lugar de privados con getters y setters controlados?

Los atributos públicos pueden ser modificados directamente desde cualquier parte del programa, incluso con valores incorrectos. Esto rompe el encapsulamiento, dificulta aplicar validaciones y puede dejar los objetos en estados inválidos.

## 4. Según el principio Abierto/Cerrado, ¿cómo deberíamos modificar el sistema si queremos añadir una nueva funcionalidad sin alterar el código existente?

La nueva funcionalidad debería incorporarse mediante nuevas clases o implementaciones que utilicen las abstracciones existentes. Así se amplía el comportamiento del sistema sin modificar el código que ya funciona y se disminuye el riesgo de introducir errores.

## 5. ¿Por qué es importante que una clase cumpla con el Principio de Única Responsabilidad? Da un ejemplo donde se vulnere.

Es importante porque una clase debe encargarse de una sola función, lo que facilita su comprensión, mantenimiento y prueba. Por ejemplo, una clase que registra usuarios, guarda sus datos, envía correos y genera reportes vulnera este principio porque reúne varias responsabilidades diferentes.

## 6. ¿Qué es y para qué usamos el `pom.xml`?

El `pom.xml` es el archivo principal de configuración de un proyecto Maven. Se utiliza para definir los datos del proyecto, la versión de Java, las dependencias, los plugins y las instrucciones necesarias para compilar, probar y empaquetar la aplicación.

## 7. ¿Qué diferencia hay entre `mvn compile`, `mvn package` y `mvn install`?

`mvn compile` compila el código fuente; `mvn package` también ejecuta las pruebas y genera el archivo final, como un JAR; y `mvn install` realiza todo lo anterior y guarda el artefacto en el repositorio local de Maven para que pueda ser utilizado por otros proyectos.

## 8. ¿Qué diferencia existe entre una interfaz y una clase abstracta?

Una interfaz define principalmente un contrato que las clases deben cumplir, mientras que una clase abstracta puede incluir atributos, constructores y comportamientos compartidos. Además, una clase puede implementar varias interfaces, pero solamente puede heredar de una clase abstracta.
