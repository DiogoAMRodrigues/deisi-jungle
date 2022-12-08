package pt.ulusofona.lp2.deisiJungle;

public class Jogador {
    private final int id;
    private final String name;
    private final Especie species;
    private int position;
    private int energy;

    public Jogador(int id, String name, Especie species, int energy) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.position = 0;
        this.energy = energy;
    }

    protected void loseEnergy(){
        if (this.energy >= 2){
            this.energy -= 2;
        }
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

}
