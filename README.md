# Tic Tac Toe

## Resumen

Juego de tres en raya para dos personas, ejecutado en la consola. Los jugadores compiten en una serie de partidas y el primero en alcanzar 10 puntos gana la serie. Después, el ganador puede continuar jugando contra un nuevo retador.

## Características

- Permite ingresar los nombres de los jugadores.
- Cada jugador elige una ficha: `X` o `0`.
- Muestra el tablero en la consola y solicita una posición del 1 al 9.
- Valida que la posición elegida esté disponible.
- Detecta victorias y empates.
- Lleva el puntaje y las estadísticas de cada jugador.
- Permite que el ganador de una serie se enfrente a nuevos retadores.
- Muestra el historial de jugadores al terminar.

## Requisitos

- Java JDK instalado y disponible en la terminal (`java` y `javac`).

No se requieren bibliotecas externas. Todos los archivos fuente están en `src`.

## Uso

Desde la carpeta raíz del proyecto, compila las clases:

```bash
javac -d out src/*.java
```

En Windows también puedes ejecutar el comando anterior desde PowerShell o el Símbolo del sistema.

Inicia el juego:

```bash
java -cp out Main
```

Sigue las indicaciones de la consola:

1. Ingresa el nombre del primer jugador y luego el del segundo.
2. El primer jugador elige `1` para `X` o `2` para `0`.
3. En cada turno, selecciona una celda del `1` al `9`. Las posiciones corresponden a las celdas en orden de lectura, de izquierda a derecha y de arriba abajo.
4. Continúa hasta que haya tres fichas iguales en línea o se ocupen las nueve celdas.
5. Al finalizar cada partida se actualiza el puntaje: una victoria suma 5 puntos, una derrota resta 3 y un empate no modifica el puntaje. La serie termina cuando un jugador alcanza 10 puntos.
6. Al terminar la serie, responde si deseas continuar. Si continúas, ingresa el nombre del nuevo retador.

Al salir, el programa imprime el historial de jugadores con sus partidas jugadas, victorias, derrotas y empates.