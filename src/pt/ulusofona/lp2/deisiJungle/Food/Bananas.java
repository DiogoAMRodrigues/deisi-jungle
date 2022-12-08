package pt.ulusofona.lp2.deisiJungle.Food;

public class Bananas extends Food {

    int bananaAmount = 3;
    public Bananas() {
        id = 'b';
        img = "bananas.png";
    }

    @Override
    public void getEaten(Shrooms.Jogador player) {
        if(bananaAmount > 0){
            bananaAmount--;
            player.gainEnergy(40);

        }
    }
}
