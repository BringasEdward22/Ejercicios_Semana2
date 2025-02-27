package Models;

public class Tijera extends Jugada {
    @Override
public String comparar(Jugada jugada) {
    if (jugada instanceof Tijera)
        return "Empate";
    else if (jugada instanceof Papel)
        return "Ganaste";

    else return "Perdiste";
    }
}
