package pt.ulusofona.lp2.deisiJungle;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Tabuleiro tab = new Tabuleiro(10);
        GameManager asd = new GameManager();
        asd.createInitialJungle(10, new String[][]{{"1", "Joao","L"}, {"2", "Diogo", "E"}}, new String[][]{{"e","2"}});
        System.out.println(Arrays.deepToString(asd.getPlayersInfo()));


    }
}

