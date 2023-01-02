package pt.ulusofona.lp2.deisiJungle.species;

import pt.ulusofona.lp2.deisiJungle.AnimalType;

public class Passaro extends Especie{
    public Passaro() {
        identifier = 'P';
        name = "Passaro";
        image = "bird.png";
        startEnergy = 70;
        energyConsumption = 4;
        energyGain = 50;
        minSpeed = 5;
        maxSpeed = 6;
        tipoAnimal = AnimalType.OMNIVORO;
    }
}
