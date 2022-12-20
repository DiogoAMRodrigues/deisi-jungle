package pt.ulusofona.lp2.deisiJungle.food;
import pt.ulusofona.lp2.deisiJungle.AnimalType;
import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Tabuleiro;

public class Agua extends Food {
    public Agua() {
        id = 'a';
        img = "water.png";
    }

    @Override
    public int getEatenSim(Jogador player, int turn) {
        AnimalType tipo = player.getSpecies().getTipoAnimal();
        int thisPlayersEnergy = player.getEnergy();
        int beginningEnergy = thisPlayersEnergy;
        if(tipo == AnimalType.CARNIVORO || tipo == AnimalType.HERBIVORO){
            thisPlayersEnergy += 15;
        }
        else{
            thisPlayersEnergy += (int) (thisPlayersEnergy * 0.2);
        }
        int lostEnergy = beginningEnergy - thisPlayersEnergy;
        return lostEnergy;
    }
    @Override
    public String getEaten(Tabuleiro tabuleiro){
        Jogador player = tabuleiro.getCurrentPlayer();
        int amntGained = 0;
        String tooltip = "";
        AnimalType tipo = player.getSpecies().getTipoAnimal();
        if(tipo == AnimalType.CARNIVORO || tipo == AnimalType.HERBIVORO){
            amntGained = 15;
            player.gainEnergy(amntGained);
            tooltip = "Agua : + " + amntGained + " energia";
        }
        else{
            amntGained = (int) (player.getEnergy()*0.2);
            player.gainEnergy(amntGained);
            tooltip = "Agua : + " + amntGained + "U|20% energia";
        }
        tooltip = "Apanhou Agua\n";
        return tooltip;
    }

}
