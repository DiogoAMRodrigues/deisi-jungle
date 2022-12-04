package pt.ulusofona.lp2.deisiJungle;

public class Tartaruga extends Especie{
    public Tartaruga(char identifier) {
        super(identifier);
        name = "Tartaruga";
        image = "turtle.png";
        startEnergy = 150;
        energyConsumption = 1;
        energyGain = 5;
        //speed = ; 1..3
    }
}
