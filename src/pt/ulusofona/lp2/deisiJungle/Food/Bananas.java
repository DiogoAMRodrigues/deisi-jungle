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
    public void getEaten(Jogador player, Tabuleiro tabuleiro) {
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
        //tooltip: "Bananas : <N> : + 40 energia"       N = amnt of bananas
    }
}
