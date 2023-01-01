package pt.ulusofona.lp2.deisiJungle;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GameManager g = new GameManager();
        g.createInitialJungle(12, new String[][]{{"1", "Tiago", "E"}, {"2", "Tiadd", "L"}});

        g.moveCurrentPlayer(4, true);

        g.moveCurrentPlayer(4, true);

        for(int i = 0; i < g.getTabuleiro().getJogadores().size(); ++i){
            System.out.println(g.getTabuleiro().getJogadores().get(i).getEnergy());
        }

    }
}

