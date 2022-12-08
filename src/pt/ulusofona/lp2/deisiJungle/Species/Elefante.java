package pt.ulusofona.lp2.deisiJungle.Species;

import pt.ulusofona.lp2.deisiJungle.Codes.AnimalType;

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
