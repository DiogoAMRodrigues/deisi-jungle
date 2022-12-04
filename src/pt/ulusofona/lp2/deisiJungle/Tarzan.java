package pt.ulusofona.lp2.deisiJungle;

public class Tarzan extends Especie{
    public Tarzan(char identifier) {
        super(identifier);
        name = "Tarzan";
        image = "tarzan.png";
        startEnergy = 70;
        energyConsumption = 2;
        energyGain = 20;
        //speed = ; 1..6
    }
}
