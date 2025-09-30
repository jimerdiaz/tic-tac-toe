import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Jugador jugadorActual,jugador1,jugador2;
        int posicion;
        boolean estadoSerie = false, juego = false;
        String nombre;
        int ficha, continuar;
        ArrayList<Jugador> jugadores = new ArrayList<>();

        System.out.println("Juego del Gato");
        Tablero tablero = new Tablero();

        System.out.println("Ingrese el nombre para el Jugador:");
        nombre = Keyboard.readString();

        jugadorActual = new Jugador(nombre);
        jugadores.add(jugadorActual);

        do{

            jugador1 = jugadorActual;

            System.out.println("Ingrese el nombre para el Jugador:");
            nombre = Keyboard.readString();

            jugador2 = new Jugador(nombre);
            jugadores.add(jugador2);

            System.out.println("Ingrese el numero correspondiente a la ficha que desea usar (1 o 2):\n1: X     X   2: 0  0  0\n      X         0     0\n   X     X      0  0  0");
            ficha = Keyboard.readInt();

            jugador1.setFicha(ficha);
            jugador2.setFicha(ficha == 1? 2:1);

            do{

                do{

                    System.out.println(tablero);

                    do {
                        System.out.println("Seleccione una celda 1-9");
                        posicion = Keyboard.readInt();
                    }while (!jugadorActual.jugar(tablero,posicion));

                    if(tablero.getEstadoTablero() == 0){
                        jugadorActual = jugadorActual==jugador1? jugador2:jugador1;
                    }

                }while (tablero.getEstadoTablero()==0);

                System.out.println(tablero);

                if(tablero.getEstadoTablero() == 1){
                    jugadorActual.ganar();
                    if (jugadorActual == jugador1) {
                        jugador2.perder();
                    } else {
                        jugador1.perder();
                    }

                    if (jugadorActual.getPuntaje()>= 10){
                        estadoSerie = true;
                    }
                }else{
                    System.out.println("Empate!! Se reinicia la partida");
                    jugador1.empatar();
                    jugador2.empatar();
                }

                tablero.reiniciarTablero();

                System.out.println("Nombre: "+jugador1.getNombre() + ", Puntaje: "+jugador1.getPuntaje());
                System.out.println("Nombre: "+jugador2.getNombre() + ", Puntaje: "+jugador2.getPuntaje());

            }while(!estadoSerie);

            System.out.println("El ganador de la serie es: "+jugadorActual.getNombre());
            System.out.println("¿Continuar con el juego? 1: Si  2: No");
            continuar = Keyboard.readInt();
            if (continuar == 2) {
                juego = true;
            }else{
                jugadorActual.setPuntaje(0);
                estadoSerie = false;
            }


        }while(!juego);

        System.out.println("Historial Jugadores");

        for (Jugador jugador : jugadores){
            System.out.println(jugador);
        }
    }
}