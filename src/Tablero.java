//Nombre del programa: Tablero.java
//Clase para la creacion de la instancia correspondiente al tablero, necesario para el desarrollo de las partidas del juego TicTacToe.
//Autor: Jimer Orlando Díaz Murillo
//Fecha: 25 Septiembre 2025
import java.util.Arrays;

public class Tablero {

    //Atributos

    //Arreglo del juego
    private final int[] TABLERO = new int[9];
    private int estadoTablero; //0: Tablero continua en juego, 1: Se ha realizado una linea, 2: Ha ocurrido un empate
    //Variable que almacena la cantidad de movimientos realizados en una partida
    private int movimientos;
    //Arreglo para revisar si se ha realizado una linea
    private final int[][] REVISAR_LINEA = {
            {0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}
    };
    //Arreglo para imprimir fichas en tablero
    private final String[][] FICHAS = {
            //Celda sin ficha
            {
                "       ","       "
            },
            //Ficha 1
            {
                "X     X","   X   "
            },
            //Ficha 2
            {
                "0  0  0","0     0"
            }

    };

    //Constructor
    public Tablero(){

        //Se inicia TABLERO con campos vacios
        Arrays.fill(TABLERO,0);
        estadoTablero = 0;
        movimientos = 0;
    }

    //Metodo get
    public int getEstadoTablero() {
        return estadoTablero;
    }

    //Metodo que registra un movimiento en el tablero
    public boolean registrarMovimiento(int ficha, int posicion){

        //Verifica si la posicion en el tablero esta disponible
        if ((TABLERO[posicion] == 0)){

            TABLERO[posicion] = ficha;

            //Se incrementa el numero de movimientos realizados en el tablero
            movimientos++;

            //Verificacion para empezar a revisar si se gana o empata.
            if(movimientos>4){

                //Se revisa si se ha ganado
                for (int[] linea:REVISAR_LINEA){

                    if(TABLERO[linea[0]] == ficha && TABLERO[linea[1]] == ficha && TABLERO[linea[2]] == ficha){
                        estadoTablero = 1;
                        return true;
                    }

                }

                //Se revisa si se ha empatado
                if (movimientos == 9){
                    estadoTablero = 2;
                }

            }

            return true;

        }else{

            System.out.println("La posicion esta ocupada.");
            return false;

        }
    }

    //Metodo que reinicia el tablero para jugar una nueva partida
    public void reiniciarTablero(){

        Arrays.fill(TABLERO,0);
        estadoTablero = 0;
        movimientos = 0;
    }

    //Metodo toString con instrucciones necesarias para imprimir visualmente el tablero
    @Override
    public String toString(){

        StringBuilder tableroVisual = new StringBuilder();

        tableroVisual.append(contruirCeldas(TABLERO[0],TABLERO[1],TABLERO[2]));
        tableroVisual.append("*  *  *  *  *  *  *  *  *  *  *\n");
        tableroVisual.append(contruirCeldas(TABLERO[3],TABLERO[4],TABLERO[5]));
        tableroVisual.append("*  *  *  *  *  *  *  *  *  *  *\n");
        tableroVisual.append(contruirCeldas(TABLERO[6],TABLERO[7],TABLERO[8]));

        return tableroVisual.toString();

    }

    //Metodo para construir las filas de las fichas
    private String contruirCeldas(int izquierda, int medio, int derecha){

        StringBuilder celdas = new StringBuilder();

        celdas.append(FICHAS[izquierda][0]).append("  *  ").append(FICHAS[medio][0]).append("  *  ").append(FICHAS[derecha][0]).append("\n");
        celdas.append(FICHAS[izquierda][1]).append("  *  ").append(FICHAS[medio][1]).append("  *  ").append(FICHAS[derecha][1]).append("\n");
        celdas.append(FICHAS[izquierda][0]).append("  *  ").append(FICHAS[medio][0]).append("  *  ").append(FICHAS[derecha][0]).append("\n");

        return celdas.toString();
    }
}
