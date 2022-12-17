package pt.ulusofona.lp2.deisiJungle.Food;

import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Tabuleiro;

public class Bananas extends Food {

    int bananaAmount = 3;
    public Bananas() {
        id = 'b';
        img = "bananas.png";
    }

    @Override
    public int getEatenSim(Jogador player, int turn) {
        int bananaEnergy = 40;
        if(bananaAmount > 0){
            if (player.getHasEatenBanana()){
                player.loseEnergy(bananaEnergy);
            }else {
                player.gainEnergy(bananaEnergy);
                player.eatBanana();
            }
            bananaAmount--;
        }
        return player.getEnergy();
        //tooltip: "Bananas : <N> : + 40 energia"       N = amnt of bananas
    }

    @Override
    public String getEaten(Tabuleiro tabuleiro){
        String tooltip = "";
        Jogador player = tabuleiro.getCurrentPlayer();
        int bananaEnergy = 40;
        if(bananaAmount > 0){
            if (player.getHasEatenBanana()){
                player.loseEnergy(bananaEnergy);
                tooltip = "Bananas : " + bananaAmount + " : - 40 energia";
            }else {
                player.gainEnergy(bananaEnergy);
                player.eatBanana();
                tooltip = "Bananas : " + bananaAmount + " : + 40 energia";
            }
            bananaAmount--;
        }
        return tooltip;
    }
}
