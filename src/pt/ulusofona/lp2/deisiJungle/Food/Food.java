package pt.ulusofona.lp2.deisiJungle.Food;

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
