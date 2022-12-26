package pt.ulusofona.lp2.deisiJungle;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        GameManager g = new GameManager();
        g.createInitialJungle(12, new String[][]{{"1", "Tiago", "E"}, {"2", "Tiadd", "L"}},
                new String[][]{{"a", "3"}});
        g.saveGame(new File("yes.txt"));
    }
}

