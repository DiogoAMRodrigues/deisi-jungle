package pt.ulusofona.lp2.deisiJungle.Food;

import pt.ulusofona.lp2.deisiJungle.Codes.AnimalType;
import pt.ulusofona.lp2.deisiJungle.Jogador;

public class Erva extends Food{
    public Erva() {
        id = 'e';
        img = "grass.png";
    }

    @Override
    public void getEaten(Jogador player) {
        AnimalType tipo = player.getSpecies().getTipoAnimal();
        if(tipo == AnimalType.OMNIVORO || tipo == AnimalType.HERBIVORO){
            player.gainEnergy(20);
        }
        else if(tipo == AnimalType.CARNIVORO){
            player.loseEnergy(20);
        }
        //tooltip: "Erva : +- 20 energia"
    }
}
