package pt.ulusofona.lp2.deisiJungle;

public class Passaro extends Especie{
    public Passaro(char identifier) {
        super(identifier);
        name = "Pássaro";
        image = "bird.png";
        startEnergy = 70;
        energyConsumption = 4;
        energyGain = 50;
        //speed = ; 5..6
    }

}
