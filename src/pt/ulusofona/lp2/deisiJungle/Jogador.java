package pt.ulusofona.lp2.deisiJungle;

public class Jogador {
    int id;
    String name;
    Especie species;
    private int position;
    private int energy;
    private boolean finished;
    private boolean outOfEnergy;

    public Jogador(int id, String name, Especie species, int energy) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.position = 0;
        this.energy = energy;
        this.outOfEnergy = false;
    }

    void loseEnergy(){
        if (this.energy >= 2){
            this.energy -= 2;
        }else {
            this.outOfEnergy = true;
        }

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(Especie species) {
        this.species = species;
    }

    public boolean isOutOfEnergy() {
        return outOfEnergy;
    }

    public void setOutOfEnergy(boolean outOfEnergy) {
        this.outOfEnergy = outOfEnergy;
    }
}
