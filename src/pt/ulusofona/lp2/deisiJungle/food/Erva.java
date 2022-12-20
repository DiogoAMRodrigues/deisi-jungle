package pt.ulusofona.lp2.deisiJungle.food;

import pt.ulusofona.lp2.deisiJungle.AnimalType;
import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Tabuleiro;

public class Erva extends Food{
    public Erva() {
        id = 'e';
        img = "grass.png";
    }

    @Override
    public int getEatenSim(Jogador player, int turn) {
        AnimalType tipo = player.getSpecies().getTipoAnimal();
        int thisPlayersEnergy = player.getEnergy();
        int beginningEnergy = thisPlayersEnergy;
        if(tipo == AnimalType.OMNIVORO || tipo == AnimalType.HERBIVORO){
            thisPlayersEnergy += 20;
        }
        else if(tipo == AnimalType.CARNIVORO){
            thisPlayersEnergy -= 20;
        }
        int lostEnergy = beginningEnergy - thisPlayersEnergy;
        return lostEnergy;
    }

    @Override
    public String getEaten(Tabuleiro tabuleiro){
        Jogador player = tabuleiro.getCurrentPlayer();
        AnimalType tipo = player.getSpecies().getTipoAnimal();
        String tooltip = "";
        if(tipo == AnimalType.OMNIVORO || tipo == AnimalType.HERBIVORO){
            player.gainEnergy(20);
            tooltip = "Erva : + 20 energia";
        }
        else if(tipo == AnimalType.CARNIVORO){
            player.loseEnergy(20);
            tooltip = "Erva : - 20 energia";
        }
        tooltip = "Apanhou Erva";
        return tooltip;
    }
}
