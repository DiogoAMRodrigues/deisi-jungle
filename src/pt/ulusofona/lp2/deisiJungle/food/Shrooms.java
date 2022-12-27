package pt.ulusofona.lp2.deisiJungle.food;

import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Tabuleiro;

import java.util.Random;

public class Shrooms extends Food {
    private int n;
    public Shrooms() {
        id = 'm';
        img = "mushroom.png";
        Random random = new Random();
        n = random.nextInt(41) + 10;
    }

    @Override
    public int getEatenSim(Jogador player, int turn) {
        double percentN =(double) n / 100;
        int thisPlayersEnergy = player.getEnergy();
        int beginningEnergy = thisPlayersEnergy;
        int amount = (int) (thisPlayersEnergy * (1+percentN));
        if (turn%2 == 0){
            thisPlayersEnergy += amount;
        }else {
            thisPlayersEnergy -= amount;
        }
        int lostEnergy = beginningEnergy - thisPlayersEnergy;

        return lostEnergy;
    }

    @Override
    public String getEaten(Tabuleiro tabuleiro){
        Jogador player = tabuleiro.getCurrentPlayer();
        int thisPlayersEnergy = player.getEnergy();
        double percentN =(double) n / 100;
        int turn = tabuleiro.getTurns();
        String tooltip = "";
        if (turn%2 == 0){
            player.gainEnergy((int) (thisPlayersEnergy * percentN));
            tooltip = "Cogumelo Magico: + " + n + "% energia";
        }else {
            player.loseEnergy((int) (thisPlayersEnergy * percentN));
            tooltip = "Cogumelo Magico: - " + n + "% energia";
        }
        tooltip = "Apanhou Cogumelo Magico";
        return tooltip;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String getToolTip(Tabuleiro tabuleiro){
        return "Cogumelo Magico : +- " + n + "% energia";
    }
}
