package Models;

public class Papel extends Jugada{
    @Override
    public String comparar(Jugada jugada) {
        if (jugada instanceof Papel)
            return "Empate";
        else if (jugada instanceof Piedra)
            return "Ganaste";

        else return "Perdiste";
    }
}
