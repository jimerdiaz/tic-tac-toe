
public class Main {
    public static void main(String[] args) {

        Jugador jugadorActual;
        int posicion;
        boolean movimiento;
        String nombre;
        int ficha;

        System.out.println("Juego del Gato");
        Tablero tablero = new Tablero();

        System.out.println("Ingrese el nombre para el Jugador:");
        nombre = Keyboard.readString();

        Jugador jugador1 = new Jugador(nombre);

        System.out.println("Ingrese el nombre para el Jugador:");
        nombre = Keyboard.readString();

        Jugador jugador2 = new Jugador(nombre);

        jugadorActual = jugador1;

        System.out.println("Ingrese el numero correspondiente a la ficha que desea usar (1 o 2):\n1: X     X   2: 0  0  0\n      X         0     0\n   X     X      0  0  0");
        ficha = Keyboard.readInt();

        jugador1.setFicha(ficha);
        jugador2.setFicha(ficha == 1? 2:1);

        do{

            System.out.println(tablero);
            System.out.println(tablero.movimientos);

            do {
                System.out.println("Seleccione una celda 1-9");
                posicion = Keyboard.readInt();
            }while (!jugadorActual.jugar(tablero,posicion));

            if(tablero.getEstadoTablero() == 0){
                jugadorActual = jugadorActual==jugador1? jugador2:jugador1;
            }

        }while (tablero.getEstadoTablero()==0);

        System.out.println(tablero);

        System.out.println("El ganador es: "+jugadorActual.getNombre());

        System.out.println("Historial Jugadores");
        System.out.println(jugador1);
        System.out.println(jugador2);
    }
}