package Models;

public class Piedra extends Jugada {
    @Override
    public String comparar(Jugada jugada) {
        if (jugada instanceof Piedra)
            return "Empate";
        else if (jugada instanceof Tijera)
            return "Ganaste";

        else return "Perdiste";
    }
}
