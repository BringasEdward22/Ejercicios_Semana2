package Models;

public abstract class Jugada {
    public abstract String comparar(Jugada jugada);

    public String getNombre() {
        return this.getClass().getSimpleName();
    }
}
