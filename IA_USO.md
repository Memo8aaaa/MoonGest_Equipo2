Gemini Holis

Uso de Inteligencia Artificial

Herramientas utilizadas
-Gemini: Fue la herramienta de IA utilizada como apoyo durante el desarrollo del
  módulo de Notificaciones, para verificar y corregir errores de conexión.
-Claude: Fue la herramienta de IA utilizada como apoyo al momento de establecer
  la conexión con la base de datos y corrección de código general del backend.

Áreas de aplicación
1. Corrección de código
Se utilizó IA para identificar y corregir errores en el código del backend desarrollado
en Java 21 con Spring Boot, en los siguientes casos:

- Corrección de errores de sintaxis y lógica en las clases de los módulos
  (Usuarios, Clientas, Citas, y Notificaciones).
- Revisión de anotaciones de JPA como `@Entity`, `@Column`, `@Id` y `@GeneratedValue`
  para garantizar el mapeo correcto entre las clases Java y las tablas de la base de datos.
- Detección de errores en los controladores REST, como rutas mal definidas
  o métodos HTTP incorrectos.

2. Conectividad con la base de datos
Se utilizó IA para establecer y corregir la conexión entre el backend de Spring Boot
y la base de datos MySQL local:

- Configuración del archivo `application.properties` con los parámetros correctos
  de URL de conexión, usuario y contraseña.
- Resolución de errores relacionados con la conexión al servidor local.

Consideraciones
El uso de IA se limitó a funciones de apoyo y corrección. 
El diseño de la arquitectura, la lógica de negocio y
la estructura de módulos fue desarrollado por el equipo.
Su rol fue orientar y depurar el trabajo realizado.
