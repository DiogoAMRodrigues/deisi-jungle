package pt.ulusofona.lp2.deisiJungle;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GameManager g = new GameManager();
        g.createInitialJungle(12, new String[][]{{"1", "Tiago", "E"}, {"2", "Tiadd", "L"}},
                new String[][]{{"a", "3"}, {"a", "4"}, {"e", "9"}});
        g.moveCurrentPlayer(3, false);
        g.moveCurrentPlayer(4, false);

        g.saveGame(new File("yes.txt"));
        g.loadGame(new File("yes.txt"));

        for(int i = 0; i < g.getTabuleiro().getSize(); ++i){
            System.out.println(g.getTabuleiro().getCasas()[i].getJogadores().size());
        }
    }
}

