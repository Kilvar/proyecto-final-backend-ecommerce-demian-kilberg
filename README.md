
# Proyecto final Talento Tech: Tienda Online

API Rest MVC hecha en Spring Framework para el curso de back-end de Talento Tech. La aplicacion consiste en un servidor web que maneja solicitudes en formato JSON para la gestion de productos y pedidos de una tienda online.


## Caracteristicas

- Gestion de productos
- Creacion de pedidos con estado actualizable
- Registro de usuarios y sus pedidos realizados
- Almacenamiento en Base de datos en memoria
- Respuestas del servidor personalizadas

## Datos de ejemplo

La aplicacion contiene un archivo `example_data.sql` dentro de la carpeta 'resources' con algunos registros por defecto para demostrar el funcionamiento de la base. Si no se desean utilizar estos datos, se pueden comentar las siguientes lineas en `application.properties`:

```
spring.sql.init.data-locations=classpath:/example_data.sql
spring.jpa.defer-datasource-initialization=true
```
## Correr la aplicacion

Clonar el proyecto

```bash
  git clone https://github.com/Kilvar/proyecto-final-backend-ecommerce-demian-kilberg
```

Abrir con un IDE de Java (intelliJ, Eclipse, etc) y correr la aplicacion desde la clase `com.talentotech/final_ecommerce.FinalEcommerceApplication.java`

Mientras la aplicacion este activa, se aceptaran solicitudes a la API, en la direccion por defecto `localhost:8080`




## Tecnologias utilizadas

**Framework**: Spring Boot, Spring Web

**Base de Datos relacional**: Hibernate, H2


**Anotaciones**: Lombok

