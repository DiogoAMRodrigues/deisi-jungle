package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Tartaruga extends Especie{
    public Tartaruga() {
        identifier = 'T';
        name = "Tartaruga";
        image = "turtle.png";
        startEnergy = 150;
        energyConsumption = 1;
        energyGain = 5;
        minSpeed = 1;
        maxSpeed = 3;
    }
}
