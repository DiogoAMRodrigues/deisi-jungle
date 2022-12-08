package pt.ulusofona.lp2.deisiJungle.Species;

import pt.ulusofona.lp2.deisiJungle.Codes.AnimalType;

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
        tipoAnimal = AnimalType.OMNIVORO;
    }
}
