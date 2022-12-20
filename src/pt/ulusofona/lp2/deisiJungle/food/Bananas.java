package pt.ulusofona.lp2.deisiJungle.food;

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
        int thisPlayersEnergy = player.getEnergy();
        int beginningEnergy = thisPlayersEnergy;
        if(bananaAmount > 0){
            if (player.getHasEatenBanana()){
                thisPlayersEnergy -= bananaEnergy;
            }else {
                thisPlayersEnergy += bananaEnergy;
            }
        }
        int lostEnergy = beginningEnergy - thisPlayersEnergy;
        return lostEnergy;
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
        tooltip = "Apanhou Bananas";
        return tooltip;
    }
}
