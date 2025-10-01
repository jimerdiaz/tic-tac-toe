//Nombre del programa: Jugador.java
//Clase para ejecutar el juego TicTacToe.
//Autor: Jimer Orlando Díaz Murillo
//Fecha: 30 Septiembre 2025

import java.util.ArrayList;

public class Juego {

    //Atributos
    Jugador jugadorActual,jugadorEnEspera;
    //Lista para almacenar registro de jugadores
    ArrayList<Jugador> jugadores = new ArrayList<>();

    //Constructor
    public Juego(Jugador jugador1){

        jugadorActual = jugador1;

        jugadores.add(jugadorActual);

    }

    public Jugador iniciarJuego(Jugador jugador2){

        jugadorEnEspera = jugador2;

        jugadores.add(jugadorEnEspera);

        //Asignacion de fichas
        asignarFicha();

        //Ciclo de la serie que retorna al jugador ganador
        return jugarSerie();

    }

    public Jugador retarGanador(Jugador jugador2){

        //Ganador anterior se establece como el que va primero
        jugadorActual = jugadorEnEspera;

        System.out.println(jugadorActual.getNombre()+" continua en el juego.");

        //Se prepara datos de jugador ganador para enfrentar al nuevo jugador
        jugadorActual.preparar();

        //Nuevo retador se asigna como jugadorEnEspera
        jugadorEnEspera = jugador2;

        jugadores.add(jugadorEnEspera);

        //Asignacion de fichas
        asignarFicha();

        //Ciclo de la serie que retorna al jugador ganador
        return jugarSerie();

    }

    //Metodo para asignar fichas
    public void asignarFicha(){
        System.out.println(jugadorActual.getNombre()+" ingrese el numero correspondiente a la ficha que desea usar (1 o 2):\n1: X     X   2: 0  0  0\n      X         0     0\n   X     X      0  0  0");
        int ficha = Main.asignarInt(1, 2);
        //Se asigna la ficha seleccionada a jugadorActual
        jugadorActual.setFicha(ficha);
        //La otra ficha se asigna al otro jugador
        jugadorEnEspera.setFicha(ficha == 1? 2:1);
    }

    private int jugarPartida(){

        //Se crea tablero para la partida
        Tablero tablero = new Tablero();

        do {
            //Se imprime tablero en curso
            System.out.println(tablero);

            do {
                System.out.println(jugadorActual.getNombre() + " seleccione una celda 1-9");
            } while (!tablero.registrarMovimiento(jugadorActual.getFicha(), Main.asignarInt(1, 9) - 1));

            cambioDeTurno();

        }while (tablero.getEstadoTablero()==0);//Continua mientras el tablero siga en juego

        System.out.println(tablero);//Se imprime en pantalla el resultado de la partida

        return tablero.getEstadoTablero();

    }

    public Jugador jugarSerie(){

        do {
            if(jugarPartida() == 1)//Se establece el jugador que gana y el que pierde
            {
                System.out.println("¡¡" + jugadorEnEspera.getNombre() + " gana la partida!!");
                jugadorEnEspera.ganar();
                jugadorActual.perder();
            }else//Se establece un empate
            {
                System.out.println("¡¡Empate!!");
                jugadorEnEspera.empatar();
                jugadorActual.empatar();

            }

            //Se imprime puntaje al momento
            System.out.println("Puntaje actual: ");
            System.out.println(jugadorActual.getNombre() + " Puntaje: "+jugadorActual.getPuntaje());
            System.out.println(jugadorEnEspera.getNombre() + " Puntaje: "+jugadorEnEspera.getPuntaje());

        }while(jugadorEnEspera.getPuntaje()<10);

        return jugadorEnEspera;
    }

    //Metodo para cambiar de turno
    private void cambioDeTurno(){

        Jugador auxiliarCambio = jugadorActual;
        jugadorActual = jugadorEnEspera;
        jugadorEnEspera = auxiliarCambio;

    }

    //Metodo que imprime historial
    public void imprimirHistorial(){

        System.out.println("\nHistorial Jugadores\n");

        for (Jugador jugador : jugadores){
            System.out.println(jugador);
        }
    }

}
