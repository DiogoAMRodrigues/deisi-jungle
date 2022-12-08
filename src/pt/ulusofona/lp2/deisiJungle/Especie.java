package pt.ulusofona.lp2.deisiJungle;

public abstract class Especie {
    protected char identifier;
    protected String name;
    protected String image;
    protected int startEnergy; //Max 200 never surpass 200
    protected int energyConsumption;
    protected int energyGain;
    protected int minSpeed;
    protected int maxSpeed;

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

    public int getMinSpeed() {
        return minSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
