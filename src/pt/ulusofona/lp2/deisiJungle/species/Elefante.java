package pt.ulusofona.lp2.deisiJungle.species;

import pt.ulusofona.lp2.deisiJungle.AnimalType;

public class Elefante extends Especie{
    public Elefante() {
        identifier = 'E';
        name = "Elefante";
        image = "elephant.png";
        startEnergy = 180;
        energyConsumption = 4;
        energyGain = 10;
        minSpeed = 1;
        maxSpeed = 6;
        tipoAnimal = AnimalType.HERBIVORO;
    }
}
