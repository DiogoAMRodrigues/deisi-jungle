package pt.ulusofona.lp2.deisiJungle.Species;

import pt.ulusofona.lp2.deisiJungle.Codes.AnimalType;

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
        tipoAnimal = AnimalType.CARNIVORO;
    }
}
