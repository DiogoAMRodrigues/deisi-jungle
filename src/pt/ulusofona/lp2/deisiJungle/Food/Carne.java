package pt.ulusofona.lp2.deisiJungle.Food;

import pt.ulusofona.lp2.deisiJungle.Codes.AnimalType;
import pt.ulusofona.lp2.deisiJungle.GameManager;
import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Tabuleiro;

public class Carne extends Food {
    public Carne() {
        id = 'c';
        img = "meat.png";
    }

    @Override
    public void getEaten(Jogador player, Tabuleiro tabuleiro) {
        AnimalType tipo = player.getSpecies().getTipoAnimal();
        int turns = tabuleiro.getTurns();

        if (tipo != AnimalType.HERBIVORO ){
            if (turns <= 12){
                player.gainEnergy(50);
            }else {
                int thisPlayersEnergy = player.getEnergy();
                player.loseEnergy(thisPlayersEnergy/2);
            }
        }
        //tooltip: "Carne : +- 50 energia : <N> jogadas"        N = turns      if N > 12    tooltip:"Carne toxica"
    }
}
