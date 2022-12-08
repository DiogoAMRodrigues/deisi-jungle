package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Passaro extends Especie{
    public Passaro() {
        identifier = 'P';
        name = "Pássaro";
        image = "bird.png";
        startEnergy = 70;
        energyConsumption = 4;
        energyGain = 50;
        minSpeed = 5;
        maxSpeed = 6;
    }
}
