package pt.ulusofona.lp2.deisiJungle.food;
import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Tabuleiro;

public abstract class Food {
    protected char id;
    protected String img;

    public abstract int getEatenSim(Jogador player, int turn);
    public abstract String getEaten(Tabuleiro tabuleiro);

    public char getId() {
        return id;
    }
    public String getImg() {
        return img;
    }
}
