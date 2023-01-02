package pt.ulusofona.lp2.deisiJungle.species;

import pt.ulusofona.lp2.deisiJungle.AnimalType;

public class Leao extends Especie{
    public Leao() {
        identifier = 'L';
        name = "Leao";
        image = "lion.png";
        startEnergy = 80;
        energyConsumption = 2;
        energyGain = 10;
        minSpeed = 4;
        maxSpeed = 6;
        tipoAnimal = AnimalType.CARNIVORO;
    }
}
