package pt.ulusofona.lp2.deisiJungle;

public class Elefante extends Especie{
    public Elefante(char identifier) {
        super(identifier);
        name = "Elefante";
        image = "elephant.png";
        startEnergy = 180;
        energyConsumption = 4;
        energyGain = 10;
        //speed = ; 1..6
    }

}
