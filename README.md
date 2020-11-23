# Proyecto Hibernate Fútbol Java

Crear con hibérnate un proyecto en el que se mapeará la siguiente base de datos llamada **futboldb**.

Tener en cuenta que los nombres de las tablas y de los campos, así como los tipos de datos en las tablas deberán ser los aquí indicados y las relaciones también. El campo **codEquipo** de la tabla equipos es autonumérico.

Entre la tabla **equipos** y **equiposObservaciones** la relación es uno a uno. Podrá ocurrir que un equipo no tenga su observación asociada. El resto de relaciones son uno a muchos y de muchos a unos.

![](https://github.com/Ayoamaro/Proyecto_HibernateJava/blob/main/docs/images/diagrama.png?raw=true)

Añade al proyecto una opción con las inserciones de registros de todas las tablas.

Realizar inserciones, eliminaciones y actualizaciones de equipos, y de los contratos que les asignamos a las equipos. Deberá permitir equipos con observaciones y sin ella.

Realizar las siguientes consultas:

- Visualizar todos los equipos con todos sus datos incluyendo las observaciones del que tenga.
- Visualizar todos los equipos y sus contratos, incluyendo los datos de los futbolistas y la liga en los que están esos equipos.
