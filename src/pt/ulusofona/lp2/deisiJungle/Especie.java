package pt.ulusofona.lp2.deisiJungle;

import org.w3c.dom.ranges.Range;

import static java.lang.Math.random;

public abstract class Especie {
    char identifier;
    String name;
    String image;
    int startEnergy; //Max 200 never surpass 200
    int energyConsumption;
    int energyGain;
    int minSpeed;
    int maxSpeed;

    public abstract int getSpeed();
}
