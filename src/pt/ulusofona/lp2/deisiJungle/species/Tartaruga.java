package pt.ulusofona.lp2.deisiJungle.species;

import pt.ulusofona.lp2.deisiJungle.AnimalType;

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
        tipoAnimal = AnimalType.OMNIVORO;
    }
}
