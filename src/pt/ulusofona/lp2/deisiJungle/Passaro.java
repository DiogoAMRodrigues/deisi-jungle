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

    @Override
    public int getSpeed(){
        Random randomNr = new Random();
        int randomSpeed = randomNr.nextInt(minSpeed,maxSpeed + 1);
        return randomSpeed;
    }

}
