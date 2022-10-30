package pt.ulusofona.lp2.deisiJungle;

import java.lang.reflect.Array;

public class GameManager {
    public GameManager() {
    }

    public String[][] getSpecies(){
        String[][] species = new String[6][3];
        species[0][0] = "E";
        species[0][1] = "Elefante";
        species[0][2] = "elephant.png";
        species[1][0] = "L";
        species[1][1] = "Leão";
        species[1][2] = "lion.png";
        species[2][0] = "T";
        species[2][1] = "Tartaruga";
        species[2][2] = "turtle.png";
        species[3][0] = "P";
        species[3][1] = "Passáro";
        species[3][2] = "bird.png";
        species[4][0] = "Z";
        species[4][1] = "Tarzan";
        species[4][2] = "tarzan.png";
        species[5][0] = "S";
        species[5][1] = "Cobra";
        species[5][2] = "snake.png";

        return species;
    }
}
