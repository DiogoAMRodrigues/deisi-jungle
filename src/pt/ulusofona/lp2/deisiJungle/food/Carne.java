package pt.ulusofona.lp2.deisiJungle.food;

import pt.ulusofona.lp2.deisiJungle.AnimalType;
import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Tabuleiro;

public class Carne extends Food {
    public Carne() {
        id = 'c';
        img = "meat.png";
    }

    @Override
    public int getEatenSim(Jogador player, int turn) {
        AnimalType tipo = player.getSpecies().getTipoAnimal();
        int thisPlayersEnergy = player.getEnergy();
        int beginningEnergy = thisPlayersEnergy;
        if (tipo != AnimalType.HERBIVORO ){
            if (turn <= 12){
                thisPlayersEnergy += 50;
            }else {
                thisPlayersEnergy /= 2;
            }
        }
        int lostEnergy = beginningEnergy - thisPlayersEnergy;
        return lostEnergy;
    }

    @Override
    public String getEaten(Tabuleiro tabuleiro){
        Jogador player = tabuleiro.getCurrentPlayer();
        AnimalType tipo = player.getSpecies().getTipoAnimal();
        String tooltip = "";
        int turns = tabuleiro.getTurns();
        if (tipo != AnimalType.HERBIVORO ){
            if (turns <= 12){
                player.gainEnergy(50);
                tooltip = "Carne : + 50 energia : "+ turns +" jogadas";
            }else {
                int thisPlayersEnergy = player.getEnergy();
                player.loseEnergy(thisPlayersEnergy/2);
                tooltip = "Carne : - 50 energia : Carne toxica jogadas";
            }
        }
        tooltip = "Apanhou Carne";
        return tooltip;
    }
}
