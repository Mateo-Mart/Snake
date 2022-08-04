
# TRABAJANDO CON ESTRUCTURAS DINÁMICAS

En esta práctica se modifica alguna de las estructuras dinámicas de datos vistas en clase para implementar el juego de la serpiente.

   
## Enunciado

El juego consiste en mover una serpiente por un tablero de celdas, de forma aleatoria aparece comida en el tablero. La serpiente al pasar por encima se "come" la comida, aumenta en uno la longitud de su longitud e incrementa en uno su puntuación.

![image](https://github.com/pass1enator/DAWSnakeTemplate/blob/master/src/main/resources/resuelto.png?raw=true)

Se proporciona al alumno/a la estructura básica del proyecto, en el que se proporcionan clase auxiliares como Size, Coordenada o Direction, otras como Game y Snake, este código simplemente mueve un cuadrado por el tablero sin hacer ninguna comprobación.

A partir de este codigo y del diagrama UML que se proporciona crear las clases necesarias para que:
   - Aparezca comida en el tablero de forma aleatoria.
   - Se controle que la serpiente no sale del campo.
   - La serpiente no puede pasar sobre si misma
   - Cuando la serpiente coma una fruta, la serpiente crezca.
   - El cuerpo de la serpiente se mueve siguiendo a la cabeza.
   - Al salir del campo o "morderse" el juego se ha de parar y esperar a pulsar el espacio para reiniciar.
 
El objetivo principal de la práctia es que la clase Snake poseea una estructura de datos dinámica de las que se facilitan en los apuntes (pila, listas o cola) y se modifique para poder cumplir con el enunciado. **NO ES POSIBLE USAR ESTRUCTURAS DINÁMICAS DE JAVA**

![image](https://github.com/pass1enator/DAWSnakeTemplate/blob/master/src/main/resources/uml.png?raw=true)
