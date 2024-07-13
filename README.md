# ApiCursosSpringBoot
Api creada como ejercicio practico en el curso de Java Spring Boot en todo Code, esta permite:

## Crear temas y asociar a un curso 
  Podes crear un Tema mediante una peticion POST a "tema/crear" y luego crear un Curso o editar uno creado.

## Crear un nuevo curso 
  Mediante una peticion POST a "/curso/crear" enviando un objeto curso.

## Modificar los datos de un curso 
  Podes hacer de 2 formas :
  - Mediante una peticion PUT a "/curso/editar/{id_actual}" enviando el id del objeto y los datos del objeto que se desean modificar.
  - Mediante una peticion PUT a "/curso/editar" enviando un objeto curso con el mismo ID del objeto que se quiera editar.

## Obtener todos los cursos 
  Puede realizarse mediante una peticion GET a "/curso/traer".

## Obtener todos los temas de un determinado curso 
  Si haces una peticion GET a "/curso/traer/{id}" te traera la lista de temas que contenga el curso del id ingresado.

## Obtener todos los cursos que contengan como nombre la palabra “Java” (puede contener otras palabras, por ejemplo, Introducción a Java, Java avanzado, Java para principiantes, etc). 
  Con una peticion GET a "/curso/traer/java" traera todos los cursos que contengan en su nombre la palabra "Java".

