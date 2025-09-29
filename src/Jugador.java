public class Jugador {

    //Atributos
    private String nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
    }

    public boolean jugar(Tablero tablero, int posicion){

        return tablero.actualizar(ficha,posicion);
    }

    @Override
    public String toString(){

        return "Nombre: "+nombre+"\n"+"Cantidad de adversarios: "+adversarios+"\n"+"Partidas jugadas: "+totalPartidas+"\n"+"Victorias: "+totalVictorias+"\n"+"Derrotas: "+totalDerrotas+"\n"+"Empates: "+totalEmpates+"\n";
    }
}
