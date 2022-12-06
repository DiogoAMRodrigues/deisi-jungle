package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Cobra extends Especie{
    public Cobra() {
        identifier = 'C';
        name = "Cobra";
        image = "snake.png";
        startEnergy = 100;
        energyConsumption = 10;
        energyGain = 30;
        minSpeed = 3;
        maxSpeed = 6;
    }

    @Override
    public int getSpeed(){
        Random randomNr = new Random();
        int randomSpeed = randomNr.nextInt(minSpeed,maxSpeed + 1);
        return randomSpeed;
    }
}
