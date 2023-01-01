package pt.ulusofona.lp2.deisiJungle.food;

import pt.ulusofona.lp2.deisiJungle.AnimalType;
import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Tabuleiro;

public class PoisonBerry extends Food {

    /*These Berries fall from trees and burn your skin, if eaten they will leave you
    with 10Hp, Omnivores will eat them only on odd turns*/

    public PoisonBerry(){
        id = 'p';
        img = "poisonBerry.png";
    }

    @Override
    public int getEatenSim(Jogador player, int turn) {
        AnimalType tipo = player.getSpecies().getTipoAnimal();
        int thisPlayersEnergy = player.getEnergy();
        if (tipo == AnimalType.CARNIVORO){
            thisPlayersEnergy -= 15;
        } else if (tipo == AnimalType.HERBIVORO) {
            thisPlayersEnergy = 10;
        } else if (turn % 2 == 1){
            thisPlayersEnergy = 10;
        } else {
            thisPlayersEnergy -= 15;
        }
        return thisPlayersEnergy;
    }

    @Override
    public String getEaten(Tabuleiro tabuleiro){
        Jogador thisPlayer = tabuleiro.getCurrentPlayer();
        AnimalType tipo = thisPlayer.getSpecies().getTipoAnimal();
        String amount = "";
        if (tipo == AnimalType.CARNIVORO){
            thisPlayer.loseEnergy(15);
            amount = "15";
        } else if (tipo == AnimalType.HERBIVORO) {
            thisPlayer.setEnergy(10);
            amount = "LOADS";
        } else if (tabuleiro.getTurns() % 2 == 1){
            thisPlayer.setEnergy(10);
            amount = "LOADS";
        } else {
            thisPlayer.loseEnergy(15);
            amount = "15";
        }
        return "This poisonous berry dealt " + amount + " of damage" ;
    }

    @Override
    public String getToolTip(Tabuleiro tabuleiro){
        return "Poison Berry: This one will sting!";
    }
}
