package pt.ulusofona.lp2.deisiJungle.Food;

import pt.ulusofona.lp2.deisiJungle.Casa;
import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Species.Especie;
import pt.ulusofona.lp2.deisiJungle.Tabuleiro;

import java.util.Random;

public class Shrooms extends Food {
    private int n;
    public Shrooms() {
        id = 'm';
        img = "mushroom.png";
        n = new Random().nextInt(10,51);
    }

    @Override
    public void getEaten(Jogador player, Tabuleiro tabuleiro) {
        int turn = tabuleiro.getTurns();
        int thisPlayersEnergy = player.getEnergy();
        double percentN = n / 100;
        if (turn%2 == 0){
            player.gainEnergy((int) (thisPlayersEnergy * percentN));
        }else {
            player.loseEnergy((int) (thisPlayersEnergy * percentN));
        }
        //tooltip: “Cogumelo Magico: +- <N>% energia"           N = n
    }
}
