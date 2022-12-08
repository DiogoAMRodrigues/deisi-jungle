package pt.ulusofona.lp2.deisiJungle.Species;

import pt.ulusofona.lp2.deisiJungle.Codes.AnimalType;

public class Tarzan extends Especie{
    public Tarzan() {
        identifier = 'Z';
        name = "Tarzan";
        image = "tarzan.png";
        startEnergy = 70;
        energyConsumption = 2;
        energyGain = 20;
        minSpeed = 1;
        maxSpeed = 6;
        tipoAnimal = AnimalType.OMNIVORO;
    }
}
