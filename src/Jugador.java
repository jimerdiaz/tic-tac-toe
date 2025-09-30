//Nombre del programa: Jugador.java
//Clase para la creacion de la instancia correspondiente al jugador, necesaria para llevar sus registros y proceso en TicTacToe.
//Autor: Jimer Orlando Díaz Murillo
//Fecha: 29 Septiembre 2025
public class Jugador {

    //Atributos
    private final String nombre;
    private int adversarios, totalPartidas, totalVictorias, totalDerrotas, totalEmpates, puntaje, ficha;

    //Constructor
    public Jugador(String nombre){

        this.nombre = nombre;
        adversarios = 1;
        totalPartidas = 0;
        totalVictorias = 0;
        totalDerrotas = 0;
        totalEmpates = 0;
        puntaje = 0;
    }

    //Metodos get
    public String getNombre() {
        return nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getFicha() {
        return ficha;
    }

    //Metodos set
    public void setFicha(int ficha) {
        this.ficha = ficha;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    //Metodo que incrementa en 1 el registro de la cantidad de adversarios
    public void preparar() {
        adversarios++;
        puntaje = 0;
    }

    //Metodo que registra una victoria del jugador
    public void ganar(){
        puntaje += 5;
        totalPartidas++;
        totalVictorias++;
    }

    //Metodo que registra una derrota del jugador
    public void perder(){
        puntaje -= 3;
        totalPartidas++;
        totalDerrotas++;
    }

    //Metodo que registra un empate del jugador
    public void empatar(){
        totalPartidas++;
        totalEmpates++;
    }

    //Metodo toString con instrucciones necesarias para imprimir los datos del jugador
    @Override
    public String toString(){

        return "Nombre: "+nombre+"\n"+"Cantidad de adversarios: "+adversarios+"\n"+"Partidas jugadas: "+totalPartidas+"\n"+"Victorias: "+totalVictorias+"\n"+"Derrotas: "+totalDerrotas+"\n"+"Empates: "+totalEmpates+"\n";
    }
}
