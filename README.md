# SweetBook

SweetBook es un proyecto desarrollado en Java utilizando el framework Spring Boot y Maven para la gestión de
dependencias. Este proyecto se centra en la gestión de libros y autores.

## Características

El proyecto incluye las siguientes características:

- **Gestión de libros**: Permite registrar libros en la base de datos. Cada libro tiene asociado un conjunto de idiomas.
  No se puede guardar el mismo libro dos veces.

- **Gestión de idiomas**: Permite registrar idiomas en la base de datos. Cada idioma puede estar asociado a varios
  libros.

- **Visualización de libros registrados**: Muestra todos los libros registrados en la base de datos.

- **Gestión de autores**: Permite registrar autores en la base de datos.

- **Visualización de autores registrados**: Muestra todos los autores registrados en la base de datos.

- **Búsqueda de autores por año**: Permite buscar autores que estaban vivos en un año específico.

- **Listado de libros por idioma**: Permite listar todos los libros disponibles en un idioma específico.

## Uso

Para utilizar este proyecto, necesitarás tener instalado Java y Maven. Una vez instalados, puedes clonar este
repositorio y ejecutar el proyecto con el siguiente comando:

```bash
mvn spring-boot:run
```

## Documentación de referencia

Para más información, por favor considera las siguientes secciones:

- [Documentación oficial de Apache Maven](https://maven.apache.org/guides/index.html)
- [Guía de referencia del plugin de Spring Boot Maven](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
- [Crear una imagen OCI](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/#build-image)
- [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.2.5/reference/htmlsingle/index.html#using.devtools)

## Guías

Las siguientes guías ilustran cómo usar algunas características concretamente:

- [Accediendo a datos con JPA](https://spring.io/guides/gs/accessing-data-jpa/)