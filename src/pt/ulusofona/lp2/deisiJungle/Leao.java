package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Leao extends Especie{
    public Leao() {
        identifier = 'L';
        name = "Leão";
        image = "lion.png";
        startEnergy = 80;
        energyConsumption = 2;
        energyGain = 10;
        minSpeed = 4;
        maxSpeed = 6;
    }

    @Override
    public int getSpeed(){
        Random randomNr = new Random();
        int randomSpeed = randomNr.nextInt(minSpeed,maxSpeed + 1);
        return randomSpeed;
    }
}
