//Nombre del programa: Main.java
//Clase Main para jugar TicTacToe permitiendo el ingreso de un nuevo jugador para reemplazar al jugador que pierde por puntuacion e iniciar una nueva serie de partidas.
//Autor: Jimer Orlando Díaz Murillo
//Fecha: 30 Septiembre 2025

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

    //Metodo para capturar por teclado un string.
    public static String asignarString(){

        String cadena;

        do{

            cadena = Keyboard.readString();

            if(cadena.trim().isEmpty())
                System.out.println("Porfavor no ingrese solamente espacios en blanco.");

        }while(cadena.trim().isEmpty());

        return cadena;

    }

    //Metodo main
    public static void main(String[] args) {

        Jugador jugador1, jugador2;
        boolean continuarJuego = true;

        System.out.println("Juego del Gato");

        System.out.println("Ingrese el nombre del Jugador que ira primero:");
        jugador1 = new Jugador(asignarString());

        Juego juego = new Juego(jugador1);

        System.out.println("Ingrese el nombre del Jugador que ira segundo:");
        jugador2 = new Jugador(asignarString());

        jugador1 = juego.iniciarJuego(jugador2);

        do{//Ciclo del juego

            System.out.println(jugador1.getNombre()+ " ha ganado la serie.");
            System.out.println("¿Continuar con el juego? 1: Si  2: No");
            if (asignarInt(1, 2) == 2) {
                continuarJuego = false;
            }else{

                System.out.println("Ingrese el nombre del Jugador que ira segundo:");
                jugador2 = new Jugador(asignarString());
                jugador1 = juego.retarGanador(jugador2);
            }

        }while(continuarJuego);//Continua mientras se desee seguir jugando enfrentando nuevos jugadores

        //Se imprime historial
        System.out.println("\n¡¡Gracias por jugar!!");

        juego.imprimirHistorial();
    }
}