package pt.ulusofona.lp2.deisiJungle.Food;

import pt.ulusofona.lp2.deisiJungle.Codes.AnimalType;
import pt.ulusofona.lp2.deisiJungle.Jogador;
import pt.ulusofona.lp2.deisiJungle.Species.Especie;

public class Agua extends Food {
    public Agua() {
        id = 'a';
        img = "water.png";
    }

    @Override
    public void getEaten(Jogador player) {
        AnimalType tipo = player.getSpecies().getTipoAnimal();
        if(tipo == AnimalType.CARNIVORO || tipo == AnimalType.HERBIVORO){
            player.gainEnergy(15);
        }
        else if(tipo == AnimalType.OMNIVORO){
            player.gainEnergy((int) (player.getEnergy()*1.2));
        }
        //tooltip: "Agua : + 10U|20% energia"
    }
}
