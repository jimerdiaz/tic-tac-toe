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

    public int getPuntaje() {
        return puntaje;
    }

    public void setFicha(int ficha) {
        this.ficha = ficha;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public boolean jugar(Tablero tablero, int posicion){

        return tablero.actualizar(ficha,posicion);
    }

    public void ganar(){
        puntaje += 5;
        totalPartidas++;
        totalVictorias++;
    }

    public void perder(){
        puntaje -= 3;
        totalPartidas++;
        totalDerrotas++;
    }

    public void empatar(){
        totalPartidas++;
        totalEmpates++;
    }

    @Override
    public String toString(){

        return "Nombre: "+nombre+"\n"+"Cantidad de adversarios: "+adversarios+"\n"+"Partidas jugadas: "+totalPartidas+"\n"+"Victorias: "+totalVictorias+"\n"+"Derrotas: "+totalDerrotas+"\n"+"Empates: "+totalEmpates+"\n";
    }
}
