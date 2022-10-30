package pt.ulusofona.lp2.deisiJungle;

public class Jogador {
    int id; //Não pode existir a msma id
    String name;
    Especie species; //Só pode existir um Tarzan
    private int position;
    private int energy;
    private boolean finished;

    public Jogador(int id, String name, Especie species, int energy) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.position = 0;
        this.energy = energy;
    }

    void loseEnergy(){
        this.energy -= 2;
    }

    void move(int amount){
        this.position += amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Especie getSpecies() {
        return species;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
