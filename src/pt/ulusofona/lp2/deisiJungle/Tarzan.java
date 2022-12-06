package pt.ulusofona.lp2.deisiJungle;

import java.util.Random;

public class Tarzan extends Especie{
    public Tarzan() {
        identifier = 'T';
        name = "Tarzan";
        image = "tarzan.png";
        startEnergy = 70;
        energyConsumption = 2;
        energyGain = 20;
        minSpeed = 1;
        maxSpeed = 6;
    }

    @Override
    public int getSpeed(){
        Random randomNr = new Random();
        int randomSpeed = randomNr.nextInt(minSpeed,maxSpeed + 1);
        return randomSpeed;
    }
}
