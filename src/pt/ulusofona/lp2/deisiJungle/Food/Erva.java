package pt.ulusofona.lp2.deisiJungle.Food;

import pt.ulusofona.lp2.deisiJungle.Codes.AnimalType;
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
        if(tipo == AnimalType.OMNIVORO || tipo == AnimalType.HERBIVORO){
            player.gainEnergy(20);
        }
        else if(tipo == AnimalType.CARNIVORO){
            player.loseEnergy(20);
        }
        return player.getEnergy();
        //tooltip: "Erva : +- 20 energia"
    }

    @Override
    public String getEaten(Tabuleiro tabuleiro){

    }
}
