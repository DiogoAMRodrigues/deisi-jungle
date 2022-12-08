package pt.ulusofona.lp2.deisiJungle.Food;

import pt.ulusofona.lp2.deisiJungle.Jogador;

public class Bananas extends Food {

    int bananaAmount = 3;
    public Bananas() {
        id = 'b';
        img = "bananas.png";
    }

    @Override
    public void getEaten(Jogador player) {
        if(bananaAmount > 0){
            bananaAmount--;
            player.gainEnergy(40);

        }
    }
}
