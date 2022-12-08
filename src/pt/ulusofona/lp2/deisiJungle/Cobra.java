package pt.ulusofona.lp2.deisiJungle;

public class Cobra extends Especie{
    public Cobra() {
        identifier = 'C';
        name = "Cobra";
        image = "snake.png";
        startEnergy = 100;
        energyConsumption = 10;
        energyGain = 30;
        minSpeed = 3;
        maxSpeed = 6;
    }
}
