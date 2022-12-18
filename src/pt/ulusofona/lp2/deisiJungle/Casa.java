package pt.ulusofona.lp2.deisiJungle;
import pt.ulusofona.lp2.deisiJungle.Food.Food;
import pt.ulusofona.lp2.deisiJungle.Food.Shrooms;

import java.util.ArrayList;

public class Casa {
    private ArrayList<Jogador> jogadores;

    private ArrayList<Food> comida;
    private boolean occupied;
    public Casa() {
        jogadores = new ArrayList<>();
        this.occupied = false;
        jogadores = new ArrayList<>();
        comida = new ArrayList<>();
    }
    public boolean isOccupied() {
        if (jogadores.isEmpty()) {
            return this.occupied = jogadores.size() > 0;
        }
        return false;
    }

    public void leaveHouse(Jogador player){
        jogadores.remove(player);
        if (jogadores.isEmpty()){
            this.occupied = false;
        }
    }
    public void addJogadorCasa(Jogador player){
        jogadores.add(player);
        this.occupied = true;
    }
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public ArrayList<Food> getComida() {
        return comida;
    }

    public boolean addComida(Food food){
        if (food != null){
            comida.add(food);
            return true;
        }
        return false;
    }
}
