package pt.ulusofona.lp2.deisiJungle;

import org.w3c.dom.ranges.Range;

public abstract class Especie {
    char identifier;
    String name;
    String image;
    int startEnergy; //Max 200 never surpass 200
    int energyConsumption;
    int energyGain;
    Range speed;

    protected Especie(char identifier) { //Set all the stuff in the constructors
        switch (identifier) {
            case 'E' -> {
                this.name = "Elefante";
                this.image = "elephant.png";
            }
            case 'L' -> {
                this.name = "Leão";
                this.image = "lion.png";
            }
            case 'T' -> {
                this.name = "Tartaruga";
                this.image = "turtle.png";
            }
            case 'P' -> {
                this.name = "Pássaro";
                this.image = "bird.png";
            }
            case 'Z' -> {
                this.name = "Tarzan";
                this.image = "tarzan.png";
            }
        }
        this.identifier = identifier;
    }

    public char getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public int getStartEnergy() {
        return startEnergy;
    }

    public int getEnergyConsumption() {
        return energyConsumption;
    }

    public int getEnergyGain() {
        return energyGain;
    }

    public Range getSpeed() {
        return speed;
    }
}
