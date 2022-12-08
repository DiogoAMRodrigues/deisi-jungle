package pt.ulusofona.lp2.deisiJungle.Food;

import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Species.Especie;

public abstract class Food {
    protected char id;
    protected String img;

    public abstract void getEaten(Jogador player);

    public char getId() {
        return id;
    }
    public String getImg() {
        return img;
    }
}
