import java.util.Arrays;

public class Tablero {

    //Atributos
    private final int[] TABLERO = new int[9];
    private int estadoTablero, movimientos;
    private final int[][] REVISAR_LINEA = {
            {0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}
    };
    private final String[][] FICHAS = {
            {
                "       ","       "
            },
            {
                "X     X","   X   "
            },
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

    public int getEstadoTablero() {
        return estadoTablero;
    }

    //Metodo que actualiza el tablero
    public boolean actualizar(int ficha, int posicion){

        if ((TABLERO[posicion] == 0)){

            TABLERO[posicion] = ficha;
            movimientos++;

            if(movimientos>4){

                //Se revisa si se ha ganado
                for (int[] linea:REVISAR_LINEA){

                    if(TABLERO[linea[0]] == ficha && TABLERO[linea[1]] == ficha && TABLERO[linea[2]] == ficha){
                        estadoTablero = 1;
                        return true;
                    }

                }

                //Empate
                if (movimientos == 9){
                    estadoTablero = 2;
                }

            }

            return true;

        }else{

            return false;

        }
    }

    public void reiniciarTablero(){

        Arrays.fill(TABLERO,0);
        estadoTablero = 0;
        movimientos = 0;
    }

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

    private String contruirCeldas(int izquierda, int medio, int derecha){

        StringBuilder celdas = new StringBuilder();

        celdas.append(FICHAS[izquierda][0]).append("  *  ").append(FICHAS[medio][0]).append("  *  ").append(FICHAS[derecha][0]).append("\n");
        celdas.append(FICHAS[izquierda][1]).append("  *  ").append(FICHAS[medio][1]).append("  *  ").append(FICHAS[derecha][1]).append("\n");
        celdas.append(FICHAS[izquierda][0]).append("  *  ").append(FICHAS[medio][0]).append("  *  ").append(FICHAS[derecha][0]).append("\n");

        return celdas.toString();
    }
}
