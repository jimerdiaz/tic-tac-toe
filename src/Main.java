//Nombre del programa: Main.java
//Clase Main para jugar TicTacToe permitiendo el ingreso de un nuevo jugador para reemplazar al jugador que pierde por puntuacion e iniciar una nueva serie de partidas.
//Autor: Jimer Orlando Díaz Murillo
//Fecha: 29 Septiembre 2025
import java.util.ArrayList;

public class Main {

    //Metodo para capturar por teclado un valor int comprendiendo un rango de numeros determinado.
    public static int asignarInt(int inicioRango, int finRango){

        int numero;

        do{

            numero = Keyboard.readInt();

            if(numero < inicioRango || numero > finRango)
                System.out.println("Debe ser un numero en el rango de " + inicioRango + " a " + finRango + ". Por favor ingrese otro numero:");

        }while(numero < inicioRango || numero > finRango);

        return numero;

    }

    //Metodo main
    public static void main(String[] args) {

        //Variables boolean para controlar el termino de las series y del juego
        boolean continuarSerie = true, continuarJuego = true;
        //Variables para control de jugadores y turnos
        Jugador jugadorActual,jugadorEnEspera,auxiliarCambio;
        //Lista para almacenar registro de jugadores
        ArrayList<Jugador> jugadores = new ArrayList<>();

        System.out.println("Juego del Gato");
        Tablero tablero = new Tablero();

        System.out.println("Ingrese el nombre del Jugador que ira primero:");
        jugadorActual = new Jugador(Keyboard.readString());
        jugadores.add(jugadorActual);

        do{//Ciclo del juego

            System.out.println("Ingrese el nombre del Jugador que ira segundo:");
            jugadorEnEspera = new Jugador(Keyboard.readString());
            jugadores.add(jugadorEnEspera);

            //Asignacion de fichas
            System.out.println(jugadorActual.getNombre()+" ingrese el numero correspondiente a la ficha que desea usar (1 o 2):\n1: X     X   2: 0  0  0\n      X         0     0\n   X     X      0  0  0");
            int ficha = asignarInt(1, 2);

            jugadorActual.setFicha(ficha);
            //La otra ficha se asigna al otro jugador
            jugadorEnEspera.setFicha(ficha == 1? 2:1);

            //Ciclo de la serie
            do{

                //Ciclo de las partidas
                do{

                    //Se imprime tablero en curso
                    System.out.println(tablero);

                    do {
                        System.out.println(jugadorActual.getNombre()+" seleccione una celda 1-9");
                    }while (!tablero.registrarMovimiento(jugadorActual.getFicha(),asignarInt(1, 9)-1));

                    //Se cambia de turno sí el tablero sigue en juego
                    if(tablero.getEstadoTablero() == 0){
                        auxiliarCambio = jugadorActual;
                        jugadorActual = jugadorEnEspera;
                        jugadorEnEspera = auxiliarCambio;
                    }

                }while (tablero.getEstadoTablero()==0);//Continua mientras el tablero siga en juego

                System.out.println(tablero);//Se imprime en pantalla el resultado de la partida

                if(tablero.getEstadoTablero() == 1)//Se establece el jugador que gana y el que pierde
                {
                    jugadorActual.ganar();
                    jugadorEnEspera.perder();

                    if (jugadorActual.getPuntaje()>= 10)//Se valida si el ganador ya consiguio los puntos necesarios para terminar la serie
                    {
                        continuarSerie = false;
                    }
                }else//Se establece un empate
                {
                    System.out.println("Empate!! Se reinicia la partida");
                    jugadorActual.empatar();
                    jugadorEnEspera.empatar();
                }

                tablero.reiniciarTablero();

                //Se imprime puntaje al momento
                System.out.println("Puntaje actual: ");
                System.out.println(jugadorActual.getNombre() + " Puntaje: "+jugadorActual.getPuntaje());
                System.out.println(jugadorEnEspera.getNombre() + " Puntaje: "+jugadorEnEspera.getPuntaje());

            }while(continuarSerie);//Continua mientras no se consigan los puntos necesarios para ganar la serie por parte de alguno de los jugadores

            System.out.println("El ganador de la serie es: "+jugadorActual.getNombre());
            System.out.println("¿Continuar con el juego? 1: Si  2: No");
            if (asignarInt(1, 2) == 2) {
                continuarJuego = false;
            }else{
                //Se prepara datos de jugador ganador para enfrentar al nuevo jugador
                jugadorActual.setPuntaje(0);
                jugadorActual.incrementarAdversarios();
                //Se inicia nueva serie
                continuarSerie = true;
            }

        }while(continuarJuego);//Continua mientras se desee seguir jugando enfrentando nuevos jugadores

        //Se imprime historial
        System.out.println("Historial Jugadores");

        for (Jugador jugador : jugadores){
            System.out.println(jugador);
        }
    }
}